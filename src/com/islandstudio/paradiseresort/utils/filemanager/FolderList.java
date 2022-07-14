package com.islandstudio.paradiseresort.utils.filemanager;

import com.islandstudio.paradiseresort.ParadiseResort;

import java.io.File;

public enum FolderList {
    /* This enum class is used to store the required folder constant */

    MAIN_FOLDER(new File(ParadiseResort.getTitle())),
    APP_DATA_FOLDER(new File(MAIN_FOLDER.getFolder(), "app_data"));

    private final File folder;

    FolderList(File folder) {
        this.folder = folder;
    }

    public File getFolder() {
        return folder;
    }
}
