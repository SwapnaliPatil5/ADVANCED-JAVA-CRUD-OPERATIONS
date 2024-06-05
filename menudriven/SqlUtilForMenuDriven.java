/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudriven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author swapn
 */
public class SqlUtilForMenuDriven {
     final static String DB_USER = "root";
    final static String DB_PASSWORD = "cdac";
    final static String DB_NAME = "cdac_java";
    final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    final static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    static Statement stmt = null;
    static Connection conn = null;

    static void connectDb() {
        try {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
        } catch (Exception ex) {
            System.out.println("Error connecting to the database: " + ex.getMessage());
        }
    }

    static int insert(String qry) {
        int result = -1;
        if (qry!="") {
            try {
                result = stmt.executeUpdate(qry);
            } catch (Exception e) {
                System.out.println("Error executing insert: " + e.getMessage());
            }
        }
        return result;
    }

    static ResultSet fetch(String qry) {
        ResultSet rs = null;
        if (qry!="") {
            try {
                rs = stmt.executeQuery(qry);
            } catch (Exception e) {
                System.out.println("Error executing fetch: " + e.getMessage());
            }
        }
        return rs;
    }

    static int update(String qry) {
        int result = -1;
        if (qry!="") {
            try {
                result = stmt.executeUpdate(qry);
            } catch (Exception e) {
                System.out.println("Error executing update: " + e.getMessage());
            }
        }
        return result;
    }

    static int delete(String qry) {
        int result = -1;
        if (qry!="") {
            try {
                result = stmt.executeUpdate(qry);
            } catch (Exception e) {
                System.out.println("Error executing delete: " + e.getMessage());
            }
        }
        return result;
    }

    static void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            System.out.println("Error closing the connection: " + ex.getMessage());
        }
    }
}
