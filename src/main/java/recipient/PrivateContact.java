package recipient;

public class PrivateContact {
    String name;
    String lastName;
    String mail;
    String phone;

    public PrivateContact(String name, String lastName, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }

    public PrivateContact(String name, String lastName, String mail, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }
}
