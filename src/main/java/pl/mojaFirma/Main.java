package pl.mojaFirma;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        MySQLConnector mySQLConnector = MySQLConnector.getInstance();

        try {
            Statement statement = mySQLConnector.getMySqlConnection().createStatement();
            statement.execute
                    ("INSERT INTO book VALUES(0, 'Książka dodana z JDBC', 'Nowy autor', 50, '1900-01-01', 45)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
