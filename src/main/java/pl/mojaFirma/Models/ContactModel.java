package pl.mojaFirma.Models;

public class ContactModel {

    private String number;
    private String name;
    private String lastName;

    public ContactModel(String number, String name, String lastName) {
        this.number = number;
        this.name = name;
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
