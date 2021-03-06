/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.views.panels;

import com.pascualbravo.citadel.controllers.SaveController;
import com.pascualbravo.citadel.views.FormCitadel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HIGUITA
 */
public class PanelSave extends javax.swing.JPanel {

    private int idBook;
    private SaveController saveController;
    
    public PanelSave(int idBook) {
        initComponents();
        saveController = SaveController.getInstance();
        
        txtBookId.setEnabled(false);
        this.idBook=idBook;
        
        if(this.idBook != 0){
            btnSave.setLabel("Actualizar Liro");
            try{
                saveController.dataUpdateBook(this.idBook, txtBookId, txtName, txtAuthor, txtCategory, txtEditorial, txtBookbinding, txtBookYear, txtNumPages, txtEdition, txtUnits, txtPrice);
            }catch(SQLException ex){
                System.out.println("Hubo un error");
            }
        }
    }
    
    private void clearText(){
        saveController.clearText(txtBookId);
        saveController.clearText(txtName);
        saveController.clearText(txtAuthor);
        saveController.clearText(txtEditorial);
        saveController.clearText(txtBookbinding);
        saveController.clearText(txtBookYear);
        saveController.clearText(txtNumPages);
        saveController.clearText(txtEdition);
        saveController.clearText(txtCategory);
        saveController.clearText(txtUnits);
        saveController.clearText(txtPrice);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBookId = new java.awt.Label();
        txtBookId = new java.awt.TextField();
        lblName = new java.awt.Label();
        txtName = new java.awt.TextField();
        lblAutor = new java.awt.Label();
        txtAuthor = new java.awt.TextField();
        lblEditorial = new java.awt.Label();
        txtEditorial = new java.awt.TextField();
        lblBookbinding = new java.awt.Label();
        txtBookbinding = new java.awt.TextField();
        lblNumPages = new java.awt.Label();
        txtBookYear = new java.awt.TextField();
        lblYear = new java.awt.Label();
        txtNumPages = new java.awt.TextField();
        lblEdition = new java.awt.Label();
        txtEdition = new java.awt.TextField();
        lblCategory = new java.awt.Label();
        txtCategory = new java.awt.TextField();
        lblUnits = new java.awt.Label();
        txtUnits = new java.awt.TextField();
        lblPrice = new java.awt.Label();
        txtPrice = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new java.awt.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("panelSave"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1320, 1000));

        lblBookId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBookId.setText("C??digo");

        txtBookId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBookId.setName("txtBookId"); // NOI18N

        lblName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblName.setText("Nombre");

        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtName.setName("txtName"); // NOI18N

        lblAutor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAutor.setText("Autor");

        txtAuthor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAuthor.setName("txtAuthor"); // NOI18N

        lblEditorial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEditorial.setText("Editorial");

        txtEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEditorial.setName("txtYear"); // NOI18N

        lblBookbinding.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBookbinding.setText("Pasta");

        txtBookbinding.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBookbinding.setName("txtYear"); // NOI18N

        lblNumPages.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumPages.setText("N??mero de P??ginas");

        txtBookYear.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBookYear.setName("txtBookYear"); // NOI18N

        lblYear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblYear.setText("A??o");

        txtNumPages.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumPages.setName("txtNumPages"); // NOI18N

        lblEdition.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEdition.setText("Edici??n");

        txtEdition.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEdition.setName("txtBookId"); // NOI18N

        lblCategory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCategory.setText("Categor??a");

        txtCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCategory.setName("txtYear"); // NOI18N

        lblUnits.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUnits.setText("Unidades");

        txtUnits.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUnits.setName("txtBookId"); // NOI18N

        lblPrice.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPrice.setText("Precio");

        txtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrice.setName("txtBookId"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Guardar Libro");

        btnSave.setBackground(new java.awt.Color(59, 86, 140));
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setLabel("Crear Libro");
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUnits, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEdition, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblNumPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNumPages, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBookYear, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblBookbinding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                .addComponent(lblBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBookId, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(513, 513, 513)
                                .addComponent(jLabel2))))
                    .addComponent(txtBookbinding, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(218, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(575, 575, 575))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblBookbinding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtBookbinding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtBookYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblNumPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtNumPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        lblBookId.getAccessibleContext().setAccessibleName("lblBookId");
        lblName.getAccessibleContext().setAccessibleName("lblName");
        lblAutor.getAccessibleContext().setAccessibleName("lblAuthor");
        lblEditorial.getAccessibleContext().setAccessibleName("lblEditorial");
        lblBookbinding.getAccessibleContext().setAccessibleName("lblPasta");
        lblNumPages.getAccessibleContext().setAccessibleName("lblNumPages");
        lblYear.getAccessibleContext().setAccessibleName("lblYear");
        lblEdition.getAccessibleContext().setAccessibleName("lblEdition");
        lblEdition.getAccessibleContext().setAccessibleDescription("");
        lblCategory.getAccessibleContext().setAccessibleName("lblCategory");
        lblUnits.getAccessibleContext().setAccessibleName("lblUnits");
        lblPrice.getAccessibleContext().setAccessibleName("lblPrice");
        btnSave.getAccessibleContext().setAccessibleName("btnSave");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            String errorMessage = saveController.validateData(txtName.getText(), txtAuthor.getText(), txtCategory.getText(), txtEditorial.getText(), txtBookbinding.getText(), txtBookYear.getText(), txtNumPages.getText(), txtEdition.getText(), txtUnits.getText(), txtPrice.getText());
            
            if(errorMessage.length() > 0){
                JOptionPane.showMessageDialog(null, errorMessage);
                return;
            }
            
            errorMessage = saveController.validateExist(Integer.parseInt(txtEditorial.getText()),Integer.parseInt(txtBookbinding.getText()),Integer.parseInt(txtCategory.getText()));
            if(errorMessage.length() > 0){
                JOptionPane.showMessageDialog(null, errorMessage);
                return;
            }
            
            if(this.idBook == 0){
                saveController.createBook(txtName.getText(), txtAuthor.getText(), txtCategory.getText(), txtEditorial.getText(), txtBookbinding.getText(), txtBookYear.getText(), txtNumPages.getText(), txtEdition.getText(), txtUnits.getText(), txtPrice.getText());
            }else{
                saveController.updateBook(idBook, txtName.getText(), txtAuthor.getText(), txtCategory.getText(), txtEditorial.getText(), txtBookbinding.getText(), txtBookYear.getText(), txtNumPages.getText(), txtEdition.getText(), txtUnits.getText(), txtPrice.getText());
            }

            new ChangePanel(FormCitadel.panelPrincipal, new PanelBook());
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnSave;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label lblAutor;
    private java.awt.Label lblBookId;
    private java.awt.Label lblBookbinding;
    private java.awt.Label lblCategory;
    private java.awt.Label lblEdition;
    private java.awt.Label lblEditorial;
    private java.awt.Label lblName;
    private java.awt.Label lblNumPages;
    private java.awt.Label lblPrice;
    private java.awt.Label lblUnits;
    private java.awt.Label lblYear;
    private java.awt.TextField txtAuthor;
    private java.awt.TextField txtBookId;
    private java.awt.TextField txtBookYear;
    private java.awt.TextField txtBookbinding;
    private java.awt.TextField txtCategory;
    private java.awt.TextField txtEdition;
    private java.awt.TextField txtEditorial;
    private java.awt.TextField txtName;
    private java.awt.TextField txtNumPages;
    private java.awt.TextField txtPrice;
    private java.awt.TextField txtUnits;
    // End of variables declaration//GEN-END:variables
}
