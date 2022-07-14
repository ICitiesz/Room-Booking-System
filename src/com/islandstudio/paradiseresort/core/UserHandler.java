package com.islandstudio.paradiseresort.core;

import com.islandstudio.paradiseresort.ParadiseResort;
import com.islandstudio.paradiseresort.ui.UIHandler;
import com.islandstudio.paradiseresort.ui.panels.HomeUI;
import com.islandstudio.paradiseresort.ui.panels.LoginUI;
import com.islandstudio.paradiseresort.utils.filemanager.DataFiles;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class UserHandler {
    /* This method perform login operations */
    public static void login() {
        String username = LoginUI.getUsernameField().getText();
        String password = new String(LoginUI.getPasswordField().getPassword());

        /* Login credentials verification */
        if (verifyField(username) || verifyField(password)) {
            JOptionPane.showMessageDialog(null, "Please fill in all the login fields!", "Login Failure", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<String> staffList = getStaffList();

        /* Loop through the staff list */
        for (String staff : staffList) {
            String[] staffInfo = staff.split(ParadiseResort.getDataDelimiter());

            if (username.equals(staffInfo[1]) && password.equals(staffInfo[2])) {
                Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", LoginUI.getLoginBTN())).getContentPane();
                UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "home");
                HomeUI.getGreetingLabel().setText("Welcome back, " + staffInfo[1] + "!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Invalid username or password!", "Login Failure", JOptionPane.ERROR_MESSAGE);
    }

    /* This method perform logout operations. */
    public static void logout() {
        JButton logoutBTN = HomeUI.getLogoutBTN();

        Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", logoutBTN)).getContentPane();
        UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "login");
        LoginUI.getUsernameField().setText("");
        LoginUI.getPasswordField().setText("");
    }

    /* This method used to get staff list from the staff.txt */
    private static ArrayList<String> getStaffList() {
        ArrayList<String> staffList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(DataFiles.STAFF.getFile()));
            reader.lines().forEach(staffList::add);

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Staff file not found!");
        } catch (IOException e) {
            System.out.println("Error: Staff file could not be read!");
        }

        return staffList;
    }

    /* Verify login field is blank or is empty */
    public static boolean verifyField(String input) {
        return input.isBlank() || input.isEmpty();
    }

}
