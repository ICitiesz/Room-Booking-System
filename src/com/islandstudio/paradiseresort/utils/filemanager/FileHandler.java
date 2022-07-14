package com.islandstudio.paradiseresort.utils.filemanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileHandler {
    /* This class is used to handling files and folders during the program pre-initialize stage */

    /* Folders initialization */
    public static void intFolders() {
        /* Loop through all the required folder from the enum using Arrays Stream */
        Arrays.stream(FolderList.values()).forEach(fl -> {
            File folder = fl.getFolder();

            /* Check if the folder is exists, if not then create */
            if (!folder.exists()) {
                if (!folder.mkdirs()) {
                    System.out.println("[ERROR] Failed to create " + folder.getName());
                }
            }
        });
    }

    /* Data files initialization */
    public static void initDataFiles() {
        /* Loop through all the required data files from the enum using Arrays Stream */
        Arrays.stream(DataFiles.values()).forEach(df -> {
            File file = df.getFile();

            try {
                /* Check if the file is exists, if not then create */
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        System.out.println("[ERROR] Failed to create " + file.getName());
                    }
                }

                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                /* Check if the file is empty, if not then return */
                if (bufferedReader.lines().findAny().isPresent()) {
                    bufferedReader.close();
                    return;
                }

                /* Get input from the resources folder inside the jar file */
                InputStream inputStream = FileHandler.class.getClassLoader().getResourceAsStream("resources/presets/" + file.getName());

                if (inputStream == null) {
                    return;
                }

                /* Writing preparation */
                BufferedReader innerBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                ArrayList<String> lines = innerBufferedReader.lines().collect(Collectors.toCollection(ArrayList::new));

                /* Loop through every lines */
                for (String line : lines) {
                    try {
                        /* Check if the line is the last line, if not then write line with newline */
                        if (lines.indexOf(line) != lines.size() - 1) {
                            bufferedWriter.write(line + "\n");
                            continue;
                        }

                        bufferedWriter.write(line);
                    } catch (IOException e) {
                        System.out.println("[ERROR] Failed to write to " + file.getName());
                    }
                }

                /* Close the all streams */
                inputStream.close();
                innerBufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
