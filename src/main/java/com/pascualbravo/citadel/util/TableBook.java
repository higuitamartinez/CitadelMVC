/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.citadel.util;

import com.pascualbravo.citadel.iface.TrolleyDao;
import com.pascualbravo.citadel.models.Book;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author HIGUITA
 */
public class TableBook {
    private TableModel tableModel;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnTrolley;
    
    public TableBook(){
        btnUpdate = new JButton("Actualizar");
        btnDelete = new JButton("Eliminar");
        btnTrolley = new JButton("Agregar");
        btnUpdate.setName("update");
        btnDelete.setName("delete");
        btnTrolley.setName("trolley");
    }
    
    public void columnsBook(String [] columns, JTable jTable){
        tableModel = new TableModel();
        
        for(String column: columns){
            tableModel.addColumn(column);
        }
        jTable.setModel(tableModel);
        jTable.setDefaultRenderer(Object.class, new Render());
    }
    
    public void fillBooksTrue(List<Book> books, TrolleyDao trolleyDao) throws SQLException{
        tableModel.setRowCount(books.size());
        int row = 0;
        
        for(Book book: books){
            tableModel.setValueAt(book.getBookId(), row, 0);
            tableModel.setValueAt(book.getName(), row, 1);
            tableModel.setValueAt(book.getAuthor(), row, 2);
            tableModel.setValueAt(book.getEditorialName(), row, 3);
            tableModel.setValueAt(book.getBookbindingName(),row, 4);
            tableModel.setValueAt(book.getBookYear(), row, 5);
            tableModel.setValueAt(book.getNumPages(), row, 6);
            tableModel.setValueAt(book.getEdition(), row, 7);
            tableModel.setValueAt(book.getCategoryName(), row, 8);
            tableModel.setValueAt(book.getUnits(), row, 9);
            tableModel.setValueAt(book.getPrice(), row, 10);
            
            if(book.getUnits() > 0 && trolleyDao.existByBookId(book.getBookId()) == false){
                tableModel.setValueAt(btnTrolley, row, 11);
            }
            
            tableModel.setValueAt(btnUpdate, row, 12);
            tableModel.setValueAt(btnDelete, row, 13);
            row+=1;
        }
    }
    
    public void fillBooksFalse(List<Book> books) throws SQLException{
        tableModel.setRowCount(books.size());
        int row =0;
        
        for(Book book: books){
            tableModel.setValueAt(book.getBookId(), row, 0);
            tableModel.setValueAt(book.getName(), row, 1);
            tableModel.setValueAt(book.getAuthor(), row, 2);
            tableModel.setValueAt(book.getEditorialName(), row, 3);
            tableModel.setValueAt(book.getBookbindingName(),row, 4);
            tableModel.setValueAt(book.getBookYear(), row, 5);
            tableModel.setValueAt(book.getNumPages(), row, 6);
            tableModel.setValueAt(book.getEdition(), row, 7);
            tableModel.setValueAt(book.getCategoryName(), row, 8);
            tableModel.setValueAt(book.getUnits(), row, 9);
            tableModel.setValueAt(book.getPrice(), row, 10);
            tableModel.setValueAt(btnUpdate, row, 11);
            row+=1;
        }
    }
}
