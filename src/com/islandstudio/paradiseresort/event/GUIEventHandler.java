package com.islandstudio.paradiseresort.event;

import com.islandstudio.paradiseresort.core.BookingDetailsHandler;
import com.islandstudio.paradiseresort.core.BookingHandler;
import com.islandstudio.paradiseresort.core.UserHandler;
import com.islandstudio.paradiseresort.ui.UIHandler;
import com.islandstudio.paradiseresort.ui.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIEventHandler {
    /* This class is mainly used to handling all the events */

    public static ActionListener actionListener = e -> {
        Object source = e.getSource();

        /* NOTE: Below are the enhanced switch statement, so no need to add break */
        /* Switch every single case for the action command, and perform the required operation that match the action command. */
        switch (e.getActionCommand()) {
            case "Log in" -> {

                if (source.equals(LoginUI.getLoginBTN())) {
                    UserHandler.login();
                }
            }

            case "Log Out" -> {
                if (source.equals(HomeUI.getLogoutBTN())) {
                    UserHandler.logout();
                }
            }

            case "Manage Booking Details" -> {
                JButton manageBookingDetailsBTN = BookingDetailsMenuUI.getManageBookingDetailsBTN();

                if (source.equals(manageBookingDetailsBTN)) {
                    Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", BookingDetailsMenuUI.getManageBookingDetailsBTN())).getContentPane();
                    UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "manageBookingDetails");
                    UIHandler.renderBookingDetailsTable();
                }
            }

            case "Booking Details" -> {
                JButton manageBookingBTN = HomeUI.getBookingDetailsBTN();

                if (source.equals(manageBookingBTN)) {
                    Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", manageBookingBTN)).getContentPane();
                    UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "bookingDetailsMenu");
                }
            }

            case "Book a Room" -> {
                JButton bookARoomBTN = HomeUI.getBookRoomBTN();

                if (source.equals(bookARoomBTN)) {
                    Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", bookARoomBTN)).getContentPane();
                    UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "booking");
                }
            }

            case "Check Room" -> {
                JButton checkRoomBTN = BookingUI.getCheckRoomBTN();

                if (source.equals(checkRoomBTN)) {
                    BookingHandler.checkRoom();
                }
            }

            case "Cancel Booking" -> {
                JButton cancelBookingBTN = BookingUI.getCancelBookingBTN();

                if (source.equals(cancelBookingBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel room booking?", "Cancel Room Booking", JOptionPane.YES_NO_OPTION)) {
                        UIHandler.clearBookingDetails();
                        Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", cancelBookingBTN)).getContentPane();
                        UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "home");
                    }
                }
            }

            case "Book" -> {
                JButton bookBTN = BookingUI.getBookBTN();

                if (source.equals(bookBTN)) {
                    BookingHandler.book();
                }
            }

            case "Clear Booking" -> {
                JButton clearBookingBTN = BookingUI.getClearBookingBTN();

                if (source.equals(clearBookingBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to clear customer's booking details?", "Clear Booking Details", JOptionPane.YES_NO_OPTION)) {
                        UIHandler.clearBookingDetails();
                    }
                }
            }

            case "Back to Home" -> {
                JButton backToHomeBTN = BookingDetailsMenuUI.getBackHomeBTN();

                if (source.equals(backToHomeBTN)) {
                    Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", backToHomeBTN)).getContentPane();
                    UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "home");
                }
            }

            case "Search Booking" -> {
                JButton searchBookingBTN = ManageBookingDetailsUI.getSearchBTN();

                if (source.equals(searchBookingBTN)) {
                    if (ManageBookingDetailsUI.getSearchField().getText().isEmpty() || ManageBookingDetailsUI.getSearchField().getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Please provide a keyword to search!", "Search Booking", JOptionPane.ERROR_MESSAGE);
                    }
                    UIHandler.renderBookingDetailsTable();
                }
            }

            case "Clear Search Booking" -> {
                JButton clearSearchBTN = ManageBookingDetailsUI.getClearSearchBTN();

                if (source.equals(clearSearchBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to clear booking details?", "Clear Booking Details", JOptionPane.YES_NO_OPTION)) {
                        UIHandler.clearManageBookingDetails();
                    }
                }
            }

            case "Back to Booking Details" -> {
                JButton backToBookingDetailsBTN_1 = ManageBookingDetailsUI.getBackBookingDetailsBTN();
                JButton backToBookingDetailsBTN_2 = ReceiptUI.getBackViewReceiptBTN();

                if (source.equals(backToBookingDetailsBTN_1)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to Booking Details Menu?", "Back to Booking Details Menu", JOptionPane.YES_NO_OPTION)) {
                        UIHandler.clearManageBookingDetails();
                        Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", backToBookingDetailsBTN_1)).getContentPane();
                        UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "bookingDetailsMenu");
                    }
                }

                if (source.equals(backToBookingDetailsBTN_2)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to Booking Details Menu?", "Back to Booking Details Menu", JOptionPane.YES_NO_OPTION)) {
                        UIHandler.clearReceiptDetails();
                        Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", backToBookingDetailsBTN_2)).getContentPane();
                        UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "bookingDetailsMenu");
                    }
                }
            }

            case "Remove Booking Detail" -> {
                JButton removeBookingDetailBTN = ManageBookingDetailsUI.getRemoveBookingBTN();

                if (source.equals(removeBookingDetailBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this booking detail?", "Remove Booking Detail", JOptionPane.YES_NO_OPTION)) {
                        BookingDetailsHandler.removeBookingDetails("remove");
                        JOptionPane.showMessageDialog(null, "Booking detail removed successfully!", "Remove Booking Detail", JOptionPane.INFORMATION_MESSAGE);
                        UIHandler.clearManageBookingDetails();
                    }
                }
            }

            case "Check Out" -> {
                JButton checkOutBTN = ManageBookingDetailsUI.getCheckOutBTN();

                if (source.equals(checkOutBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to check out this booking?", "Check Out", JOptionPane.YES_NO_OPTION)) {
                        BookingDetailsHandler.removeBookingDetails("checkout");
                        UIHandler.clearManageBookingDetails();
                        JOptionPane.showMessageDialog(null, "Check out successful!", "Check Out", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

            case "Save Booking Details" -> {
                JButton saveBookingDetailsBTN = ManageBookingDetailsUI.getSaveBookingDetailBTN();

                if (source.equals(saveBookingDetailsBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to save this booking detail?", "Save Booking Detail", JOptionPane.YES_NO_OPTION)) {
                        BookingDetailsHandler.saveBookingDetails();
                        UIHandler.clearManageBookingDetails();
                        JOptionPane.showMessageDialog(null, "Booking detail saved!", "Save Booking Detail", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

            case "View Receipt" -> {
                JButton viewReceiptBTN = BookingDetailsMenuUI.getViewReceiptBTN();

                if (source.equals(viewReceiptBTN)) {
                    UIHandler.renderReceiptTable();
                    Container mainFrame = ((JFrame) SwingUtilities.getAncestorNamed("mainFrame", viewReceiptBTN)).getContentPane();
                    UIHandler.switchPanel(mainFrame, (CardLayout) mainFrame.getLayout(), "viewReceipt");
                }
            }

            case "Search Receipt" -> {
                JButton searchReceiptBTN = ReceiptUI.getSearchBTN();

                if (source.equals(searchReceiptBTN)) {
                    if (ReceiptUI.getSearchField().getText().isEmpty() || ReceiptUI.getSearchField().getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Please provide a keyword to search!", "Search Receipt", JOptionPane.ERROR_MESSAGE);
                    }

                    UIHandler.renderReceiptTable();
                }
            }

            case "Clear Search Receipt" -> {
                JButton clearSearchReceiptBTN = ReceiptUI.getClearSearchBTN();

                if (source.equals(clearSearchReceiptBTN)) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to clear receipt details?", "Clear Receipt Details", JOptionPane.YES_NO_OPTION)) {
                        UIHandler.clearReceiptDetails();
                    }
                }
            }
        }
    };

    public static MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Object source = e.getSource();

            UIHandler.setBookingDetails(source);
            UIHandler.setManageBookingDetails(source);
            UIHandler.setReceiptDetails(source);
        }
    };
}
