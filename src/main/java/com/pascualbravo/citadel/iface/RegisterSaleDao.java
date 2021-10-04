package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.RegisterSale;
import java.sql.SQLException;
import java.util.List;


public interface RegisterSaleDao{
    void create(RegisterSale registerSale) throws SQLException;
    List<RegisterSale> findBySaleId(int saleId) throws SQLException;
}
