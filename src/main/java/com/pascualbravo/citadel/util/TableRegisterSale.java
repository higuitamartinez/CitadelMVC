/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.util;

import com.pascualbravo.citadel.models.RegisterSale;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

public class TableRegisterSale {
    private TableModel tableModel;
    
    public void columnsRegisterSale(String [] columns, JTable jTable){
        tableModel = new TableModel();
        
        for(String column: columns){
            tableModel.addColumn(column);
        }
        jTable.setModel(tableModel);
        jTable.setDefaultRenderer(Object.class, new Render());
    }
    
    public void fillRegisterSale(List<RegisterSale> registersSales){
        tableModel.setRowCount(registersSales.size());
        int row = 0;
        
        for(RegisterSale registerSale:registersSales){
            tableModel.setValueAt(registerSale.getBookId(), row, 0);
            tableModel.setValueAt(registerSale.getBookName(), row, 1);
            tableModel.setValueAt(registerSale.getAuthor(), row, 2);
            tableModel.setValueAt(registerSale.getEditorialName(), row, 3);
            tableModel.setValueAt(registerSale.getBookbindingName(), row, 4);
            tableModel.setValueAt(registerSale.getUnits(), row, 5);
            tableModel.setValueAt(registerSale.getTotalPrice(), row, 6);
            row+=1;
        }
    }
    
}
