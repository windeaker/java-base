package info.windeaker.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://120.77.156.109:3306/demo?characterEncoding=utf-8&allowMultiQueries=true&useSSL=true",
                    "root",
                    "WINDeaker@0917");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
