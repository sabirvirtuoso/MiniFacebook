/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.utils;

import org.facebook.dao.rowmappers.ObjectRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanveer
 */
public class DatabaseTemplate {

    public static void executeUpdate(String sql, Object... params) {
        Connection conToUse = null;
        PreparedStatement stmt = null;
        try {
            conToUse = DatabaseConnection.getConnection();
            stmt = conToUse.prepareStatement(sql);

            for (int i = 1; i <= params.length; i++) {
                stmt.setObject(i, params[i - 1]);
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (conToUse != null)
                closeConnection(conToUse);
        }
    }

    public static <E> List<E> queryForObject(String sql, ObjectRowMapper<E> objectRowMapper, Object... params) {
        Connection conToUse = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();
        try {
            conToUse = DatabaseConnection.getConnection();
            stmt = conToUse.prepareStatement(sql);

            for (int i = 1; i <= params.length; i++) {
                stmt.setObject(i, params[i - 1]);
            }
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (conToUse != null)
                closeConnection(conToUse);
        }
        return listOfE;
    }

    private static void closeConnection(Connection conToClose) {
        try {
            conToClose.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
