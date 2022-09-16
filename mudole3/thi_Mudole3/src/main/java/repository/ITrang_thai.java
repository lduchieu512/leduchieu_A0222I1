package repository;

import model.Trang_thai;

import java.sql.SQLException;
import java.util.List;

public interface ITrang_thai {
    List<Trang_thai> findByAll() throws SQLException;

}
