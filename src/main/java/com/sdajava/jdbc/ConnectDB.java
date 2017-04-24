package com.sdajava.jdbc;

import java.sql.*;

/**
 * Created by RENT on 2017-04-24.
 */
public enum ConnectDB {
    INSTANCE;

    public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
            = "jdbc:mysql://localhost/ksiegarnia?" +
            "useSSL=false&useJDBCCompliantTimezoneShift=" +
            "true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public final static String USER="root";
    public final static String PASS="";

    public static Statement getConnection() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Lacze z baza danych.......");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return statement;
    }
}

