package com.pascualbravo.service.impl;

import com.pascualbravo.citadel.connection.ConnectionManager;
import com.pascualbravo.citadel.iface.BookDao;
import com.pascualbravo.citadel.models.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    private static final String SQL_INSERT="INSERT INTO book (name, author, editorial_id, bookbinding_id, book_year, num_pages, edition, category_id, units, price, enabled) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    private static final String SQL_SELECT_BY_ENABLED="SELECT b.*, e.name as editorial_name, d.name as bookbinding_name, c.name as category_name FROM book b "
            + "INNER JOIN editorial e ON b.editorial_id = e.editorial_id "
            + "INNER JOIN bookbinding d ON b.bookbinding_id = d.bookbinding_id "
            + "INNER JOIN category c ON b.category_id = c.category_id WHERE b.enabled=?";
    
    private static final String SQL_SELECT_BY_ID="SELECT b.*, e.name as editorial_name, d.name as bookbinding_name, c.name as category_name FROM book b "
            + "INNER JOIN editorial e ON b.editorial_id = e.editorial_id "
            + "INNER JOIN bookbinding d ON b.bookbinding_id = d.bookbinding_id "
            + "INNER JOIN category c ON b.category_id = c.category_id WHERE b.book_id = ? LIMIT 1;";
    
    private static final String SQL_UPDATE = "UPDATE book SET name=?, author=?, editorial_id=?, bookbinding_id=?, book_year=?, num_pages=?, edition=?, "
            + "category_id=?, units=?, price=?, enabled=? WHERE book_id=?;";
            
    private static final String SQL_UPDATE_ENABLED="UPDATE book SET units=0, enabled=false WHERE book_id=?;";
    
    @Override
    public void create(Book book) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        
        try{
            connection = ConnectionManager.getConnection();
            
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3,book.getEditorialId());
            preparedStatement.setInt(4, book.getBookbindingId());
            preparedStatement.setInt(5, book.getBookYear());
            preparedStatement.setInt(6, book.getNumPages());
            preparedStatement.setString(7, book.getEdition());
            preparedStatement.setInt(8, book.getCategoryId());
            preparedStatement.setInt(9, book.getUnits());
            preparedStatement.setDouble(10, book.getPrice());
            preparedStatement.setBoolean(11, book.getEnabled());
            
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
    public List<Book> all(boolean enabled) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> books = null;
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ENABLED);
            preparedStatement.setBoolean(1, enabled);
            resultSet=preparedStatement.executeQuery();
            books = new ArrayList<>();
            
            while(resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setEditorialId(resultSet.getInt("editorial_id"));
                book.setEditorialName(resultSet.getString("editorial_name"));
                book.setBookbindingId(resultSet.getInt("bookbinding_id"));
                book.setBookbindingName(resultSet.getString("bookbinding_name"));
                book.setBookYear(resultSet.getInt("book_year"));
                book.setNumPages(resultSet.getInt("num_pages"));
                book.setEdition(resultSet.getString("edition"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setCategoryName(resultSet.getString("category_name"));
                book.setUnits(resultSet.getInt("units"));
                book.setPrice(resultSet.getDouble("price"));
                book.setEnabled(resultSet.getBoolean("enabled"));
                
                books.add(book);
            }
        }finally{
            if(resultSet != null){
                resultSet.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(connection!=null){
                connection.close();
            }
        }
        return books;
    }

    @Override
    public Book findById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        try{    
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setEditorialId(resultSet.getInt("editorial_id"));
                book.setEditorialName(resultSet.getString("editorial_name"));
                book.setBookbindingId(resultSet.getInt("bookbinding_id"));
                book.setBookbindingName(resultSet.getString("bookbinding_name"));
                book.setBookYear(resultSet.getInt("book_year"));
                book.setNumPages(resultSet.getInt("num_pages"));
                book.setEdition(resultSet.getString("edition"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setCategoryName(resultSet.getString("category_name"));
                book.setUnits(resultSet.getInt("units"));
                book.setPrice(resultSet.getDouble("price"));
                book.setEnabled(resultSet.getBoolean("enabled"));
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
        return book;
    }

    @Override
    public void update(Book book) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getEditorialId());
            preparedStatement.setInt(4, book.getBookbindingId());
            preparedStatement.setInt(5, book.getBookYear());
            preparedStatement.setInt(6, book.getNumPages());
            preparedStatement.setString(7, book.getEdition());
            preparedStatement.setInt(8, book.getCategoryId());
            preparedStatement.setInt(9, book.getUnits());
            preparedStatement.setDouble(10, book.getPrice());
            preparedStatement.setBoolean(11, book.getEnabled());
            preparedStatement.setInt(12, book.getBookId());
            
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
    public void updateEnabled(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ENABLED);
            preparedStatement.setInt(1, id);
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

}
