package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.Editorial;
import java.sql.SQLException;
import java.util.List;

public interface EditorialDao {
    List<Editorial> all() throws SQLException;
    Editorial findById(int editorialId) throws SQLException;
} 
