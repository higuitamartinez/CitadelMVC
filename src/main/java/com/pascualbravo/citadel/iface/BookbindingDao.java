package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.Bookbinding;
import java.sql.SQLException;
import java.util.List;

public interface BookbindingDao {
    List<Bookbinding> all() throws SQLException;
    Bookbinding findById(int bookbindingId) throws SQLException;
}
