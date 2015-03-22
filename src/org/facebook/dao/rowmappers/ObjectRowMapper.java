package org.facebook.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sabir.salman on 2/11/15.
 */
public interface ObjectRowMapper<E> {
    E mapRowToObject(ResultSet resultSet) throws SQLException;
}
