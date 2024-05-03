package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection CON;

    public DAO() {
        if (CON == null) {
            String dbUrl = "jdbc:mysql://localhost:3306/lib?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.jdbc.Driver";
            try {
                Class.forName(dbClass);
                CON = DriverManager.getConnection(dbUrl, "root", "12122003");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }    }
}
