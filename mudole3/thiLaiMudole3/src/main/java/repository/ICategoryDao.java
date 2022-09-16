package repository;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
    List<Category> findByAll() throws SQLException;
}
