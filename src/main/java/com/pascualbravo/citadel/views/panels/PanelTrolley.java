/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.views.panels;

import com.pascualbravo.citadel.controllers.TrolleyController;
import com.pascualbravo.citadel.models.Trolley;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HIGUITA
 */
public class PanelTrolley extends javax.swing.JPanel {

    private TrolleyController trolleyController;
    public PanelTrolley() {
        initComponents();
        trolleyController = TrolleyController.getInstance();
        loadTrolley();
        updatePrice();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollTrolley = new javax.swing.JScrollPane();
        tableTrolley = new javax.swing.JTable();
        btnSale = new java.awt.Button();
        btnDelete = new java.awt.Button();
        lblPrice = new javax.swing.JLabel();
        lblIndicador = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("panelTrolley"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1320, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Carrito");

        tableTrolley.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTrolley.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTrolleyMouseClicked(evt);
            }
        });
        scrollTrolley.setViewportView(tableTrolley);

        btnSale.setBackground(new java.awt.Color(59, 86, 140));
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSale.setForeground(new java.awt.Color(255, 255, 255));
        btnSale.setLabel("Vender");
        btnSale.setName("btnSale"); // NOI18N
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 153, 153));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setLabel("Vaciar Carrito");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrice.setText("$ 20.000.000");

        lblIndicador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIndicador.setText("Precio total: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(scrollTrolley)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 565, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(619, 619, 619))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIndicador)
                                .addGap(60, 60, 60)
                                .addComponent(lblPrice)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(scrollTrolley, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(235, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrice)
                            .addComponent(lblIndicador))
                        .addGap(30, 30, 30)
                        .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))))
        );

        getAccessibleContext().setAccessibleName("panelTrolley");
    }// </editor-fold>//GEN-END:initComponents

    private void loadTrolley(){
        try{
            trolleyController.loadTrolley(tableTrolley);
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    private void updatePrice(){
        try{
            double price = trolleyController.getSumPrices();
            lblPrice.setText(String.valueOf(price));
            if(price > 0){
                btnSale.setEnabled(true);
                btnDelete.setEnabled(true);
            }else{
                btnSale.setEnabled(false);
                btnDelete.setEnabled(false);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            int count = trolleyController.getCount();
            if(count>0){
                trolleyController.deleteAll();
                loadTrolley();
                updatePrice();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        try{
            int count = trolleyController.getCount();
            if(count>0){
                trolleyController.createSale();
                trolleyController.deleteAll();
                loadTrolley();
                updatePrice();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnSaleActionPerformed

    private void tableTrolleyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTrolleyMouseClicked
        Integer[] option = trolleyController.buttonTableTrolley(tableTrolley, evt);
        try{
            if(option!=null){
                int bookId = Integer.parseInt(tableTrolley.getValueAt(option[1], 0).toString());
                if(trolleyController.getBookByBookId(bookId) == null){
                    JOptionPane.showMessageDialog(null, "El libro no existe");
                    loadTrolley();
                    return;
                }

                if(trolleyController.getTrolleyByBookId(bookId) == null){
                    JOptionPane.showMessageDialog(null, "El libro no existe en el carrito");
                    loadTrolley();
                    return;
                }
                
                if(option[0].equals(0)){
                    trolleyController.deleteBookById(bookId);
                    loadTrolley();
                    updatePrice();
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_tableTrolleyMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnDelete;
    private java.awt.Button btnSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIndicador;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JScrollPane scrollTrolley;
    private javax.swing.JTable tableTrolley;
    // End of variables declaration//GEN-END:variables
}
