package pl.mojaFirma;

import pl.mojaFirma.Models.ContactModel;
import pl.mojaFirma.Models.DAO.ContactDAO;
import pl.mojaFirma.Models.DAO.impl.ContactDAOmysqlImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response;
        ContactDAO contactDAO = new ContactDAOmysqlImpl();

        do {
            System.out.println("1- aby dodac kontakt ");
            System.out.println("2- aby usunać kontakt ");
            System.out.println("3- aby wyswietlic wszystkie kontakty ");
            System.out.println("exit- aby wyjsc ");

            System.out.println("Wybieraj: ");
            response = scanner.nextLine();


            switch (response) {
                case "1": {
                    ContactModel contactModel = new ContactModel(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    contactDAO.addContact(contactModel);
                    break;
                }
                case "2":{
                    System.out.println("podaj numer tel");
                    contactDAO.removeContact(scanner.nextLine());
                    break;
                }
                case "3":{
                    for (ContactModel allContact : contactDAO.getAllContacts()) {
                        System.out.println(allContact.toString());
                    }
                    break;
                }
            }
        } while (!response.equals("exit"));


        // MySQLConnector mySQLConnector = MySQLConnector.getInstance();

        /* try {
         *//*Statement statement = mySQLConnector.getMySqlConnection().createStatement();
         *//**//*statement.execute
                    ("INSERT INTO book VALUES(0, 'Książka dodana z JDBC', 'Nowy autor', 50, '1900-01-01', 45)");*//**//*
            ResultSet resultSet = statement.executeQuery("SELECT * from book WHERE pages < 200;");

            while (resultSet.next()){
                System.out.println(resultSet.getString("title") +" | "+ resultSet.getString("author") +" | "+ resultSet.getInt("pages"));
            }*//*
         *//*PreparedStatement preparedStatement =mySQLConnector.getMySqlConnection().prepareStatement(
                    "SELECT * FROM book WHERE pages > ? AND title LIKE ?"
            );
            preparedStatement.setInt(1, 200);
            preparedStatement.setString(2,"%JAVA%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("title"));
            }*//*

            PreparedStatement preparedStatement = mySQLConnector.getMySqlConnection().prepareStatement(
                    "INSERT INTO book VALUES(?,?,?,?,?,?)"
            );

            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,"Ksiazka z prepare Statement");
            preparedStatement.setString(3,"Marcin");
            preparedStatement.setInt(4,500);
            preparedStatement.setString(5,"2020-02-20");
            preparedStatement.setInt(6, 100);

            preparedStatement.execute();

            System.out.println("wykonano wpis do BD");

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
