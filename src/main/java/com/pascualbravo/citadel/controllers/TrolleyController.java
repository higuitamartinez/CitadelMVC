
package com.pascualbravo.citadel.controllers;

import com.pascualbravo.citadel.iface.BookDao;
import com.pascualbravo.citadel.iface.RegisterSaleDao;
import com.pascualbravo.citadel.iface.SaleDao;
import com.pascualbravo.citadel.iface.TrolleyDao;
import com.pascualbravo.citadel.models.Book;
import com.pascualbravo.citadel.models.RegisterSale;
import com.pascualbravo.citadel.models.Sale;
import com.pascualbravo.citadel.models.Trolley;
import com.pascualbravo.citadel.util.TableTrolley;
import com.pascualbravo.citadel.service.impl.BookDaoImpl;
import com.pascualbravo.citadel.service.impl.RegisterSaleDaoImpl;
import com.pascualbravo.citadel.service.impl.SaleDaoImpl;
import com.pascualbravo.citadel.service.impl.TrolleyDaoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;


public class TrolleyController {
    private static TrolleyController instance = null;
    private static final String [] COLUMNS_TROLLEY = {"CÓDIGO", "NOMBRE", "AUTOR", "EDITORIAL", "PASTA", "UNIDADES", "PRECIO", "ELIMINAR"};
    
    private BookDao bookDao;
    private TrolleyDao trolleyDao;
    private SaleDao saleDao;
    private RegisterSaleDao registerSaleDao;
    private TableTrolley tableTrolley;
    
    private TrolleyController(){
        bookDao = new BookDaoImpl();
        trolleyDao = new TrolleyDaoImpl();
        saleDao = new SaleDaoImpl();
        registerSaleDao = new RegisterSaleDaoImpl();
        tableTrolley=new TableTrolley();
    }
    
    public static TrolleyController getInstance(){
        if(instance == null){
            instance = new TrolleyController();
        }
        return instance;
    }
    
    public List<Trolley> all() throws SQLException{
        return trolleyDao.all();
    }
    
    public Trolley getTrolleyById(int trolleyId) throws SQLException{
        return trolleyDao.findById(trolleyId);
    }
    
    public Trolley getTrolleyByBookId(int bookId) throws SQLException{
        return trolleyDao.findByBookId(bookId);
    }
    
    //Book
    public Book getBookByBookId(int bookId) throws SQLException{
        return bookDao.findById(bookId);
    }
    
    //Trolley
    public void loadTrolley(JTable jTable) throws SQLException{
        List<Trolley> trolley = trolleyDao.all();
        jTable.setRowHeight(25);
        tableTrolley.columnsTrolley(COLUMNS_TROLLEY, jTable);
        
        if(trolley == null || trolley.size() == 0){
            return;
        }
        tableTrolley.fillTrolley(trolley);
    }
    
    public void deleteById(int trolleyId) throws SQLException{
        trolleyDao.deleteById(trolleyId);
    }
    
    public void deleteBookById(int bookId) throws SQLException{
        trolleyDao.deleteBookById(bookId);
    }
    
    public void deleteAll() throws SQLException{
        trolleyDao.deleteAll();
    }
    
    public int getCount() throws SQLException{
        return trolleyDao.getCount();
    }
    
    public double getSumPrices() throws SQLException{
        return trolleyDao.getSumPrices();
    }
    
    public Integer[] buttonTableTrolley(JTable jTable, java.awt.event.MouseEvent event){
        int column = jTable.getColumnModel().getColumnIndexAtX(event.getX());
        int row = event.getY()/jTable.getRowHeight();
        
        if(column >=0 && row>=0){
            Object object = jTable.getValueAt(row, column);
            
            if(object instanceof JButton){
                ((JButton) object).doClick();
                Integer[] option = new Integer[2];
                JButton jButton = (JButton)object;
                
                if(jButton.getName().equals("delete")){
                    option[0] = 0;
                }
                option[1] = row;
                return option;
            }
        }
        return null;
    }
    
    //Sale
    public void createSale() throws SQLException{
        //1. Crear la venta
        double totalPrice = getSumPrices();
        Sale sale = new Sale();
        sale.setTotalPrice(totalPrice);
        saleDao.create(sale);
        
        //2. Creamos los registros de cada venta
        createRegisterSale();
    }
    
    //Register sale
    private void createRegisterSale() throws SQLException{
        //1. Consultar el carrito para obtener los productos
        List<Trolley> trolley = trolleyDao.all();
        
        //2. Recorrer el arreglo e ir creando los registers sales
        for(Trolley trolleyObj : trolley){
            Book book = bookDao.findById(trolleyObj.getBookId());
            book.setUnits(book.getUnits() - trolleyObj.getUnits());
            if(book.getUnits() == 0){
                book.setEnabled(false);
            }
            bookDao.update(book);
            RegisterSale registerSale = new RegisterSale();
            registerSale.setSaleId(saleDao.getMaxSaleId());
            registerSale.setBookId(trolleyObj.getBookId());
            registerSale.setUnits(trolleyObj.getUnits());
            registerSale.setTotalPrice(trolleyObj.getPrice());
            registerSaleDao.create(registerSale);
        }
    }
}
