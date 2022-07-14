package com.islandstudio.paradiseresort.core;

import com.islandstudio.paradiseresort.ParadiseResort;
import com.islandstudio.paradiseresort.ui.panels.ManageBookingDetailsUI;
import com.islandstudio.paradiseresort.ui.panels.ReceiptUI;
import com.islandstudio.paradiseresort.utils.filemanager.DataFiles;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class BookingDetailsHandler {
    /* This class is mainly used for booking details management */

    /* Booking details preparation */
    public static Map<String, String> prepareBookingDetails() {
        String search = ManageBookingDetailsUI.getSearchField().getText();

        Map<String, String> bookingDetails = new TreeMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(DataFiles.BOOKING.getFile()));

            for (String line : reader.lines().toList()) {
                List<String> data = Arrays.stream(line.split(ParadiseResort.getDataDelimiter(), 2)).toList();

                if (search.isBlank() || search.isEmpty()) {
                    bookingDetails.put(data.get(0), data.get(1));
                    continue;
                }

                if (Arrays.stream(data.get(1).split(ParadiseResort.getDataDelimiter())).toList().contains(search)) {
                    bookingDetails.put(data.get(0), data.get(1));
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookingDetails;
    }

    /* Receipt details preparation */
    public static Map<String, String> prepareReceipt() {
        String search = ReceiptUI.getSearchField().getText();

        Map<String, String> receipt = new TreeMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(DataFiles.RECEIPT.getFile()));

            for (String line : reader.lines().toList()) {
                List<String> data = Arrays.stream(line.split(ParadiseResort.getDataDelimiter(), 3)).toList();

                if (search.isBlank() || search.isEmpty()) {
                    receipt.put(data.get(1), data.get(0) + ParadiseResort.getDataDelimiter() + data.get(2));
                    continue;
                }

                if (Arrays.stream(data.get(2).split(ParadiseResort.getDataDelimiter())).toList().contains(search) || data.get(0).equals(search)) {
                    receipt.put(data.get(1), data.get(0) + ParadiseResort.getDataDelimiter() + data.get(2));
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receipt;
    }

    /* Save booking details when staff modified customer booking details */
    public static void saveBookingDetails() {
        String customerIC = ManageBookingDetailsUI.getCustomerIC().getText();
        String customerName = ManageBookingDetailsUI.getCustomerName().getText();
        String customerContact = ManageBookingDetailsUI.getCustomerContact().getText();
        String customerEmail = ManageBookingDetailsUI.getCustomerEmail().getText();

        if (customerIC.isBlank() || customerName.isBlank() || customerContact.isBlank() || customerEmail.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerIC.matches("[0-9]{12}")) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct IC format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (customerName.length() > 255) {
            JOptionPane.showMessageDialog(null, "Customer name cannot be more than 255 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerContact.matches("[0-9\\-]{11}")) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct contact format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerEmail.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct email format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTable table = ManageBookingDetailsUI.getBookingDetailTable();
        String selectedBookingUUID = (String) table.getValueAt(table.getSelectedRow(), 0);

        Map<String, String> bookingDetails = prepareBookingDetails();
        Map<String, String> receipt = prepareReceipt();

        if (bookingDetails.containsKey(selectedBookingUUID)) {
            String[] data = bookingDetails.get(selectedBookingUUID).split(ParadiseResort.getDataDelimiter());
            data[0] = customerIC;
            data[1] = customerName;
            data[2] = customerContact;
            data[3] = customerEmail;

            bookingDetails.replace(selectedBookingUUID, String.join(ParadiseResort.getDataDelimiter(), data));
        }

        if (receipt.containsKey(selectedBookingUUID)) {
            String[] data = receipt.get(selectedBookingUUID).split(ParadiseResort.getDataDelimiter());

            data[1] = customerIC;
            data[2] = customerName;
            data[3] = customerContact;
            data[4] = customerEmail;

            receipt.replace(selectedBookingUUID, String.join(ParadiseResort.getDataDelimiter(), data));
        }

        try {
            BufferedWriter writer_1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DataFiles.BOOKING.getFile())));
            BufferedWriter writer_2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DataFiles.RECEIPT.getFile())));

            for (Map.Entry<String, String> entry : bookingDetails.entrySet()) {
                if (bookingDetails.entrySet().stream().toList().indexOf(entry) != bookingDetails.size() - 1) {
                    writer_1.write(entry.getKey() + ParadiseResort.getDataDelimiter() + entry.getValue() + "\n");
                    continue;
                }

                writer_1.write(entry.getKey() + ParadiseResort.getDataDelimiter() + entry.getValue());
            }

            for (Map.Entry<String, String> entry : receipt.entrySet()) {
                if (receipt.entrySet().stream().toList().indexOf(entry) != receipt.size() - 1) {
                    String[] data = entry.getValue().split(ParadiseResort.getDataDelimiter(), 2);

                    if (receipt.entrySet().stream().toList().indexOf(entry) != receipt.size() - 1) {
                        writer_2.write(data[0] + ParadiseResort.getDataDelimiter() + entry.getKey() + ParadiseResort.getDataDelimiter() + data[1] + "\n");
                        continue;
                    }

                    writer_2.write(data[0] + ParadiseResort.getDataDelimiter() + entry.getKey() + ParadiseResort.getDataDelimiter() + data[1]);
                }
            }

            writer_1.close();
            writer_2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Perform booking details removal inside the data files */
    public static void removeBookingDetails(String type) {
        JTable table = ManageBookingDetailsUI.getBookingDetailTable();
        String selectedBookingUUID = (String) table.getValueAt(table.getSelectedRow(), 0);

        Map<String, String> bookingDetails = prepareBookingDetails();
        Map<String, String> receipt = prepareReceipt();

        bookingDetails.remove(selectedBookingUUID);
        receipt.remove(selectedBookingUUID);

        try {
            BufferedWriter writer_1;
            BufferedWriter writer_2;

            if (type.equals("remove")) {
                writer_1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DataFiles.BOOKING.getFile())));
                writer_2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DataFiles.RECEIPT.getFile())));

                for (Map.Entry<String, String> entry : bookingDetails.entrySet()) {
                    if (bookingDetails.entrySet().stream().toList().indexOf(entry) != bookingDetails.size() - 1) {
                        writer_1.write(entry.getKey() + ParadiseResort.getDataDelimiter() + entry.getValue() + "\n");
                        continue;
                    }

                    writer_1.write(entry.getKey() + ParadiseResort.getDataDelimiter() + entry.getValue());
                }

                for (Map.Entry<String, String> entry : receipt.entrySet()) {
                    String[] data = entry.getValue().split(ParadiseResort.getDataDelimiter(), 2);

                    if (receipt.entrySet().stream().toList().indexOf(entry) != receipt.size() - 1) {
                        writer_2.write(data[0] + ParadiseResort.getDataDelimiter() + entry.getKey() + ParadiseResort.getDataDelimiter() + data[1] + "\n");
                        continue;
                    }

                    writer_2.write(data[0] + ParadiseResort.getDataDelimiter() + entry.getKey() + ParadiseResort.getDataDelimiter() + data[1]);
                }

                writer_1.close();
                writer_2.close();
            }

            if (type.equals("checkout")) {
                writer_1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DataFiles.BOOKING.getFile())));

                for (Map.Entry<String, String> entry : bookingDetails.entrySet()) {
                    if (bookingDetails.entrySet().stream().toList().indexOf(entry) != bookingDetails.size() - 1) {
                        writer_1.write(entry.getKey() + ParadiseResort.getDataDelimiter() + entry.getValue() + "\n");
                        continue;
                    }

                    writer_1.write(entry.getKey() + ParadiseResort.getDataDelimiter() + entry.getValue());
                }
                writer_1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
