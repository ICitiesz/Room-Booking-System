package com.islandstudio.paradiseresort.ui;

import com.islandstudio.paradiseresort.ParadiseResort;
import com.islandstudio.paradiseresort.core.BookingDetailsHandler;
import com.islandstudio.paradiseresort.core.BookingHandler;
import com.islandstudio.paradiseresort.core.RoomHandler;
import com.islandstudio.paradiseresort.ui.panels.BookingUI;
import com.islandstudio.paradiseresort.ui.panels.ManageBookingDetailsUI;
import com.islandstudio.paradiseresort.ui.panels.SplashLoading;
import com.islandstudio.paradiseresort.ui.panels.ReceiptUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class UIHandler {
    /* This class is mainly used for UI operations */

    /* Perform panel switching when certain clicked */
    public static void switchPanel(Container container, CardLayout cardLayout, String panelName) {
        cardLayout.show(container, panelName);
    }

    /* This method used to render the loading bar and percentage in the splash screen while the program starts */
    public static void renderSplash() {
        try {
            int index = 0;

            for (int i = 0; i < 101; i++) {
                Thread.sleep(40);

                index = i;
                SplashLoading.loadingPercent.setText(i + "%");
                SplashLoading.loadingBar.setValue(i);
            }

            if (index == 100) {
                Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", SplashLoading.loadingBar)).getContentPane();
                switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(),"login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Render the view details panel based on the selected table row within the booking room section */
    public static void setBookingDetails(Object source) {
        if (!source.equals(BookingUI.getRoomTable())) return;

        JTable table = (JTable) source;

        String selectedRoom = (String) table.getValueAt(table.getSelectedRow(), 0);

        AtomicBoolean isSelected = new AtomicBoolean(false);

        RoomHandler.getRoomData().forEach((roomID, roomDetail) -> {
            if (roomID.equals(selectedRoom)) {
                int roomPrice = Integer.parseInt(roomDetail.split(ParadiseResort.getDataDelimiter())[1].split(" ")[1].split("\\.")[0]);
                DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

                String totalInCurrency = "RM " + decimalFormat.format(BookingHandler.calculateTotal(BookingHandler.getNights(), roomPrice));
                String serviceTaxInCurrency = "RM " + decimalFormat.format(BookingHandler.calculateServiceTax(BookingHandler.calculateTotal(BookingHandler.getNights(), roomPrice)));
                String tourismTaxInCurrency = "RM " + decimalFormat.format(BookingHandler.calculateTourismTax(BookingHandler.getNights()));
                String grandTotalInCurrency = "RM " + decimalFormat.format(BookingHandler.calculateGrandTotal(BookingHandler.calculateTotal(BookingHandler.getNights(),
                                            roomPrice), BookingHandler.calculateServiceTax(BookingHandler.calculateTotal(BookingHandler.getNights(),
                                            roomPrice)), BookingHandler.calculateTourismTax(BookingHandler.getNights())));

                BookingUI.getCustomerRoom().setText(roomID);
                BookingUI.getCustomerRoomType().setText(roomDetail.split(ParadiseResort.getDataDelimiter())[0]);
                BookingUI.getTotal().setText(totalInCurrency);
                BookingUI.getServiceTax().setText(serviceTaxInCurrency);
                BookingUI.getTourismTax().setText(tourismTaxInCurrency);
                BookingUI.getGrandTotal().setText(grandTotalInCurrency);

                isSelected.set(true);
            }
        });

        if (isSelected.get()) return;

        BookingUI.getCustomerRoom().setText("");
        BookingUI.getCustomerRoomType().setText("");
        BookingUI.getTotal().setText("");
        BookingUI.getServiceTax().setText("");
        BookingUI.getTourismTax().setText("");
        BookingUI.getGrandTotal().setText("");
    }

    /* Render the view details panel based on the selected table row within the manage booking details section */
    public static void setManageBookingDetails(Object source) {
        if (!source.equals(ManageBookingDetailsUI.getBookingDetailTable())) return;

        JTable table = (JTable) source;

        String selectedBookingDetail = (String) table.getValueAt(table.getSelectedRow(), 0);

        AtomicBoolean isSelected = new AtomicBoolean(false);

        BookingDetailsHandler.prepareBookingDetails().forEach((bookingUUID, bookingDetail) -> {
            if (bookingUUID.equals(selectedBookingDetail)) {
                String[] bookingDetailArray = bookingDetail.split(ParadiseResort.getDataDelimiter());

                ManageBookingDetailsUI.getCustomerIC().setText(bookingDetailArray[0]);
                ManageBookingDetailsUI.getCustomerName().setText(bookingDetailArray[1]);
                ManageBookingDetailsUI.getCustomerContact().setText(bookingDetailArray[2]);
                ManageBookingDetailsUI.getCustomerEmail().setText(bookingDetailArray[3]);
                ManageBookingDetailsUI.getCustomerRoom().setText(bookingDetailArray[4]);
                ManageBookingDetailsUI.getCustomerRoomType().setText(bookingDetailArray[5]);
                ManageBookingDetailsUI.getCustomerCheckInDate().setText(bookingDetailArray[6]);
                ManageBookingDetailsUI.getCustomerCheckOutDate().setText(bookingDetailArray[7]);
                ManageBookingDetailsUI.getTotalNights().setText(bookingDetailArray[8].split(" ")[0]);
                ManageBookingDetailsUI.getTotal().setText(bookingDetailArray[9]);
                ManageBookingDetailsUI.getServiceTax().setText(bookingDetailArray[10]);
                ManageBookingDetailsUI.getTourismTax().setText(bookingDetailArray[11]);
                ManageBookingDetailsUI.getGrandTotal().setText(bookingDetailArray[12]);

                isSelected.set(true);
            }
        });

        if (isSelected.get()) return;

        ManageBookingDetailsUI.getCustomerIC().setText("");
        ManageBookingDetailsUI.getCustomerName().setText("");
        ManageBookingDetailsUI.getCustomerContact().setText("");
        ManageBookingDetailsUI.getCustomerEmail().setText("");
        ManageBookingDetailsUI.getCustomerRoom().setText("");
        ManageBookingDetailsUI.getCustomerRoomType().setText("");
        ManageBookingDetailsUI.getCustomerCheckInDate().setText("");
        ManageBookingDetailsUI.getCustomerCheckOutDate().setText("");
        ManageBookingDetailsUI.getTotalNights().setText("");
        ManageBookingDetailsUI.getTotal().setText("");
        ManageBookingDetailsUI.getServiceTax().setText("");
        ManageBookingDetailsUI.getTourismTax().setText("");
        ManageBookingDetailsUI.getGrandTotal().setText("");
    }

    /* Render the view details panel based on the selected table row within the receipt section */
    public static void setReceiptDetails(Object source) {
        if (!source.equals(ReceiptUI.getReceiptTable())) return;

        JTable table = (JTable) source;

        String selectedReceipt = (String) table.getValueAt(table.getSelectedRow(), 0);

        AtomicBoolean isSelected = new AtomicBoolean(false);

        BookingDetailsHandler.prepareReceipt().forEach((bookingUUID, receiptDetail) -> {
            if (bookingUUID.equals(selectedReceipt)) {
                String[] receiptDetailArray = receiptDetail.split(ParadiseResort.getDataDelimiter());

                ReceiptUI.getReceiptNoField().setText(receiptDetailArray[0]);
                ReceiptUI.getCustomerICField().setText(receiptDetailArray[1]);
                ReceiptUI.getCustomerNameField().setText(receiptDetailArray[2]);
                ReceiptUI.getCustomerContactField().setText(receiptDetailArray[3]);
                ReceiptUI.getCustomerEmailField().setText(receiptDetailArray[4]);
                ReceiptUI.getRoomField().setText(receiptDetailArray[5]);
                ReceiptUI.getRoomTypeField().setText(receiptDetailArray[6]);
                ReceiptUI.getCheckInDateField().setText(receiptDetailArray[7]);
                ReceiptUI.getCheckOutDateField().setText(receiptDetailArray[8]);
                ReceiptUI.getTotalNightsField().setText(receiptDetailArray[9].split(" ")[0]);
                ReceiptUI.getTotalField().setText(receiptDetailArray[10]);
                ReceiptUI.getServiceTaxField().setText(receiptDetailArray[11]);
                ReceiptUI.getTourismTaxField().setText(receiptDetailArray[12]);
                ReceiptUI.getGrandTotalField().setText(receiptDetailArray[13]);

                isSelected.set(true);
            }
        });

        if (isSelected.get()) return;

        ReceiptUI.getReceiptNoField().setText("");
        ReceiptUI.getCustomerICField().setText("");
        ReceiptUI.getCustomerNameField().setText("");
        ReceiptUI.getCustomerContactField().setText("");
        ReceiptUI.getCustomerEmailField().setText("");
        ReceiptUI.getRoomField().setText("");
        ReceiptUI.getRoomTypeField().setText("");
        ReceiptUI.getCheckInDateField().setText("");
        ReceiptUI.getCheckOutDateField().setText("");
        ReceiptUI.getTotalNightsField().setText("");
        ReceiptUI.getTotalField().setText("");
        ReceiptUI.getServiceTaxField().setText("");
        ReceiptUI.getTourismTaxField().setText("");
        ReceiptUI.getGrandTotalField().setText("");
    }

    /* ---------------------------------------- Field cleaning operation ------------------------------------ */
    public static void clearBookingDetails() {
        ((DefaultTableModel) BookingUI.getRoomTable().getModel()).setRowCount(0);
        BookingUI.getCheckInDate().setText("");
        BookingUI.getCheckOutDate().setText("");
        BookingUI.getTotalNights().setText("");
        BookingUI.getCustomerIC().setText("");
        BookingUI.getCustomerName().setText("");
        BookingUI.getCustomerContact().setText("");
        BookingUI.getCustomerEmail().setText("");
        BookingUI.getCustomerRoom().setText("");
        BookingUI.getCustomerRoomType().setText("");
        BookingUI.getTotal().setText("");
        BookingUI.getServiceTax().setText("");
        BookingUI.getTourismTax().setText("");
        BookingUI.getGrandTotal().setText("");
    }

    public static void clearManageBookingDetails() {
        ((DefaultTableModel) ManageBookingDetailsUI.getBookingDetailTable().getModel()).setRowCount(0);
        ManageBookingDetailsUI.getSearchField().setText("");
        UIHandler.renderBookingDetailsTable();
        ManageBookingDetailsUI.getCustomerIC().setText("");
        ManageBookingDetailsUI.getCustomerName().setText("");
        ManageBookingDetailsUI.getCustomerContact().setText("");
        ManageBookingDetailsUI.getCustomerEmail().setText("");
        ManageBookingDetailsUI.getCustomerRoom().setText("");
        ManageBookingDetailsUI.getCustomerRoomType().setText("");
        ManageBookingDetailsUI.getCustomerCheckInDate().setText("");
        ManageBookingDetailsUI.getCustomerCheckOutDate().setText("");
        ManageBookingDetailsUI.getTotalNights().setText("");
        ManageBookingDetailsUI.getTotal().setText("");
        ManageBookingDetailsUI.getServiceTax().setText("");
        ManageBookingDetailsUI.getTourismTax().setText("");
        ManageBookingDetailsUI.getGrandTotal().setText("");
    }

    public static void clearReceiptDetails() {
        ((DefaultTableModel) ReceiptUI.getReceiptTable().getModel()).setRowCount(0);
        UIHandler.renderReceiptTable();
        ReceiptUI.getSearchField().setText("");
        ReceiptUI.getReceiptNoField().setText("");
        ReceiptUI.getCustomerICField().setText("");
        ReceiptUI.getCustomerNameField().setText("");
        ReceiptUI.getCustomerContactField().setText("");
        ReceiptUI.getCustomerEmailField().setText("");
        ReceiptUI.getRoomField().setText("");
        ReceiptUI.getRoomTypeField().setText("");
        ReceiptUI.getCheckInDateField().setText("");
        ReceiptUI.getCheckOutDateField().setText("");
        ReceiptUI.getTotalNightsField().setText("");
        ReceiptUI.getTotalField().setText("");
        ReceiptUI.getServiceTaxField().setText("");
        ReceiptUI.getTourismTaxField().setText("");
        ReceiptUI.getGrandTotalField().setText("");
    }
    /*--------------------------------------------------------------------------------------------------------*/

    /* --------------------------------------------- Table rendering ---------------------------------------- */
    public static void renderBookingDetailsTable() {
        DefaultTableModel tableModel = (DefaultTableModel) ManageBookingDetailsUI.getBookingDetailTable().getModel();
        tableModel.setRowCount(0);

        for (Map.Entry<String, String> entry : BookingDetailsHandler.prepareBookingDetails().entrySet()) {
            String bookingUUID = entry.getKey();
            String[] bookingDetail = entry.getValue().split(ParadiseResort.getDataDelimiter());

            tableModel.addRow(new Object[] {
                    bookingUUID,
                    bookingDetail[0],
                    bookingDetail[1],
                    bookingDetail[2],
                    bookingDetail[3],
                    bookingDetail[4],
                    bookingDetail[5],
                    bookingDetail[6],
                    bookingDetail[7],
                    bookingDetail[8],
                    bookingDetail[9],
                    bookingDetail[10],
                    bookingDetail[11],
                    bookingDetail[12]
            });
        }
    }

    public static void renderReceiptTable() {
        DefaultTableModel tableModel = (DefaultTableModel) ReceiptUI.getReceiptTable().getModel();
        tableModel.setRowCount(0);

        for (Map.Entry<String, String> entry : BookingDetailsHandler.prepareReceipt().entrySet()) {
            String bookingUUID = entry.getKey();
            String[] receiptDetail = entry.getValue().split(ParadiseResort.getDataDelimiter());

            tableModel.addRow(new Object[] {
                    bookingUUID,
                    receiptDetail[0],
                    receiptDetail[1],
                    receiptDetail[2],
                    receiptDetail[3],
                    receiptDetail[4],
                    receiptDetail[5],
                    receiptDetail[6],
                    receiptDetail[7],
                    receiptDetail[8],
                    receiptDetail[9],
                    receiptDetail[10],
                    receiptDetail[11],
                    receiptDetail[12],
                    receiptDetail[13]
            });
        }
    }

    public static void renderRoomTable() {
        DefaultTableModel tableModel = (DefaultTableModel) BookingUI.getRoomTable().getModel();

        if (tableModel.getRowCount() > 0) {
            tableModel.setRowCount(0);
        }

        for (Map.Entry<String, String> entry : RoomHandler.getRoomData().entrySet()) {
            String roomID = entry.getKey();
            String[] roomDetails = entry.getValue().split(ParadiseResort.getDataDelimiter());

            tableModel.addRow(new Object[] {roomID, roomDetails[0], roomDetails[1]});
        }
    }

    /*--------------------------------------------------------------------------------------------------------*/
}
