package recipient;

public class User{

    String mail;
    String password;
    String firstName;
    String secondName;
    String phone;

    public User(String mail, String password, String firstName, String secondName, String phone) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
