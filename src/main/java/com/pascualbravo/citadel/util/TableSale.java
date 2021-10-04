/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.util;

import com.pascualbravo.citadel.models.Sale;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author HIGUITA
 */
public class TableSale {
    private TableModel tableModel;
    private JButton btnDetails;
    
    public TableSale(){
        btnDetails = new JButton("Detalles");
        btnDetails.setName("details");
    }
    
    public void columnsSale(String[] columns, JTable jTable){
        tableModel = new TableModel();
        
        for(String column: columns){
            tableModel.addColumn(column);
        }
        
        jTable.setModel(tableModel);
        jTable.setDefaultRenderer(Object.class, new Render());
    }
    
    public void fillSale(List<Sale> sales){
        tableModel.setRowCount(sales.size());
        int row=0;
        
        for(Sale sale: sales){
            tableModel.setValueAt(sale.getSaleId(),row,0);
            tableModel.setValueAt(sale.getSpecifyAt(), row, 1);
            tableModel.setValueAt(sale.getTotalPrice(), row, 2);
            tableModel.setValueAt(btnDetails, row, 3);
            row+=1;
        }
    }
}
