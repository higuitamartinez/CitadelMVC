package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.Sale;
import java.sql.SQLException;
import java.util.List;

public interface SaleDao {
    void create(Sale sale) throws SQLException;
    List<Sale> all() throws SQLException;
    int getMaxSaleId() throws SQLException;
}
