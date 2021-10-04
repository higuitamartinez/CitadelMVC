/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.RegisterSaleDao;
import com.pascualbravo.citadel.models.RegisterSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIGUITA
 */
public class RegisterSaleDaoImpl implements RegisterSaleDao{
    
    private static final String SQL_INSERT="INSERT INTO register_sale (sale_id, book_id, units, total_price) VALUES "
            + "(?, ?, ?, ?);";
            
    private static final String SQL_SELECT_BY_SALE_ID="SELECT r.*, b.name AS book_name, b.author AS book_author, e.name AS editorial_name, d.name AS bookbinding_name FROM register_sale r " +
                "INNER JOIN book b ON b.book_id = r.book_id " +
                "INNER JOIN editorial e ON b.editorial_id = e.editorial_id " +
                "INNER JOIN bookbinding d ON b.bookbinding_id = d.bookbinding_id WHERE r.sale_id=?;";

    @Override
    public void create(RegisterSale registerSale) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, registerSale.getSaleId());
            preparedStatement.setInt(2, registerSale.getBookId());
            preparedStatement.setInt(3, registerSale.getUnits());
            preparedStatement.setDouble(4, registerSale.getTotalPrice());
            
            preparedStatement.executeUpdate();
        }finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<RegisterSale> findBySaleId(int saleId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<RegisterSale> registerSales = new ArrayList<>();
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_SALE_ID);
            preparedStatement.setInt(1, saleId);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                RegisterSale registerSale = new RegisterSale();
                registerSale.setRegisterSaleId(resultSet.getInt("register_sale_id"));
                registerSale.setSaleId(resultSet.getInt("sale_id"));
                registerSale.setBookId(resultSet.getInt("book_id"));
                registerSale.setBookName(resultSet.getString("book_name"));
                registerSale.setAuthor(resultSet.getString("book_author"));
                registerSale.setEditorialName(resultSet.getString("editorial_name"));
                registerSale.setBookbindingName(resultSet.getString("bookbinding_name"));
                registerSale.setUnits(resultSet.getInt("units"));
                registerSale.setTotalPrice(resultSet.getDouble("total_price"));
                
                registerSales.add(registerSale);
            }
        }finally{
            if(resultSet != null){
                resultSet.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(connection != null){
                connection.close();
            }
        }
        return registerSales;
    }
    
}
