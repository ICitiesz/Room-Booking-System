package com.islandstudio.paradiseresort.core;

import com.islandstudio.paradiseresort.ParadiseResort;
import com.islandstudio.paradiseresort.ui.UIHandler;
import com.islandstudio.paradiseresort.utils.filemanager.DataFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class RoomHandler {
    /* This class is mainly used for all sort of room operations. */

    private static Map<String, String> extRoomData = new TreeMap<>();

    /* Room ID preparation */
    public static void prepareRoom(String checkInDate, String checkOutDate) {
        try {
            BufferedReader roomReader = new BufferedReader(new FileReader(DataFiles.ROOM.getFile()));
            BufferedReader bookingReader = new BufferedReader(new FileReader(DataFiles.BOOKING.getFile()));

            Map<String, String> roomData = new TreeMap<>();

            /* Read lines and loop it, then insert into tree map */
            roomReader.lines().forEach(line -> {
                String[] data = line.split(ParadiseResort.getDataDelimiter());
                String detail = data[1] + ParadiseResort.getDataDelimiter() + data[2];

                roomData.put(data[0], detail);
            });

            roomReader.close();

            /* Read lines and loop it */
            bookingReader.lines().forEach(customer -> {

                String[] data = customer.split(ParadiseResort.getDataDelimiter());

                try {
                    LocalDate checkIn = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate checkOut = LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    LocalDate customerStartDate = LocalDate.parse(data[7], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate customerEndDate = LocalDate.parse(data[8], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    /* Get dates between for check in and check out, then convert to arraylist */
                    ArrayList<LocalDate> datesBetween = checkIn.datesUntil(checkOut).collect(Collectors.toCollection(ArrayList::new));

                    /* Check if datesBetween contain customerStartDate, customerEndDate,
                    * Check if check in is equal to customerStartDate,
                    * Check if check out is equal to customerEndDate,
                    * If yes, remove it from the tree map based on the room ID */
                    if ((datesBetween.contains(customerStartDate) || datesBetween.contains(customerEndDate)) || ((checkIn.equals(customerStartDate) || checkIn.equals(customerEndDate))) || ((checkOut.equals(customerStartDate) || checkOut.equals(customerEndDate)))) {
                        roomData.remove(data[5]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            bookingReader.close();

            if (extRoomData.size() > 0) {
                extRoomData.clear();
            }

            extRoomData = roomData;

            UIHandler.renderRoomTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Get room data */
    public static Map<String, String> getRoomData() {
        return extRoomData;
    }

}
