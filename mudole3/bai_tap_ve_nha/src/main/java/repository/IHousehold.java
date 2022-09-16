package repository;

import model.Household;

import java.sql.SQLException;
import java.util.List;

public interface IHousehold {
    void insertHousehold(Household household) throws SQLException;
    Household selectHousehold(int id) throws SQLException;
    List<Household> selectALLHousehold ()throws SQLException;
    boolean delete(int id)throws SQLException;
    boolean updateProduct(Household household) throws SQLException;

}
