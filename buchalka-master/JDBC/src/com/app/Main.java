package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:databases" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //conn.setAutoCommit(false);

            Statement statement = conn.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    "(name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Joe', 123123, 'joe@email.com')");
//
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Jane', 098098, 'jane@email.com')");
//
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Dudley', 8484, 'duds@email.com')");

//            statement.execute("UPDATE contacts SET phone='01298' WHERE name='Jane'");

//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

            // querying with .execute
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();

            // querying with .executeQuery
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()) {
                System.out.println(
                        results.getString(COLUMN_NAME) + " " +
                        results.getString(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL)
                );
            }

            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
