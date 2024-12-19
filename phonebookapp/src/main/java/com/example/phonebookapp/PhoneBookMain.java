package com.example.phonebookapp;

import com.example.phonebookapp.db.DBConn;

import java.sql.Connection;

public class PhoneBookMain {
    public static void main(String[] args) {
        Connection dbConn = DBConn.getConnection();
    }
}
