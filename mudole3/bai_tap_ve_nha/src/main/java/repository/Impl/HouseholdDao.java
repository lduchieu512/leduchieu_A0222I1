package repository.Impl;

import model.Household;
import repository.IHousehold;

import java.sql.SQLException;
import java.util.List;

public class HouseholdDao implements IHousehold {
    private static final String INSERT_HOUSEHOLD_SQL="INSERT INTO `can_ho`.`ho_khau` (`id`, `chu_ho`, `so_luong`, `ngay_dk`, `dia_chi`) VALUES (?,?,?,?,?);";
    private static final String SELECT_HOUSEHOLD_BY_ID="select id,chu_ho,so_luong,ngay_dk,dia_chi from ho_khau where id =?;";
    private static final String SELECT_ALL_HOUSEHOLD="";
    private static final String DELETE_HOUSEHOLD="";
    private static final String UPDATE_HOUSEHOLD="";



    @Override
    public void insertHousehold(Household household) throws SQLException {

    }

    @Override
    public Household selectHousehold(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Household> selectALLHousehold() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Household household) throws SQLException {
        return false;
    }
}
