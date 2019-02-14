package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:databases\\testjava.db");
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

            statement.execute("DELETE FROM contacts WHERE name='Joe'");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
