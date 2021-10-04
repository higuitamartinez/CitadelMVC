package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.Trolley;
import java.sql.SQLException;
import java.util.List;

public interface TrolleyDao {
    void create(Trolley trolley) throws SQLException;;
    List<Trolley> all() throws SQLException;
    Trolley findById(int trolleyId) throws SQLException;
    Trolley findByBookId(int bookId) throws SQLException;
    boolean existByBookId(int bookId) throws SQLException;
    double getSumPrices() throws SQLException;
    void deleteBookById(int bookId) throws SQLException;
    void deleteById(int trolleyId) throws SQLException;
    void deleteAll() throws SQLException;
    int getCount() throws SQLException;
}
