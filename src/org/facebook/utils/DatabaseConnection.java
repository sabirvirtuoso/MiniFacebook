/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.utils;

import java.sql.Connection;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Tanveer
 */
public class DatabaseConnection {

    private static DataSource dataSource;

    static {
        Context ctx = null;
        try {
            setupDataSource();
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static void setupDataSource() throws PropertyVetoException {
        try {
            InitialContext cxt = new InitialContext();
            dataSource = (DataSource) cxt.lookup("java:comp/env/jdbc/facebookdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
