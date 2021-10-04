package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.Book;
import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    void create(Book book) throws SQLException;
    List<Book> all(boolean enabled) throws SQLException;
    Book findById(int id) throws SQLException;
    void update(Book book) throws SQLException;
    void updateEnabled(int id) throws SQLException;
}
