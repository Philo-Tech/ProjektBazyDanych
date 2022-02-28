package pl.mojaFirma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    //Ustawienia danych dostepowych do bazy
    private static final  String SQL_LINK ="jdbc:mysql://127.0.0.1:3306/book";
    private static final  String SQL_USER="root";
    private static final  String SQL_PASS="";
    private static final  String SQL_CLASS="com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {

        try {
            Class.forName(SQL_CLASS);
            Connection connection = DriverManager.getConnection(SQL_LINK,SQL_USER,SQL_PASS);
            System.out.println("Połączono z bazą ");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
