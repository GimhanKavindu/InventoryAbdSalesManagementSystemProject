/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Gimhan Kavindu
 */
public class DBConnect {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/InventoryAbdSalesManagementSystemProject";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final Logger logger = Logger.getLogger(DBConnect.class.getName());

    private static Connection conn = null;

    public DBConnect() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Reconnecting to DB failed", e);
        }
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Reconnecting to DB failed", e);
        }
        return conn;
    }
}
