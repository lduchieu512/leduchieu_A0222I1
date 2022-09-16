package repository.Impl;

import model.Category;
import repository.BaseRepository;
import repository.ICategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    private static final String SELECT_ALL="SELECT * FROM category;";
    @Override
    public List<Category> findByAll() throws SQLException {
    List<Category> categoryList =new ArrayList<>();
    Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet rs =preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Category category = new Category(id,name);
            categoryList.add(category);
        }
        return categoryList;
    }
}
