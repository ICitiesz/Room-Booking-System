package com.islandstudio.paradiseresort.utils;

import com.islandstudio.paradiseresort.ParadiseResort;
import com.islandstudio.paradiseresort.utils.filemanager.DataFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class IDGenerator {
    /* This class is mainly used for generate bookingUUID and receiptID/receipt number */

    public static String generateBookingUUID() {
        String bookingUUID = UUID.randomUUID().toString().replace("-", "");

        try {
            while (hasID(bookingUUID, "booking")) {
                bookingUUID = UUID.randomUUID().toString().replace("-", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookingUUID;
    }

    public static String generateReceiptID() {
        String receiptID = "RCP1" + new Random().nextInt(999999);

        try {
            while (hasID(receiptID, "receipt")) {
                receiptID = "RCP1" + new Random().nextInt(999999);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiptID;
    }

    /* This method is used to check either the generated ID exists in the booking.txt and the receipt.txt */
    private static boolean hasID(String id, String idType) throws IOException {
        BufferedReader reader_1;
        BufferedReader reader_2;

        if (idType.equals("booking")) {
            reader_1 = new BufferedReader(new FileReader(DataFiles.BOOKING.getFile()));
            reader_2 = new BufferedReader(new FileReader(DataFiles.RECEIPT.getFile()));

            boolean isFound_1 = false;
            boolean isFound_2 = false;

            for (String line : reader_1.lines().toArray(String[]::new)) {
                if (line.split(ParadiseResort.getDataDelimiter())[0].equals(id)) {
                    isFound_1 = true;

                    break;
                }
            }

            for (String line : reader_2.lines().toArray(String[]::new)) {
                if (line.split(ParadiseResort.getDataDelimiter())[0].equals(id)) {
                    isFound_2 = true;
                    break;
                }
            }

            reader_1.close();
            reader_2.close();

            return isFound_1 || isFound_2;
        }

        if (idType.equals("receipt")) {
            reader_1 = new BufferedReader(new FileReader(DataFiles.RECEIPT.getFile()));

            for (String line : reader_1.lines().toArray(String[]::new)) {
                if (line.split(ParadiseResort.getDataDelimiter())[1].equals(id)) {
                    reader_1.close();
                    return true;
                }
            }
        }

        return false;
    }

}
