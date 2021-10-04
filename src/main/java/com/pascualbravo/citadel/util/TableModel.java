/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HIGUITA
 */
public class TableModel extends DefaultTableModel{
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
