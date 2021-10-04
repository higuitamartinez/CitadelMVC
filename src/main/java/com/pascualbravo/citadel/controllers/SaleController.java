/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.controllers;

import com.pascualbravo.citadel.iface.SaleDao;
import com.pascualbravo.citadel.models.Sale;
import com.pascualbravo.citadel.util.TableSale;
import com.pascualbravo.service.impl.SaleDaoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author HIGUITA
 */
public class SaleController {
    private static final String[] COLUMNS_SALE = {"CÓDIGO", "FECHA", "VALOR", "DETALLES"};
    private static SaleController instance = null;
    private SaleDao saleDao;
    private TableSale tableSale;
    
    private SaleController(){
        saleDao = new SaleDaoImpl();
        tableSale = new TableSale();
    }
    
    public static SaleController getInstance(){
        if(instance == null){
            instance = new SaleController();
        }
        return instance;
    }
    
    public void loadSale(JTable jTable)throws SQLException{
        List<Sale> sales = saleDao.all();
        jTable.setRowHeight(25);
        tableSale.columnsSale(COLUMNS_SALE, jTable);
        
        if(sales == null || sales.size() == 0){
            return;
        }
        tableSale.fillSale(sales);
    }
    
    public void create(Sale sale) throws SQLException{
        saleDao.create(sale);
    }
    
    public int buttonTableSale(JTable jTable, java.awt.event.MouseEvent event){
        int column = jTable.getColumnModel().getColumnIndexAtX(event.getX());
        int row = event.getY()/jTable.getRowHeight();
        
        if(column >=0 && row>=0){
            Object object = jTable.getValueAt(row, column);
            
            if(object instanceof JButton){
                ((JButton) object).doClick();
                JButton jButton = (JButton)object;
                
                if(jButton.getName().equals("details")){
                    return row;
                }
            }
        }
        return -1;
    }
}
