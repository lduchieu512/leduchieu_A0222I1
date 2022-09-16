package repository.Impl;

import model.Van_phong;
import repository.BaseRepository;
import repository.IVan_phong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Van_phong_Dao implements IVan_phong {
    private static final String SELECT_ALL="SELECT * FROM bai_thi_mudole3.van_phong;";

    @Override
    public List<Van_phong> findByAll() throws SQLException {
        List<Van_phong> van_phongList =new ArrayList<>();
        Connection connection =  BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet rs =preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("loai_van_phong");
            Van_phong van_phong = new Van_phong(id,name);
            van_phongList.add(van_phong);
        }
        return van_phongList;
    }
}
