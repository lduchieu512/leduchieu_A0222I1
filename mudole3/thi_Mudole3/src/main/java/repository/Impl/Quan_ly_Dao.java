package repository.Impl;

import model.Quan_ly;
import repository.BaseRepository;
import repository.IQuan_ly;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Quan_ly_Dao implements IQuan_ly {
    private static final String INSERT_QUANLY_SQL=" INSERT INTO `bai_thi_mudole3`.`quan_ly_mat_bang` ( `ma_mat_bang`, `dien_tich`, `tang`,`mo_ta`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`, `id_trang_thai`, `id_van_phong`) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_QUANLY_BY_ID = "select `id`, `ma_mat_bang`, `dien_tich`, `tang`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`, `id_trang_thai`, `id_van_phong` from quan_ly_mat_bang where id =?;";
    private static final String SELECT_ALL_QUANLY = "SELECT * FROM quan_ly_mat_bang q join van_phong v join trang_thai t on q.`id_van_phong`=v.`id` and q.`id_trang_thai`=t.`id`;";
//    private static final String SELECT_ALL_QUANLY = "SELECT * FROM bai_thi_mudole3.quan_ly_mat_bang;";
    private static final String SELECT_ALL_QUANLY_NAME = "select * from quan_ly_mat_bang order by `ma_mat_bang`;";
    private static final String DELETE_QUANLY_SQL = "delete from quan_ly_mat_bang where id = ?;";
    private static final String UPDATE_QUANLY_SQL = "UPDATE `bai_thi_mudole3`.`quan_ly_mat_bang` SET `ma_mat_bang` =?, `dien_tich` = ?, `tang` = ?,`mo_ta`=?, `gia_cho_thue` = ?, `ngay_bat_dau` =?, `ngay_ket_thuc` = ?, `id_trang_thai` = ?, `id_van_phong` = ? WHERE `id` = ?;\n";

    public Quan_ly_Dao(){}

    @Override
    public void insertQuanly(Quan_ly quan_ly) throws SQLException {
        System.out.println(INSERT_QUANLY_SQL);
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(INSERT_QUANLY_SQL);
            preparedStatement.setString(1,quan_ly.getMa_mat_bang());
            preparedStatement.setDouble(2,quan_ly.getDien_tich());
            preparedStatement.setInt(3,quan_ly.getTang());
            preparedStatement.setString(4,quan_ly.getMo_ta());
            preparedStatement.setInt(5,quan_ly.getGia_cho_thue());
            preparedStatement.setString(6,quan_ly.getNgay_bat_dau());
            preparedStatement.setString(7,quan_ly.getNgay_ket_thuc());
            preparedStatement.setInt(8,quan_ly.getTrang_thai_id());
            preparedStatement.setInt(9,quan_ly.getVan_phong_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public Quan_ly selectQuanly(int id) throws SQLException {
        Quan_ly quan_ly = null;
        try {
            Connection connection =  BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUANLY_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String ma_MB = rs.getString("ma_mat_bang");
                Double dienTich = rs.getDouble("dien_tich");
                Integer trangThai = rs.getInt("trang_thai_id");
                Integer tang = rs.getInt("tang");
                Integer vanPhong = rs.getInt("van_phong_id");
                String moTa = rs.getString("mo_ta");
                Integer gia = rs.getInt("gia_cho_thue");
                String ngayBD = rs.getString("ngay_bat_dau");
                String ngayKT = rs.getString("ngay_ket_thuc");
                quan_ly = new Quan_ly(id,ma_MB,dienTich,trangThai,tang,vanPhong,moTa,gia,ngayBD,ngayKT);
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return quan_ly;

    }

    @Override
    public List<Quan_ly> selectAllQuanly() throws SQLException {
        List<Quan_ly> quan_ly = new ArrayList<>();
        try {
            Connection connection =  BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUANLY);
            System.out.println(preparedStatement);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String ma_MB = rs.getString("ma_mat_bang");
                Double dienTich = rs.getDouble("dien_tich");
                Integer tang = rs.getInt("tang");
                String moTa = rs.getString("mo_ta");
                Integer gia = rs.getInt("gia_cho_thue");
                String ngayBD = rs.getString("ngay_bat_dau");
                String ngayKT = rs.getString("ngay_ket_thuc");
                Integer trangThai = rs.getInt("id_trang_thai");
                Integer vanPhong = rs.getInt("id_van_phong");
                quan_ly.add(new Quan_ly(id,ma_MB,dienTich,trangThai,tang,vanPhong,moTa,gia,ngayBD,ngayKT));
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return quan_ly;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUANLY_SQL);
        preparedStatement.setInt(1,id);
        rowDelete = preparedStatement.executeUpdate() >0;
        return rowDelete;

    }

    @Override
    public boolean updateQuanly(Quan_ly quan_ly) throws SQLException {
        boolean rowUpdate;
        Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANLY_SQL);
        preparedStatement.setString(1,quan_ly.getMa_mat_bang());
        preparedStatement.setDouble(2,quan_ly.getDien_tich());
        preparedStatement.setInt(3,quan_ly.getTang());
        preparedStatement.setString(4,quan_ly.getMo_ta());
        preparedStatement.setInt(5,quan_ly.getGia_cho_thue());
        preparedStatement.setString(6,quan_ly.getNgay_bat_dau());
        preparedStatement.setString(7,quan_ly.getNgay_ket_thuc());
        preparedStatement.setInt(8,quan_ly.getTrang_thai_id());
        preparedStatement.setInt(9,quan_ly.getVan_phong_id());
        preparedStatement.setInt(10,quan_ly.getId());
        rowUpdate = preparedStatement.executeUpdate() >0;
        return rowUpdate;
    }

    @Override
    public List<Quan_ly> searchName(String maMB) throws SQLException {
        List<Quan_ly> result = new ArrayList<>();
        for (Quan_ly p:selectAllQuanly()) {
            if (p.getMa_mat_bang().contains(maMB)){
                result.add(p);
            }
        }
        return result;
    }
}
