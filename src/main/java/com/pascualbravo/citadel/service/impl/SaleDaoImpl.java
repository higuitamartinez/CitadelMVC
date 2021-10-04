/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.SaleDao;
import com.pascualbravo.citadel.models.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleDaoImpl implements SaleDao{
    private static final String SQL_INSERT="INSERT INTO sale (specify_at, total_price) VALUES "
            + "(?,?);";
    
    private static final String SQL_SELECT="SELECT * FROM sale;";
    
    private static final String SQL_SELECT_MAX_SALE_ID = "SELECT MAX(sale_id) AS max_sale_id FROM SALE;";

    @Override
    public void create(Sale sale) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setTimestamp(1, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setDouble(2, sale.getTotalPrice());
            preparedStatement.executeUpdate();
        }finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(connection!=null){
                connection.close();
            }
        }
    }

    @Override
    public List<Sale> all() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sale> sales = new ArrayList<>();
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Sale sale = new Sale();
                sale.setSaleId(resultSet.getInt("sale_id"));
                sale.setSpecifyAt(resultSet.getTimestamp("specify_at").toLocalDateTime());
                sale.setTotalPrice(resultSet.getDouble("total_price"));
                sales.add(sale);
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
        return sales;
    }
    
    @Override
    public int getMaxSaleId() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int maxSaleId = 0;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_MAX_SALE_ID);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                maxSaleId = resultSet.getInt("max_sale_id");
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
        return maxSaleId;
    }
    
}
