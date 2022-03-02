package pl.mojaFirma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    //Ustawienia danych dostepowych do bazy
    private static final String SQL_LINK = "jdbc:mysql://127.0.0.1:3306/dbcontacts";
    private static final String SQL_USER = "root";
    private static final String SQL_PASS = "";
    private static final String SQL_CLASS = "com.mysql.jdbc.Driver";

    private Connection connection;

    private MySQLConnector() {
        dbConnectionSettings();
    }

    private static MySQLConnector mySQLConnector = new MySQLConnector();

    public static MySQLConnector getInstance() {
        return mySQLConnector;
    }

    private void dbConnectionSettings() {
        try {
            Class.forName(SQL_CLASS);
            connection = DriverManager.getConnection(SQL_LINK, SQL_USER, SQL_PASS);
            System.out.println("Połączono z bazą ");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getMySqlConnection() {
        return connection;
    }
}
