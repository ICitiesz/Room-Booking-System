
package com.islandstudio.paradiseresort;

import com.islandstudio.paradiseresort.ui.MainFrame;
import com.islandstudio.paradiseresort.ui.UIHandler;
import com.islandstudio.paradiseresort.utils.filemanager.FileHandler;

/**
 *
 * @author Kah Heng Siew
 */
public class ParadiseResort {
    /* This class is the main class of the program */

    private static final String TITLE = "Paradise Resort";
    private static final String DATA_DELIMITER = ";";

    public static void main(String[] args) {
        FileHandler.intFolders();
        FileHandler.initDataFiles();

        new MainFrame().setVisible(true);
        UIHandler.renderSplash();

    }

    /* Get the Program Title */
    public static String getTitle() {
        return TITLE;
    }

    /* Get the data delimiter */
    public static String getDataDelimiter() {
        return DATA_DELIMITER;
    }
}
