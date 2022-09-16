package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    void insertUser(User user) throws SQLException ;
    User selectUser(int id) throws SQLException;
    List<User> selectAllUser ()throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
     List<User> searchName(String name) throws SQLException;
     List<User> sortName() throws SQLException;
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
    void addUserTransaction(User user, int[] permision);

}
