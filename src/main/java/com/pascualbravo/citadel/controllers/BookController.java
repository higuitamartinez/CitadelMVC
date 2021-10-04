/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.controllers;

import com.pascualbravo.citadel.iface.BookDao;
import com.pascualbravo.citadel.iface.BookbindingDao;
import com.pascualbravo.citadel.iface.CategoryDao;
import com.pascualbravo.citadel.iface.EditorialDao;
import com.pascualbravo.citadel.iface.TrolleyDao;
import com.pascualbravo.citadel.models.Book;
import com.pascualbravo.citadel.models.Bookbinding;
import com.pascualbravo.citadel.models.Category;
import com.pascualbravo.citadel.models.Editorial;
import com.pascualbravo.citadel.util.TableBook;
import com.pascualbravo.citadel.service.impl.BookDaoImpl;
import com.pascualbravo.citadel.service.impl.BookbindingDaoImpl;
import com.pascualbravo.citadel.service.impl.CategoryDaoImpl;
import com.pascualbravo.citadel.service.impl.EditorialDaoImpl;
import com.pascualbravo.citadel.service.impl.TrolleyDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookController {
    private static BookController instance= null;
    private static final String [] COLUMNS_BOOK_TRUE = {"CÓDIGO", "NOMBRE", "AUTOR", "EDITORIAL", "PASTA", "AÑO", "PÁGINAS", "EDICIÓN", "CATEGORÍA", "UNIDADES", "PRECIO", "AGREGAR", "EDITAR", "ELIMINAR"};
    
    private static final String [] COLUMNS_BOOK_FALSE = {"CÓDIGO", "NOMBRE", "AUTOR", "EDITORIAL", "PASTA", "AÑO", "PÁGINAS", "EDICIÓN", "CATEGORÍA", "UNIDADES", "PRECIO","EDITAR"};
    
    private final BookDao bookDao;
    private final EditorialDao editorialDao;
    private final CategoryDao categoryDao;
    private final BookbindingDao bookbindingDao;
    private final TrolleyDao trolleyDao;
    private final TableBook tableBook;
    
    private BookController(){
        bookDao = new BookDaoImpl();
        editorialDao = new EditorialDaoImpl();
        categoryDao = new CategoryDaoImpl();
        bookbindingDao = new BookbindingDaoImpl();
        trolleyDao = new TrolleyDaoImpl();
        tableBook = new TableBook();
    }
    
    public static BookController getInstance(){
        if(instance == null){
            instance= new BookController();
        }
        return instance;
    }
    
    public void loadBooksTrue(JTable jTable) throws SQLException{
        List<Book> books = bookDao.all(true);
        jTable.setRowHeight(25);
        tableBook.columnsBook(COLUMNS_BOOK_TRUE, jTable);
        
        if(books == null || books.size() == 0){
            return;
        }
        tableBook.fillBooksTrue(books, trolleyDao);
    }
    
    public void loadBooksFalse(JTable jTable) throws SQLException{
        List<Book> books = bookDao.all(false);
        jTable.setRowHeight(25);
        tableBook.columnsBook(COLUMNS_BOOK_FALSE, jTable);
        
        if(books == null || books.size() == 0){
            return;
        }
        tableBook.fillBooksFalse(books);
    }
    
    public void updateEnabledBook(int bookId) throws SQLException{
        bookDao.updateEnabled(bookId);
    }
    
    public Book getBookByBookId(int bookId) throws SQLException{
        return bookDao.findById(bookId);
    }
    
    public boolean existTrolleyByBookId(int bookId) throws SQLException{
        return trolleyDao.existByBookId(bookId);
    }
    
    public void deleteTrolleyByBookId(int bookId) throws SQLException{
        
        if(trolleyDao.existByBookId(bookId)){
            trolleyDao.deleteBookById(bookId);
        }
        trolleyDao.deleteBookById(bookId);
    }
    
    
    //Botones de la tabla
    public List<Integer> buttonBookTrue(JTable jTable, java.awt.event.MouseEvent event)     {
        int column = jTable.getColumnModel().getColumnIndexAtX(event.getX());
        int row = event.getY()/jTable.getRowHeight();
        
        if(column<jTable.getColumnCount() && column >=0 && row<jTable.getRowCount() && row>=0){
            
            Object object = jTable.getValueAt(row, column);
            
            if(object instanceof JButton){
                ((JButton)object).doClick();
                List<Integer> option = new ArrayList<>();
                JButton jButton = (JButton)object;
                
                if(jButton.getName().equals("trolley")){
                    option.add(0);
                }
                
                if(jButton.getName().equals("update")){
                    option.add(1);
                }
                
                if(jButton.getName().equals("delete")){
                    option.add(2);
                }
                option.add(row);
                return option;
            }
        }
        return null;
    }
    
    public int buttonBookFalse(JTable jTable, java.awt.event.MouseEvent event){
        int column = jTable.getColumnModel().getColumnIndexAtX(event.getX());
        int row = event.getY()/jTable.getRowHeight();
        
        if(column<jTable.getColumnCount() && column >=0 && row<jTable.getRowCount() && row>=0){
            Object object = jTable.getValueAt(row, column);
            
            if(object instanceof JButton){
                ((JButton)object).doClick();
                JButton jButton = (JButton)object;
                
                if(jButton.getName().equals("update")){
                   return row;
                }
            }
        }
        return -1;
    }

}
