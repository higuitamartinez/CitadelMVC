/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.BookbindingDao;
import com.pascualbravo.citadel.models.Bookbinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookbindingDaoImpl implements BookbindingDao{
    
    private static final String SQL_SELECT="SELECT * FROM bookbinding;";
    private static final String SQL_SELECT_BY_BOOKBINDING_ID = "SELECT * FROM bookbinding "
            + "WHERE bookbinding_id = ?;";

    @Override
    public List<Bookbinding> all() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bookbinding> bookbindings = new ArrayList<>();
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement= connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while( resultSet.next() ){
                Bookbinding bookbinding = new Bookbinding();
                bookbinding.setBookbindingId(resultSet.getInt("bookbinding_id"));
                bookbinding.setName(resultSet.getString("name"));
                bookbindings.add(bookbinding);
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
        return bookbindings;
    }
    
    @Override
    public Bookbinding findById(int bookbindingId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Bookbinding bookbinding = null;
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_BOOKBINDING_ID);
            preparedStatement.setInt(1, bookbindingId);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                bookbinding = new Bookbinding();
                bookbinding.setBookbindingId(resultSet.getInt("bookbinding_id"));
                bookbinding.setName(resultSet.getString("name"));
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
        
        return bookbinding;
    }
    
}
