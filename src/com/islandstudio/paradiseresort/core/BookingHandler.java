package com.islandstudio.paradiseresort.core;

import com.islandstudio.paradiseresort.ParadiseResort;
import com.islandstudio.paradiseresort.ui.UIHandler;
import com.islandstudio.paradiseresort.ui.panels.BookingUI;
import com.islandstudio.paradiseresort.utils.IDGenerator;
import com.islandstudio.paradiseresort.utils.filemanager.DataFiles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BookingHandler {
    /* Per-booking operation  */
    public static void book() {
        String checkInDate = BookingUI.getCheckInDate().getDateStringOrEmptyString();
        String checkOutDate = BookingUI.getCheckOutDate().getDateStringOrEmptyString();
        String customerIC = BookingUI.getCustomerIC().getText();
        String customerName = BookingUI.getCustomerName().getText();
        String customerContact = BookingUI.getCustomerContact().getText();
        String customerEmail = BookingUI.getCustomerEmail().getText();
        String customerRoom = BookingUI.getCustomerRoom().getText();
        String customerRoomType = BookingUI.getCustomerRoomType().getText();

        /* Check every field is empty or is blank */
        if (UserHandler.verifyField(checkInDate) || UserHandler.verifyField(checkOutDate)
                || UserHandler.verifyField(customerIC) || UserHandler.verifyField(customerName)
                || UserHandler.verifyField(customerContact) || UserHandler.verifyField(customerEmail)
                || UserHandler.verifyField(customerRoom) || UserHandler.verifyField(customerRoomType)) {
            JOptionPane.showMessageDialog(null, "Please fill in all required field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Verify IC/Passport number format  */
        if (!customerIC.matches("[0-9]{12}")) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct IC format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Verify name length */
        if (customerName.length() > 255) {
            JOptionPane.showMessageDialog(null, "Customer name cannot be more than 255 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Verify contact format */
        if (!customerContact.matches("[0-9\\-]{11}")) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct contact format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Verify email format */
        if (!customerEmail.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct email format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Booking confirmation */
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to book this room?", "Room Booking Confirmation", JOptionPane.YES_NO_OPTION)) {
            addBooking(checkInDate, checkOutDate);
            JOptionPane.showMessageDialog(null, "Booking Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", BookingUI.getBookBTN())).getContentPane();
            UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "home");
        }
    }

    /* Perform check room operations which filter out the room according to the date */
    public static void checkRoom() {
        String checkInDate = BookingUI.getCheckInDate().getDateStringOrEmptyString();
        String checkOutDate = BookingUI.getCheckOutDate().getDateStringOrEmptyString();

        if (UserHandler.verifyField(checkInDate) || UserHandler.verifyField(checkOutDate)) {
            JOptionPane.showMessageDialog(null, "Please fill in check in date and check out date!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            LocalDate date_1 = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate date_2 = LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            DefaultTableModel tableModel = (DefaultTableModel) BookingUI.getRoomTable().getModel();
            JTextField customerRoom = BookingUI.getCustomerRoom();
            JTextField customerRoomType = BookingUI.getCustomerRoomType();
            JTextField total = BookingUI.getTotal();
            JTextField serviceTax = BookingUI.getServiceTax();
            JTextField tourismTax = BookingUI.getTourismTax();
            JTextField grandTotal = BookingUI.getGrandTotal();
            JTextField totalNights = BookingUI.getTotalNights();

            if (verifyDate(date_1) || verifyDate(date_2)) {
                JOptionPane.showMessageDialog(null, "The date must not before today's date!", "Error", JOptionPane.ERROR_MESSAGE);
                tableModel.setRowCount(0);
                customerRoom.setText("");
                customerRoomType.setText("");
                total.setText("");
                serviceTax.setText("");
                tourismTax.setText("");
                grandTotal.setText("");
                totalNights.setText("");
                return;
            }

            if (date_1.equals(date_2)) {
                JOptionPane.showMessageDialog(null, "Check in date and check out date must not be the same!", "Error", JOptionPane.ERROR_MESSAGE);
                tableModel.setRowCount(0);
                customerRoom.setText("");
                customerRoomType.setText("");
                total.setText("");
                serviceTax.setText("");
                tourismTax.setText("");
                grandTotal.setText("");
                totalNights.setText("");
                return;
            }

            if (date_1.isAfter(date_2)) {
                JOptionPane.showMessageDialog(null, "Check in date must not be after check out date!", "Error", JOptionPane.ERROR_MESSAGE);
                tableModel.setRowCount(0);
                customerRoom.setText("");
                customerRoomType.setText("");
                total.setText("");
                serviceTax.setText("");
                tourismTax.setText("");
                grandTotal.setText("");
                totalNights.setText("");
                return;
            }

            if (ChronoUnit.DAYS.between(date_1, date_2) > 7) {
                JOptionPane.showMessageDialog(null, "The booking period must not exceed 7 days!", "Error", JOptionPane.ERROR_MESSAGE);
                tableModel.setRowCount(0);
                customerRoom.setText("");
                customerRoomType.setText("");
                total.setText("");
                serviceTax.setText("");
                tourismTax.setText("");
                grandTotal.setText("");
                totalNights.setText("");
                return;
            }

            tableModel.setRowCount(0);
            customerRoom.setText("");
            customerRoomType.setText("");
            total.setText("");
            serviceTax.setText("");
            tourismTax.setText("");
            grandTotal.setText("");
            totalNights.setText(String.valueOf(getNights()));

            RoomHandler.prepareRoom(date_1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), date_2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct date format!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /* Post-booking operation which write data to booking.txt */
    private static void addBooking(String checkInDate, String checkOutDate) {
        LocalDate date_1 = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate date_2 = LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String bookingUUID = IDGenerator.generateBookingUUID();
        String customerIC = BookingUI.getCustomerIC().getText();
        String customerName = BookingUI.getCustomerName().getText();
        String customerContact = BookingUI.getCustomerContact().getText();
        String customerEmail = BookingUI.getCustomerEmail().getText();
        String customerRoom = BookingUI.getCustomerRoom().getText();
        String customerRoomType = BookingUI.getCustomerRoomType().getText();

        String total = BookingUI.getTotal().getText().replace(",", "");
        String serviceTax = BookingUI.getServiceTax().getText().replace(",", "");
        String tourismTax = BookingUI.getTourismTax().getText().replace(",", "");
        String grandTotal = BookingUI.getGrandTotal().getText().replace(",", "");

        String totalNights = BookingUI.getTotalNights().getText() + " nights";

        String bookingDetails = bookingUUID + ParadiseResort.getDataDelimiter() + customerIC + ParadiseResort.getDataDelimiter()
                + customerName + ParadiseResort.getDataDelimiter() + customerContact + ParadiseResort.getDataDelimiter()
                + customerEmail + ParadiseResort.getDataDelimiter() + customerRoom + ParadiseResort.getDataDelimiter()
                + customerRoomType + ParadiseResort.getDataDelimiter() + date_1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ParadiseResort.getDataDelimiter() + date_2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ParadiseResort.getDataDelimiter() + totalNights
                + ParadiseResort.getDataDelimiter() + total + ParadiseResort.getDataDelimiter() + serviceTax
                + ParadiseResort.getDataDelimiter() + tourismTax + ParadiseResort.getDataDelimiter() + grandTotal;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DataFiles.BOOKING.getFile(), true));

            writer.newLine();
            writer.write(bookingDetails);
            writer.close();

            addReceipt(bookingDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Post-booking operation which write data receipt.txt  */
    private static void addReceipt(String bookingDetails) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(DataFiles.RECEIPT.getFile(), true));

        writer.newLine();
        writer.write(IDGenerator.generateReceiptID() + ParadiseResort.getDataDelimiter() + bookingDetails);
        writer.close();
    }

    /* Verify date if is before the today's date */
    private static boolean verifyDate(LocalDate date) {
        try {
            return date.isBefore(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /* Get the total nights based the selected check in date and check out date */
    public static int getNights() {
        LocalDate date_1 = LocalDate.parse(BookingUI.getCheckInDate().getDateStringOrEmptyString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate date_2 = LocalDate.parse(BookingUI.getCheckOutDate().getDateStringOrEmptyString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return (int) ChronoUnit.DAYS.between(date_1, date_2);
    }

    /* ------------------- Charges calculation ------------------------------- */
    public static int calculateTotal(int roomPrice, int night) {
        return roomPrice * night;
    }

    public static int calculateServiceTax(int total) {
        return (int) (total * 0.10);
    }

    public static int calculateTourismTax(int nights) {
        return nights * 10;
    }

    public static int calculateGrandTotal(int total, int serviceTax, int tourismTax) {
        return total + serviceTax + tourismTax;
    }
    /*--------------------------------------------------------------------------*/
}
