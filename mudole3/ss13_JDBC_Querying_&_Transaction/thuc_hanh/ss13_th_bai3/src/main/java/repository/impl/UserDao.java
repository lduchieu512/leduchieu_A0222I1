package repository.impl;

import model.User;
import repository.IUserDao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ss13_th_b1";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_USER_SQL="insert into users(name, email, country) values(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_ALL_USERS_NAME = "select * from users order by `name`;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    public UserDao(){
    }
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.getStackTrace();
        }

    }

    @Override
    public User selectUser(int id) throws SQLException {
        User user = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id,name,email,country);
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)){
            statement.setInt(1,id);
            rowUpdated = statement.executeUpdate() >0;
        }
        return rowUpdated;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)){
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            rowUpdated = statement.executeUpdate() >0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchName(String name) throws SQLException {
        List<User> res = new ArrayList<>();
        for (User user : selectAllUser()) {
            if (user.getName().contains(name));
            res.add(user);
            return res;
        }
        return null;
    }

    @Override
    public List<User> sortName() throws SQLException{
        List<User> users = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_NAME);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id,name,email,country));
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query="{CALL get_user_by_id(?)}";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection()){
            // Step 2:Create a statement using connection object
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user= new User(name,email,country);
            }

        } catch (SQLException throwables) {


        }

        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
        try (Connection connection = getConnection()){
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,user.getName());
            callableStatement.setString(2,user.getEmail());
            callableStatement.setString(3,user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            // Run list of update commands



            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));



            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();



        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private void printSQLException(SQLException ex){
        for (Throwable e: ex){
            if (e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: "+((SQLException)e).getSQLState());
                System.err.println("Error Code: "+((SQLException)e).getErrorCode());
                System.err.println("Message: "+e.getMessage());
                Throwable t = ex.getCause();
                while (t !=null){
                    System.out.println("Cause: "+t);
                    t=t.getCause();
                }
            }
        }
    }
}
