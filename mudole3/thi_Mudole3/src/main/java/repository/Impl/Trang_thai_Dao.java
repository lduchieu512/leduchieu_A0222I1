package repository.Impl;

import model.Trang_thai;
import model.Van_phong;
import repository.BaseRepository;
import repository.ITrang_thai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Trang_thai_Dao implements ITrang_thai {
    private static final String SELECT_ALL="SELECT * FROM bai_thi_mudole3.trang_thai;";

    @Override
    public List<Trang_thai> findByAll() throws SQLException {
        List<Trang_thai> trang_thaiList =new ArrayList<>();
        Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet rs =preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("loai_trang_thai");
            Trang_thai trang_thai = new Trang_thai(id,name);
            trang_thaiList.add(trang_thai);
        }
        return trang_thaiList;
    }
}
