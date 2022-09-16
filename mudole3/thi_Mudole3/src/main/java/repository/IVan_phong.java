package repository;

import model.Van_phong;

import java.sql.SQLException;
import java.util.List;

public interface IVan_phong {
    List<Van_phong> findByAll() throws SQLException;

}
