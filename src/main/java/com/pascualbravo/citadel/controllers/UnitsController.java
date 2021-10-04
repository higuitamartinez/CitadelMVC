
package com.pascualbravo.citadel.controllers;

import com.pascualbravo.citadel.iface.BookDao;
import com.pascualbravo.citadel.iface.TrolleyDao;
import com.pascualbravo.citadel.models.Book;
import com.pascualbravo.citadel.models.Trolley;
import com.pascualbravo.citadel.service.impl.BookDaoImpl;
import com.pascualbravo.citadel.service.impl.TrolleyDaoImpl;
import java.sql.SQLException;


public class UnitsController {
    public static UnitsController instance = null;
    private TrolleyDao trolleyDao;
    private BookDao bookDao;
    
    private UnitsController(){
        trolleyDao = new TrolleyDaoImpl();
        bookDao = new BookDaoImpl();
    }
    
    public static UnitsController getInstance(){
        if(instance == null){
            instance = new UnitsController();
        }
        return instance;
    }
    
    public boolean getExistByBookId(int bookId) throws SQLException{
        return trolleyDao.existByBookId(bookId);
    }
    
    public Book getBookByBookId(int bookId) throws SQLException{
        return bookDao.findById(bookId);
    }
    
    //Errores
    private boolean validateInt(String value){
        int validate;
        try{
            validate = Integer.parseInt(value);
            if(validate > 0){
                return true;
            }
            return false;
            
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    public String validateData(String units){
        String errorMessage="";
        
        if(units.isEmpty()){
            errorMessage ="Las unidades son requeridas";
        }else if(!validateInt(units)){
            errorMessage="Las unidades deben de ser un valor entero";
        }
        return errorMessage;
    }
    
    //Instrucciones SQL
    public void createTrolley(int bookId, String units) throws SQLException{
        Trolley trolley = new Trolley();
        trolley.setBookId(bookId);
        trolley.setUnits(Integer.parseInt(units));
        trolleyDao.create(trolley);
    }
}
