/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.controllers;

import com.pascualbravo.citadel.iface.RegisterSaleDao;
import com.pascualbravo.citadel.models.RegisterSale;
import com.pascualbravo.citadel.util.TableRegisterSale;
import com.pascualbravo.citadel.service.impl.RegisterSaleDaoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author HIGUITA
 */
public class RegisterSaleController{
    private static RegisterSaleController instance = null;
    private static final String[] COLUMNS_REGISTER_SALE = {"CÓDIGO", "NOMBRE", "AUTOR", "EDITORIAL", "PASTA", "UNIDADES", "VALOR"};
    private RegisterSaleDao registerSaleDao;
    private TableRegisterSale tableRegisterSale;
    
    private RegisterSaleController(){
        registerSaleDao = new RegisterSaleDaoImpl();
        tableRegisterSale = new TableRegisterSale();
    }
    
    public static RegisterSaleController getInstance(){
        if(instance == null){
            instance = new RegisterSaleController();
        }
        return instance;
    }
    
    public List<RegisterSale> findBySaleId(int saleId) throws SQLException{
        return registerSaleDao.findBySaleId(saleId);
    }
    
    public void loadRegisterSale(JTable jTable, int saleId) throws SQLException{
        List<RegisterSale> registersSales = registerSaleDao.findBySaleId(saleId);
        jTable.setRowHeight(25);
        tableRegisterSale.columnsRegisterSale(COLUMNS_REGISTER_SALE, jTable);
        
        if(registersSales == null || registersSales.size() == 0){
            return;
        }
        tableRegisterSale.fillRegisterSale(registersSales);
        
    }
}
