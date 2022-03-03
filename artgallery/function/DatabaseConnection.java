package artgallery.function;

import java.sql.Connection;
import java.sql.DriverManager;

/*
å°†æ•°æ�®åº“è¿�æ�¥å°�è£…
 */
public class DatabaseConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {

            String URL = "jdbc:mysql://localhost:3306/ag?serverTimezone=UTC";
            String USERNAME = "root";
            String PASSWORD = "niuweiming";
            Class.forName("com.mysql.cj.jdbc.Driver"); //åŠ è½½é©±åŠ¨
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //å¾—åˆ°è¿�æ�¥

            System.out.println("å·²æˆ�åŠŸè¿�æ�¥æ•°æ�®åº“...");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}