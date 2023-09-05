package interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T getOne(int id) throws SQLException;

    List<T> getALL() throws SQLException;

    T insert(T t) throws SQLException;

    T update(T t) throws SQLException;

    int delete(T t) throws SQLException;
}
