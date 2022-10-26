package org.hposadas.bibliotheque.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    //attributes statiques de connection
    private static String url = "jdbc:mysql://localhost:3306/biblioteque?serverTimezone=America/Mexico_City";
    private static String username = "root";
    private static String password = "1234";

    //methodes
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
