package repository;

import model.Quan_ly;

import java.sql.SQLException;
import java.util.List;

public interface IQuan_ly {
    void insertQuanly(Quan_ly quan_ly) throws SQLException;
    Quan_ly selectQuanly (int id) throws SQLException;
    List<Quan_ly> selectAllQuanly () throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean updateQuanly(Quan_ly quan_ly) throws SQLException;
    List<Quan_ly> searchName(String name) throws SQLException;
}
