/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.util;

import com.pascualbravo.citadel.models.Trolley;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author HIGUITA
 */
public class TableTrolley {
    private TableModel tableModel;
    private JButton btnDelete;
    
    public TableTrolley(){
        btnDelete = new JButton("Eliminar");
        btnDelete.setName("delete");
    }
    
    public void columnsTrolley(String [] columns, JTable jTable){
        tableModel = new TableModel();
        
        for(String column: columns){
            tableModel.addColumn(column);
        }
        jTable.setModel(tableModel);
        jTable.setDefaultRenderer(Object.class, new Render());
    }
    
    public void fillTrolley(List<Trolley> trolley){
        tableModel.setRowCount(trolley.size());
        int row = 0;
        
        for(Trolley trolleyObj:trolley){
            tableModel.setValueAt(trolleyObj.getBookId(), row, 0);
            tableModel.setValueAt(trolleyObj.getBookName(), row, 1);
            tableModel.setValueAt(trolleyObj.getAuthor(), row, 2);
            tableModel.setValueAt(trolleyObj.getEditorialName(), row, 3);
            tableModel.setValueAt(trolleyObj.getBookbindingName(), row, 4);
            tableModel.setValueAt(trolleyObj.getUnits(), row, 5);
            tableModel.setValueAt(trolleyObj.getPrice(), row, 6);
            tableModel.setValueAt(btnDelete, row, 7);
            row+=1;
        }
    }
}
