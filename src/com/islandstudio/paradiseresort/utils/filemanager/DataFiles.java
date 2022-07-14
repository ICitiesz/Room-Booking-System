package com.islandstudio.paradiseresort.utils.filemanager;

import java.io.File;

public enum DataFiles {
    /* This enum class is used to store the required files constant */
    BOOKING(new File(FolderList.APP_DATA_FOLDER.getFolder(), "booking.txt")),
    RECEIPT(new File(FolderList.APP_DATA_FOLDER.getFolder(), "receipt.txt")),
    ROOM(new File(FolderList.APP_DATA_FOLDER.getFolder(), "room.txt")),
    STAFF(new File(FolderList.APP_DATA_FOLDER.getFolder(), "staff.txt"));

    private final File file;

    DataFiles(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
