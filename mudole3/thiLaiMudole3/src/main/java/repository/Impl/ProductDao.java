package repository.Impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private static final String INSERT_PRODUCTS_SQL="INSERT INTO `thiLaiM3`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values(?,?,?,?,?,?);";
    private static final String SELECT_PRODUCTS_BY_ID = "select id,name,price,quantity,color,description,id_category from product where id =?;";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product p  join category c on p.id_category=c.id;";
    private static final String SELECT_ALL_PRODUCTS_NAME = "select * from product order by `name`;";
    private static final String DELETE_PRODUCTS_SQL = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update product set name = ?,price= ?,quantity= ?,color= ?,description= ?, id_category =? where id = ?;";


    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCTS_SQL);
        try {

            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(INSERT_PRODUCTS_SQL);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        try {
            Connection connection =  BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                Integer category = rs.getInt("id_category");
                product = new Product(id,name,price,quantity,color,description,category);
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection =  BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            System.out.println(preparedStatement);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                Integer category = rs.getInt("id_category");
                products.add(new Product(id,name,price,quantity,color,description,category));
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTS_SQL);
        preparedStatement.setInt(1,id);
        rowDelete = preparedStatement.executeUpdate() >0;
        return rowDelete;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdate;
        Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDouble(2,product.getPrice());
        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setString(4,product.getColor());
        preparedStatement.setString(5,product.getDescription());
        preparedStatement.setInt(6,product.getCategory_id());
        preparedStatement.setInt(7,product.getId());
        rowUpdate = preparedStatement.executeUpdate() >0;
        return rowUpdate;
    }
}
