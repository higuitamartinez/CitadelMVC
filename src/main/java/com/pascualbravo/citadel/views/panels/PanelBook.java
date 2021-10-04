/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.views.panels;

import com.pascualbravo.citadel.controllers.BookController;
import com.pascualbravo.citadel.views.FormCitadel;
import com.pascualbravo.citadel.views.FormUnits;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HIGUITA
 */
public class PanelBook extends javax.swing.JPanel {
    
    private FormUnits formUnits;
    private BookController bookController;
    public PanelBook() {
        initComponents();
        bookController = BookController.getInstance();
        formUnits = FormUnits.getInstance();
        loadBooks();
    }
    
    public void loadBooks(){
        try{
            bookController.loadBooksTrue(tableBookTrue);
            bookController.loadBooksFalse(tableBookFalse);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexión a la base de datos");
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

        jLabel1 = new javax.swing.JLabel();
        scrollBookTrue = new javax.swing.JScrollPane();
        tableBookTrue = new javax.swing.JTable();
        scrollBookFalse = new javax.swing.JScrollPane();
        tableBookFalse = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCreate = new java.awt.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("panelBook"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1320, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Libros disponibles");

        scrollBookTrue.setName("scrollBooksTrue"); // NOI18N

        tableBookTrue.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBookTrue.setName("tableBookTrue"); // NOI18N
        tableBookTrue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookTrueMouseClicked(evt);
            }
        });
        scrollBookTrue.setViewportView(tableBookTrue);

        scrollBookFalse.setName("scrollBooksFalse"); // NOI18N

        tableBookFalse.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBookFalse.setName("tableBookFalse"); // NOI18N
        tableBookFalse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookFalseMouseClicked(evt);
            }
        });
        scrollBookFalse.setViewportView(tableBookFalse);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Libros registrados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Libros NO disponibles");

        btnCreate.setBackground(new java.awt.Color(59, 86, 140));
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setLabel("Crear Libro");
        btnCreate.setName("btnCreate"); // NOI18N
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollBookTrue, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollBookFalse, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 482, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(546, 546, 546))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(507, 507, 507))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(498, 498, 498))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(scrollBookTrue, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBookFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCreate.getAccessibleContext().setAccessibleName("btnCreate");

        getAccessibleContext().setAccessibleName("panelBook");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        new ChangePanel(FormCitadel.panelPrincipal, new PanelSave(0));
    }//GEN-LAST:event_btnCreateActionPerformed

    private void tableBookTrueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookTrueMouseClicked
        List<Integer> option = bookController.buttonBookTrue(tableBookTrue, evt);
        
        if(option!=null){
            int bookId = Integer.parseInt(tableBookTrue.getValueAt(option.get(1), 0).toString());
            
            
            try{
                if(bookController.getBookByBookId(bookId) != null){
                    if(option.get(0).equals(0)){
                        formUnits.setBookId(bookId);
                        formUnits.setVisible(true);
                        
                        if(formUnits.getDialogResult() == 1){
                            loadBooks();
                        }
                    }
                
                    if(option.get(0).equals(1)){
                        new ChangePanel(FormCitadel.panelPrincipal, new PanelSave(bookId));
                    }

                    if(option.get(0).equals(2)){
                        if(bookController.existTrolleyByBookId(bookId)){
                            bookController.deleteTrolleyByBookId(bookId);
                        }
                        bookController.updateEnabledBook(bookId);
                        loadBooks();
                    }
                }
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_tableBookTrueMouseClicked

    private void tableBookFalseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookFalseMouseClicked
        // TODO add your handling code here:
        int row = bookController.buttonBookFalse(tableBookFalse, evt);
        if(row!=-1){
            int bookId = Integer.parseInt(tableBookFalse.getValueAt(row, 0).toString());
            try{
                if(bookController.getBookByBookId(bookId) != null){
                    new ChangePanel(FormCitadel.panelPrincipal, new PanelSave(bookId));
                }
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_tableBookFalseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane scrollBookFalse;
    private javax.swing.JScrollPane scrollBookTrue;
    private javax.swing.JTable tableBookFalse;
    private javax.swing.JTable tableBookTrue;
    // End of variables declaration//GEN-END:variables
}