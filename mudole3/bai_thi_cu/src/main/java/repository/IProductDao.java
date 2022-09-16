package repository;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    void insertProduct(Product product) throws SQLException;
    Product selectProduct (int id) throws SQLException;
    List<Product>selectAllProduct () throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean updateProduct(Product product) throws SQLException;



}
