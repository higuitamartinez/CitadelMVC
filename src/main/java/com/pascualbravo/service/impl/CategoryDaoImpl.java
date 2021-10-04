/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.CategoryDao;
import com.pascualbravo.citadel.models.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{
    private static final String SQL_SELECT="SELECT * FROM category;";
    private static final String SQL_SELECT_BY_CATEGORY_ID="SELECT * FROM category "
            + "WHERE category_id = ?;";


    @Override
    public List<Category> all() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Category> categories = new ArrayList<>();
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement= connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
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
        
        return categories;
    }
    
    @Override
    public Category findById(int categoryId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement= connection.prepareStatement(SQL_SELECT_BY_CATEGORY_ID);
            
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                category = new Category();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
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
        return category;
    }
}
