package com.example.phonebookapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    private static Connection dbConn;


    public static Connection getConnection() {
        if (dbConn == null) {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/phone_book_db";
            String dbUser = "teluser";
            String dbPassword = "1111";

            try {
                Class.forName(dbDriver);
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//                System.out.println("DB연결 성공");
            } catch (Exception e) {
                System.out.println("DB연결 실패");
                e.printStackTrace();
            }
        }
        return dbConn;
    }

    public static void close(){


    }
}