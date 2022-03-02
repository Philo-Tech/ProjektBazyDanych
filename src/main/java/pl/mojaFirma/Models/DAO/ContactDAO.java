package pl.mojaFirma.Models.DAO;

import pl.mojaFirma.Models.ContactModel;

import java.util.List;

public interface ContactDAO {

    void addContact(ContactModel contactModel);
    void removeContact(String number);
    List<ContactModel> getAllContacts();
}
