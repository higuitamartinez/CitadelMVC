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
import com.pascualbravo.citadel.models.Trolley;
import com.pascualbravo.service.impl.BookDaoImpl;
import com.pascualbravo.service.impl.BookbindingDaoImpl;
import com.pascualbravo.service.impl.CategoryDaoImpl;
import com.pascualbravo.service.impl.EditorialDaoImpl;
import com.pascualbravo.service.impl.TrolleyDaoImpl;
import java.awt.TextField;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HIGUITA
 */
public class SaveController {
    public static SaveController instance = null;
    
    private final BookDao bookDao;
    private final CategoryDao categoryDao;
    private final EditorialDao editorialDao;
    private final BookbindingDao bookbindingDao;
    private final TrolleyDao trolleyDao;
    
    private SaveController(){
        bookDao = new BookDaoImpl();
        categoryDao = new CategoryDaoImpl();
        editorialDao = new EditorialDaoImpl();
        bookbindingDao = new BookbindingDaoImpl();
        trolleyDao = new TrolleyDaoImpl();
    }
    
    public static SaveController getInstance(){
        if(instance == null){
            instance = new SaveController();
        }
        return instance;
    }
    
    /*Validación de datos*/
    private boolean validateInt(String value){
        int validate;
        
        try{
            validate = Integer.parseInt(value);
            if(validate<0){
                return false;
            }
            return true;
            
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    private boolean validateDouble(String value){
        double validate;
        
        try{
            validate = Double.parseDouble(value);
            if(validate<0){
                return false;
            }
            return true;
            
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    private boolean validateText(String value){
        if(value == null || value.isEmpty()){
            return false;
        }
        return true;
    }
    
    public String validateData(String name, String author, String category,String editorial, String bookbinding, String bookYear, String numPages, String edition, String units, String price){
        
        StringBuilder stringBuilder = new StringBuilder();
        
        if(!validateText(name)){
            stringBuilder.append("El Nombre del Libro es requerido\n");
        }
        
        if(!validateText(author)){
            stringBuilder.append("El Autor es requerido\n");
        }
        
        if(!validateText(category)){
            stringBuilder.append("La Categoría es requerida\n");
        }
        else if(!validateInt(category)){
            stringBuilder.append("La Categoría debe de ser un dato numérico entero\n");
        }
       
        if(!validateText(editorial)){
            stringBuilder.append("La Editorial es requerida\n");
        }
        else if(!validateInt(editorial)){
            stringBuilder.append("La Editorial debe de ser un dato numérico entero\n");
        }
        
        if(!validateText(bookbinding)){
            stringBuilder.append("El tipo de Pasta  es requerido\n");
        }
        else if(!validateInt(bookbinding)){
            stringBuilder.append("El tipo de Pasta debe de ser un dato numérico entero\n");
        }
        
        if(!validateText(bookYear)){
            stringBuilder.append("El Año es requerido\n");
        }
        else if(!validateInt(bookYear)){
            stringBuilder.append("El Año debe de ser un dato numérico entero\n");
        }
        
        if(!validateText(numPages)){
            stringBuilder.append("El Número de Páginas es requerido\n");
        }
        else if(!validateInt(numPages)){
            stringBuilder.append("El Número de Páginas debe de ser un dato numérico entero\n");
        }
        
        if(!validateText(edition)){
            stringBuilder.append("La Edición es requerida\n");
        }
        
        if(!validateText(units)){
            stringBuilder.append("Las Unidades son requeridas\n");
        }
        else if(!validateInt(units)){
            stringBuilder.append("Las Unidades deben de ser un dato numérico entero\n");
        }
        
        if(!validateText(price)){
            stringBuilder.append("El Precio es requerido\n");
        }
        else if(!validateDouble(price)){
            stringBuilder.append("El precio debe de ser un dato numérico\n");
        }
        
        return stringBuilder.toString();
    }
    
    public String validateExist(int editorial, int bookbinding, int category) throws SQLException{
        StringBuilder stringBuilder = new StringBuilder();
        
        if(editorialDao.findById(editorial) == null){
            stringBuilder.append("La Editorial escrita no existe\n");
        }
        
        if(bookbindingDao.findById(bookbinding) == null){
            stringBuilder.append("El tipo de pasta escrito no existe\n");
        }
        
        if(categoryDao.findById(category) == null){
            stringBuilder.append("La Categoría escrita no existe\n");
        }
        
        return stringBuilder.toString();
    }
    
    public void clearText(TextField textField){
        textField.setText("");
    }
    
    public void dataUpdateBook(int bookId, TextField idBook, TextField name, TextField author, TextField category,TextField editorial, TextField bookbinding, TextField bookYear, TextField numPages, TextField edition, TextField units, TextField price) throws SQLException{
        Book book = bookDao.findById(bookId);
        
        if(book != null){
            idBook.setText(String.valueOf(book.getBookId()));
            name.setText(book.getName());
            author.setText(book.getAuthor());
            category.setText(String.valueOf(book.getCategoryId()));
            editorial.setText(String.valueOf(book.getEditorialId()));
            bookbinding.setText(String.valueOf(book.getBookbindingId()));
            bookYear.setText(String.valueOf(book.getBookYear()));
            numPages.setText(String.valueOf(book.getNumPages()));
            edition.setText(book.getEdition());
            units.setText(String.valueOf(book.getUnits()));
            price.setText(String.valueOf(book.getPrice()));
            
        }
    }
    
    
    //Instrucciones SQL
    
    public void createBook(String name, String author, String category,String editorial, String bookbinding, String bookYear, String numPages, String edition, String units, String price) throws SQLException{
        Book book = new Book();
        
        book.setName(name.trim());
        book.setAuthor(author.trim());
        book.setCategoryId(Integer.parseInt(category.trim()));
        book.setEditorialId(Integer.parseInt(editorial.trim()));
        book.setBookbindingId(Integer.parseInt(bookbinding.trim()));
        book.setBookYear(Integer.parseInt(bookYear.trim()));
        book.setNumPages(Integer.parseInt(numPages.trim()));
        book.setEdition(edition.trim());
        book.setUnits(Integer.parseInt(units.trim()));
        book.setPrice(Double.parseDouble(price.trim()));
        
        if(Integer.parseInt(units) > 0){
            book.setEnabled(true);
        }else{
            book.setEnabled(false);
        }
        bookDao.create(book);
    }
    
    public void updateBook(int bookId, String name, String author, String category,String editorial, String bookbinding, String bookYear, String numPages, String edition, String units, String price) throws SQLException{
        Book book = new Book();
        
        book.setBookId(bookId);
        book.setName(name.trim());
        book.setAuthor(author.trim());
        book.setCategoryId(Integer.parseInt(category.trim()));
        book.setEditorialId(Integer.parseInt(editorial.trim()));
        book.setBookbindingId(Integer.parseInt(bookbinding.trim()));
        book.setBookYear(Integer.parseInt(bookYear.trim()));
        book.setNumPages(Integer.parseInt(numPages.trim()));
        book.setEdition(edition.trim());
        book.setUnits(Integer.parseInt(units.trim()));
        book.setPrice(Double.parseDouble(price.trim()));
        
        if(Integer.parseInt(units) > 0){
            book.setEnabled(true);
        }else{
            book.setEnabled(false);
        }
        Trolley trolley = trolleyDao.findByBookId(bookId);
        if(trolley != null){
            if(trolley.getUnits() > book.getUnits()){
                trolleyDao.deleteBookById(bookId);
            }
        }
        
        bookDao.update(book);
    }
    
    public Book getBookByBookId(int bookId) throws SQLException{
        return bookDao.findById(bookId);
    }
}
