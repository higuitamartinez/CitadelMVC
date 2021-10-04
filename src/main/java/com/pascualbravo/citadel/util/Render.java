/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.util;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author HIGUITA
 */
public class Render extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column){
        
        if(value instanceof JButton){
            JButton jButton = (JButton)value;
            return jButton;
        }
        return super.getTableCellRendererComponent(jTable, value, isSelected, hasFocus, row, column);
    }
}
