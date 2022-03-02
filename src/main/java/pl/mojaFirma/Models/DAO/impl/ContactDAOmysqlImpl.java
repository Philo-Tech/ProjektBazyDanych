package pl.mojaFirma.Models.DAO.impl;

import pl.mojaFirma.Models.ContactModel;
import pl.mojaFirma.Models.DAO.ContactDAO;
import pl.mojaFirma.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOmysqlImpl implements ContactDAO {

    private MySQLConnector mySQLConnector = MySQLConnector.getInstance();

    @Override
    public void addContact(ContactModel contactModel) {

        try {
            PreparedStatement preparedStatement = mySQLConnector.getMySqlConnection().prepareStatement(
                    "INSERT INTO dbcontacts VALUES(?,?,?,?)"
            );

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, contactModel.getNumber());
            preparedStatement.setString(3, contactModel.getName());
            preparedStatement.setString(4, contactModel.getLastName());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeContact(String number) {

        try {
            PreparedStatement preparedStatement = mySQLConnector.getMySqlConnection().prepareStatement(
                    "DELETE FROM dbcontacts WHERE number = ?)"
            );

            preparedStatement.setString(1, number);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<ContactModel> getAllContacts() {
        List<ContactModel> contactModels = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = mySQLConnector.getMySqlConnection().prepareStatement(
                    "SELECT * FROM dbcontacts"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                contactModels.add(new ContactModel(resultSet.getString("number"), resultSet.getString("name"), resultSet.getString("lastname")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contactModels;
    }
}
