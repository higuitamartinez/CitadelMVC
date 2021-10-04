package com.pascualbravo.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.EditorialDao;
import com.pascualbravo.citadel.models.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditorialDaoImpl implements EditorialDao{
    
    private static final String SQL_SELECT="SELECT * FROM editorial;";
        private static final String SQL_SELECT_BY_EDITORIAL_ID="SELECT * FROM editorial "
                + "WHERE editorial_id=?;";


    @Override
    public List<Editorial> all() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        List<Editorial> editorials = new ArrayList<>();
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while( resultSet.next() ){
                Editorial editorial = new Editorial();
                editorial.setEditorialId(resultSet.getInt("editorial_id"));
                editorial.setName(resultSet.getString("name"));
                editorials.add(editorial);
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
        return editorials;
    }
    
    @Override
    public Editorial findById(int editorialId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        Editorial editorial = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EDITORIAL_ID);
            
            preparedStatement.setInt(1, editorialId);
            resultSet = preparedStatement.executeQuery();
            
            if( resultSet.next() ){
                editorial = new Editorial();
                editorial.setEditorialId(resultSet.getInt("editorial_id"));
                editorial.setName(resultSet.getString("name"));
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
        return editorial;
    }
}
