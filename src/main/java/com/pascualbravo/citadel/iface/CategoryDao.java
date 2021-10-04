package com.pascualbravo.citadel.iface;

import com.pascualbravo.citadel.models.Category;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> all() throws SQLException;
    Category findById(int categoryId) throws SQLException;
}
