/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.islandstudio.paradiseresort.ui.panels;

import com.islandstudio.paradiseresort.event.GUIEventHandler;
import com.islandstudio.paradiseresort.ui.CustomRoundBorder;
import com.islandstudio.paradiseresort.ui.UIHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Kah Heng Siew
 */
public class ManageBookingDetailsUI extends javax.swing.JPanel {

    /**
     * Creates new form ManageBookingDetailsUI
     */
    public ManageBookingDetailsUI() {
        initComponents();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/images/home_background.png")));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Image not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingSelectionPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                Graphics2D gpd = (Graphics2D) g;

                Color bgColor_1 = new Color(255, 255, 255, 52);

                gpd.setPaint(bgColor_1);
                gpd.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
            }

            @Override
            public void setBorder(Border border) {
                super.setBorder(new CustomRoundBorder(20));
            }
        };
        bookingListTitle = new javax.swing.JLabel();
        searchTitle = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        bookingDetailTableScrollFrame = new javax.swing.JScrollPane();
        bookingDetailTable = new javax.swing.JTable();
        selectBookingDetailTitle = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        clearSearchBTN = new javax.swing.JButton();
        customerDetailsPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                Graphics2D gpd = (Graphics2D) g;

                Color bgColor_1 = new Color(255, 255, 255, 52);

                gpd.setPaint(bgColor_1);
                gpd.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
            }

            @Override
            public void setBorder(Border border) {
                super.setBorder(new CustomRoundBorder(20));
            }

        };
        customerIC = new javax.swing.JTextField();
        customerDetailsTitle = new javax.swing.JLabel();
        customerICTitle = new javax.swing.JLabel();
        customerNameTitle = new javax.swing.JLabel();
        customerContactTitle = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        customerEmailTitle = new javax.swing.JLabel();
        csutomerContact = new javax.swing.JTextField();
        customerEmail = new javax.swing.JTextField();
        customerRoomTitle = new javax.swing.JLabel();
        customerRoomTypeTitle = new javax.swing.JLabel();
        customerRoomType = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        totalTitle = new javax.swing.JLabel();
        serviceTaxTitle = new javax.swing.JLabel();
        tourismTaxTitle = new javax.swing.JLabel();
        grandTotalTitle = new javax.swing.JLabel();
        total = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        serviceTax = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        tourismTax = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        grandTotal = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        saveBookingDetailBTN = new javax.swing.JButton();
        removeBookingBTN = new javax.swing.JButton();
        backBookingDetailsBTN = new javax.swing.JButton();
        customerRoom = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        customerCheckInDateTitle = new javax.swing.JLabel();
        customerCheckInDate = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        customerCheckOutDateTitle = new javax.swing.JLabel();
        totalNightsTitle = new javax.swing.JLabel();
        customerCheckOutDate = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        totalNights = new javax.swing.JTextField() {
            @Override
            public void setEditable(boolean b) {
                super.setEditable(false);
            }
        };
        checkOutBTN = new javax.swing.JButton();
        mainTitlePanel = new javax.swing.JPanel();
        bookingTitle = new javax.swing.JLabel();

        bookingSelectionPanel.setOpaque(false);

        bookingListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookingListTitle.setText("Booking List");
        bookingListTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bookingListTitle.setForeground(new java.awt.Color(255, 255, 255));

        searchTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        searchTitle.setForeground(new java.awt.Color(255, 255, 255));
        searchTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchTitle.setText("Search:");

        searchBTN.setText("Search");
        searchBTN.setActionCommand("Search Booking");
        searchBTN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        searchBTN.addActionListener(GUIEventHandler.actionListener);

        bookingDetailTable.addMouseListener(GUIEventHandler.mouseListener);
        bookingDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookingUUID", "Customer IC/Passport No.", "Customer Name", "Customer Contact", "Customer Email", "Room", "Room Type", "Check In Date", "Check Out Date", "Total Nights", "Total", "Service Tax", "Tourism Tax", "Grand Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookingDetailTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookingDetailTable.getTableHeader().setReorderingAllowed(false);
        bookingDetailTableScrollFrame.setViewportView(bookingDetailTable);

        selectBookingDetailTitle.setText("Select Booking Detail:");
        selectBookingDetailTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        selectBookingDetailTitle.setForeground(new java.awt.Color(255, 255, 255));

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        clearSearchBTN.setText("Clear");
        clearSearchBTN.setActionCommand("Clear Search Booking");
        clearSearchBTN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        clearSearchBTN.addActionListener(GUIEventHandler.actionListener);

        javax.swing.GroupLayout bookingSelectionPanelLayout = new javax.swing.GroupLayout(bookingSelectionPanel);
        bookingSelectionPanel.setLayout(bookingSelectionPanelLayout);
        bookingSelectionPanelLayout.setHorizontalGroup(
            bookingSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingSelectionPanelLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(bookingSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectBookingDetailTitle)
                    .addComponent(bookingDetailTableScrollFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bookingSelectionPanelLayout.createSequentialGroup()
                        .addGroup(bookingSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchTitle)
                            .addGroup(bookingSelectionPanelLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(bookingSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookingListTitle))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        bookingSelectionPanelLayout.setVerticalGroup(
            bookingSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookingListTitle)
                .addGap(43, 43, 43)
                .addGroup(bookingSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTitle)
                    .addComponent(clearSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(selectBookingDetailTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingDetailTableScrollFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        customerDetailsPanel.setOpaque(false);

        customerIC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerIC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        customerDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerDetailsTitle.setText("Customer Booking Details");
        customerDetailsTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        customerDetailsTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerICTitle.setText("Customer IC/Passport Number        :");
        customerICTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerICTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerNameTitle.setText("Customer Full Name                         :");
        customerNameTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerNameTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerContactTitle.setText("Customer Contact                             :");
        customerContactTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerContactTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        customerEmailTitle.setText("Customer Email                                 :");
        customerEmailTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerEmailTitle.setForeground(new java.awt.Color(255, 255, 255));

        csutomerContact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        csutomerContact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        customerEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        customerRoomTitle.setText("Customer Room                                :");
        customerRoomTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerRoomTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerRoomTypeTitle.setText("Customer Room Type                       :");
        customerRoomTypeTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerRoomTypeTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerRoomType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerRoomType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        totalTitle.setText("Total                                                 :");
        totalTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        totalTitle.setForeground(new java.awt.Color(255, 255, 255));

        serviceTaxTitle.setText("Service Tax (10% of Total)               :");
        serviceTaxTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        serviceTaxTitle.setForeground(new java.awt.Color(255, 255, 255));

        tourismTaxTitle.setText("Tourism Tax (RM 10 / Night)          :");
        tourismTaxTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        tourismTaxTitle.setForeground(new java.awt.Color(255, 255, 255));

        grandTotalTitle.setText("Grand Total                                      :");
        grandTotalTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        grandTotalTitle.setForeground(new java.awt.Color(255, 255, 255));

        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        serviceTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        serviceTax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tourismTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tourismTax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        grandTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        grandTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        saveBookingDetailBTN.setText("Save");
        saveBookingDetailBTN.setActionCommand("Save Booking Details");
        saveBookingDetailBTN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        saveBookingDetailBTN.addActionListener(GUIEventHandler.actionListener);

        removeBookingBTN.setText("Remove");
        removeBookingBTN.setActionCommand("Remove Booking Detail");
        removeBookingBTN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        removeBookingBTN.addActionListener(GUIEventHandler.actionListener);

        backBookingDetailsBTN.setText("Back");
        backBookingDetailsBTN.setActionCommand("Back to Booking Details");
        backBookingDetailsBTN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        backBookingDetailsBTN.addActionListener(GUIEventHandler.actionListener);

        customerRoom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        customerCheckInDateTitle.setText("Customer Check In Date                   :");
        customerCheckInDateTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerCheckInDateTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerCheckInDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerCheckInDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        customerCheckOutDateTitle.setText("Customer Check Out Date                 :");
        customerCheckOutDateTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        customerCheckOutDateTitle.setForeground(new java.awt.Color(255, 255, 255));

        totalNightsTitle.setText("Total Nights                                       :");
        totalNightsTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        totalNightsTitle.setForeground(new java.awt.Color(255, 255, 255));

        customerCheckOutDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerCheckOutDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        totalNights.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalNights.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        checkOutBTN.setText("Check Out");
        checkOutBTN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        checkOutBTN.addActionListener(GUIEventHandler.actionListener);

        javax.swing.GroupLayout customerDetailsPanelLayout = new javax.swing.GroupLayout(customerDetailsPanel);
        customerDetailsPanel.setLayout(customerDetailsPanelLayout);
        customerDetailsPanelLayout.setHorizontalGroup(
            customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(customerDetailsTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                        .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerContactTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerEmailTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerRoomTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerRoomTypeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerCheckInDateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerCheckOutDateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalNightsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceTaxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tourismTaxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(backBookingDetailsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(96, 96, 96)
                                    .addComponent(saveBookingDetailBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(grandTotalTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                                .addComponent(removeBookingBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkOutBTN))
                            .addComponent(csutomerContact, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalNights, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceTax, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tourismTax, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                        .addComponent(customerICTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(customerIC, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        customerDetailsPanelLayout.setVerticalGroup(
            customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerDetailsTitle)
                .addGap(18, 18, 18)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerICTitle)
                    .addComponent(customerIC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameTitle)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerContactTitle)
                    .addComponent(csutomerContact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerEmailTitle)
                    .addComponent(customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerRoomTitle)
                    .addComponent(customerRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerRoomTypeTitle)
                    .addComponent(customerRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerCheckInDateTitle)
                    .addComponent(customerCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerCheckOutDateTitle)
                    .addComponent(customerCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalNights, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalNightsTitle))
                .addGap(37, 37, 37)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTitle)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serviceTax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serviceTaxTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tourismTaxTitle)
                    .addComponent(tourismTax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grandTotalTitle)
                    .addComponent(grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBookingDetailBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBookingBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBookingDetailsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTitlePanel.setOpaque(false);

        bookingTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookingTitle.setText("Manage Booking Details");
        bookingTitle.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        bookingTitle.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout mainTitlePanelLayout = new javax.swing.GroupLayout(mainTitlePanel);
        mainTitlePanel.setLayout(mainTitlePanelLayout);
        mainTitlePanelLayout.setHorizontalGroup(
            mainTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTitlePanelLayout.createSequentialGroup()
                .addGap(539, 539, 539)
                .addComponent(bookingTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainTitlePanelLayout.setVerticalGroup(
            mainTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainTitlePanelLayout.createSequentialGroup()
                .addComponent(bookingTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bookingSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(mainTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(mainTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookingSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton backBookingDetailsBTN;
    private static javax.swing.JTable bookingDetailTable;
    private javax.swing.JScrollPane bookingDetailTableScrollFrame;
    private javax.swing.JLabel bookingListTitle;
    private javax.swing.JPanel bookingSelectionPanel;
    private javax.swing.JLabel bookingTitle;
    private static javax.swing.JButton checkOutBTN;
    private static javax.swing.JButton clearSearchBTN;
    private static javax.swing.JTextField csutomerContact;
    private static javax.swing.JTextField customerCheckInDate;
    private javax.swing.JLabel customerCheckInDateTitle;
    private static javax.swing.JTextField customerCheckOutDate;
    private javax.swing.JLabel customerCheckOutDateTitle;
    private javax.swing.JLabel customerContactTitle;
    private javax.swing.JPanel customerDetailsPanel;
    private javax.swing.JLabel customerDetailsTitle;
    private static javax.swing.JTextField customerEmail;
    private javax.swing.JLabel customerEmailTitle;
    private static javax.swing.JTextField customerIC;
    private javax.swing.JLabel customerICTitle;
    private static javax.swing.JTextField customerName;
    private javax.swing.JLabel customerNameTitle;
    private static javax.swing.JTextField customerRoom;
    private javax.swing.JLabel customerRoomTitle;
    private static javax.swing.JTextField customerRoomType;
    private javax.swing.JLabel customerRoomTypeTitle;
    private static javax.swing.JTextField grandTotal;
    private javax.swing.JLabel grandTotalTitle;
    private javax.swing.JPanel mainTitlePanel;
    private static javax.swing.JButton removeBookingBTN;
    private static javax.swing.JButton saveBookingDetailBTN;
    private static javax.swing.JButton searchBTN;
    private static javax.swing.JTextField searchField;
    private javax.swing.JLabel searchTitle;
    private javax.swing.JLabel selectBookingDetailTitle;
    private static javax.swing.JTextField serviceTax;
    private javax.swing.JLabel serviceTaxTitle;
    private static javax.swing.JTextField total;
    private static javax.swing.JTextField totalNights;
    private javax.swing.JLabel totalNightsTitle;
    private javax.swing.JLabel totalTitle;
    private static javax.swing.JTextField tourismTax;
    private javax.swing.JLabel tourismTaxTitle;
    // End of variables declaration//GEN-END:variables

    public static JTextField getSearchField() {
        return searchField;
    }

    public static JButton getSearchBTN() {
        return searchBTN;
    }

    public static JButton getClearSearchBTN() {
        return clearSearchBTN;
    }

    public static JTable getBookingDetailTable() {
        return bookingDetailTable;
    }

    public static JButton getBackBookingDetailsBTN() {
        return backBookingDetailsBTN;
    }

    public static JButton getRemoveBookingBTN() {
        return removeBookingBTN;
    }

    public static JButton getSaveBookingDetailBTN() {
        return saveBookingDetailBTN;
    }

    public static JButton getCheckOutBTN() {
        return checkOutBTN;
    }

    public static JTextField getCustomerIC() {
        return customerIC;
    }

    public static JTextField getCustomerName() {
        return customerName;
    }

    public static JTextField getCustomerContact() {
        return csutomerContact;
    }

    public static JTextField getCustomerEmail() {
        return customerEmail;
    }

    public static JTextField getCustomerRoom() {
        return customerRoom;
    }

    public static JTextField getCustomerRoomType() {
        return customerRoomType;
    }

    public static JTextField getCustomerCheckInDate() {
        return customerCheckInDate;
    }

    public static JTextField getCustomerCheckOutDate() {
        return customerCheckOutDate;
    }

    public static JTextField getTotalNights() {
        return totalNights;
    }

    public static JTextField getTotal() {
        return total;
    }

    public static JTextField getServiceTax() {
        return serviceTax;
    }

    public static JTextField getTourismTax() {
        return tourismTax;
    }

    public static JTextField getGrandTotal() {
        return grandTotal;
    }
}