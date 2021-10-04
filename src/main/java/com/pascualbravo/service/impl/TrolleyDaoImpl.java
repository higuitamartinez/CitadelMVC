
package com.pascualbravo.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.TrolleyDao;
import com.pascualbravo.citadel.models.Trolley;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrolleyDaoImpl implements TrolleyDao{
    private static final String SQL_INSERT="INSERT INTO trolley (book_id, units) "
            + "VALUES (?, ?);";
    
    private static final String SQL_SELECT="SELECT t.*, b.name AS book_name, b.author AS book_author, e.name AS editorial_name, d.name AS bookbinding_name, b.price*t.units AS price  "
            + "FROM trolley t " +
            "INNER JOIN book b ON t.book_id=b.book_id " +
            "INNER JOIN editorial e ON b.editorial_id = e.editorial_id " +
            "INNER JOIN bookbinding d ON b.bookbinding_id=d.bookbinding_id;";
    
    private static final String SQL_SELECT_BY_ID = "SELECT t.*, b.name AS book_name, b.author AS book_author, e.name AS editorial_name, d.name AS bookbinding_name, b.price*t.units AS price "
            +"FROM trolley t "+
            "INNER JOIN book b ON b.book_id=t.book_id "+
            "INNER JOIN editorial e ON e.editorial_id=b.editorial_id "+
            "INNER JOIN bookbinding d ON d.bookbinding_id=b.bookbinding_id "+
            " WHERE t.trolley_id = ?;";
    private static final String SQL_SELECT_BY_BOOK_ID="SELECT t.*, b.name AS book_name, b.author AS book_author, e.name AS editorial_name, d.name AS bookbinding_name, b.price*t.units AS price  "
            + "FROM trolley t " +
            "INNER JOIN book b ON t.book_id=b.book_id " +
            "INNER JOIN editorial e ON b.editorial_id = e.editorial_id " +
            "INNER JOIN bookbinding d ON b.bookbinding_id=d.bookbinding_id "
            + "WHERE t.book_id = ?;";
    
    private static final String SQL_EXIST_BY_BOOK_ID = "SELECT 1 AS exist FROM trolley WHERE book_id = ? LIMIT 1;";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM trolley WHERE trolley_id=?;";
    private static final String SQL_DELETE_BY_BOOK_ID = "DELETE FROM trolley WHERE book_id=?;";
    private static final String SQL_DELETE_ALL = "DELETE FROM trolley";
    
    private static final String SQL_SELECT_SUM_PRICES = "SELECT SUM(t.units * b.price) AS total_price FROM trolley t " +
            "INNER JOIN book b ON t.book_id = b.book_id;";
    
    private static final String SQL_SELECT_COUNT = "SELECT COUNT(*) AS count FROM trolley;";

    @Override
    public void create(Trolley trolley) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, trolley.getBookId());
            preparedStatement.setInt(2, trolley.getUnits());
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
    public List<Trolley> all() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        List<Trolley> trolleys = new ArrayList<>();
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while( resultSet.next() ){
                Trolley trolley = new Trolley();
                trolley.setTrolleyId(resultSet.getInt("trolley_id"));
                trolley.setBookId(resultSet.getInt("book_id"));
                trolley.setBookName(resultSet.getString("book_name"));
                trolley.setAuthor(resultSet.getString("book_author"));
                trolley.setEditorialName(resultSet.getString("editorial_name"));
                trolley.setBookbindingName(resultSet.getString("bookbinding_name"));
                trolley.setUnits(resultSet.getInt("units"));
                trolley.setPrice(resultSet.getDouble("price"));
                trolleys.add(trolley);
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
        
        return trolleys;
    }
    
    @Override
    public Trolley findById(int trolleyId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Trolley trolley = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, trolleyId);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                trolley = new Trolley();
                trolley.setTrolleyId(resultSet.getInt("trolley_id"));
                trolley.setBookId(resultSet.getInt("book_id"));
                trolley.setUnits(resultSet.getInt("units"));
                trolley.setBookName(resultSet.getString("book_name"));
                trolley.setAuthor(resultSet.getString("book_author"));
                trolley.setEditorialName(resultSet.getString("editorial_name"));
                trolley.setBookbindingName(resultSet.getString("bookbinding_name"));
                trolley.setPrice(resultSet.getDouble("price"));
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
        return trolley;
    }

    @Override
    public Trolley findByBookId(int bookId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        Trolley trolley = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_BOOK_ID);
            preparedStatement.setInt(1, bookId);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                trolley = new Trolley();
                trolley.setTrolleyId(resultSet.getInt("trolley_id"));
                trolley.setBookId(resultSet.getInt("book_id"));
                trolley.setBookName(resultSet.getString("book_name"));
                trolley.setAuthor(resultSet.getString("book_author"));
                trolley.setEditorialName(resultSet.getString("editorial_name"));
                trolley.setBookbindingName(resultSet.getString("bookbinding_name"));
                trolley.setUnits(resultSet.getInt("units"));
                trolley.setPrice(resultSet.getDouble("price"));
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
        return trolley;
    }
    
    @Override
    public boolean existByBookId(int bookId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        boolean exist = false;
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_EXIST_BY_BOOK_ID);
            preparedStatement.setInt(1, bookId);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                exist=true;
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
        return exist;
    }
    
    @Override
    public void deleteById(int trolleyId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setInt(1, trolleyId);
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
    public void deleteBookById(int bookId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_BOOK_ID);
            preparedStatement.setInt(1, bookId);
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
    public void deleteAll() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_ALL);
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
    public double getSumPrices() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        double totalPrice = 0;
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_SUM_PRICES);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                totalPrice = resultSet.getDouble("total_price");
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
        return totalPrice;
    }
    
    @Override
    public int getCount() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_COUNT);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                count = resultSet.getInt("count");
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
        return count;
    }
}
