package recipient;

public class ContactCompany {
    String name;
    String LastName;
    Mail mail;
    String phone;
    String position;


    String companyName;
    String NIP;
    String companyAddress;
    String postcode;
    String city;

    public ContactCompany(String name, String lastName, Mail mail, String phone, String position, String companyName, String NIP, String companyAdress, String postcode, String city) {
        this.name = name;
        LastName = lastName;
        this.mail = mail;
        this.phone = phone;
        this.position = position;
        this.companyName = companyName;
        this.NIP = NIP;
        this.companyAddress = companyAdress;
        this.postcode = postcode;
        this.city = city;
    }

    public ContactCompany(String name, String lastName, Mail mail, String phone, String position, String companyName, String NIP) {
        this.name = name;
        LastName = lastName;
        this.mail = mail;
        this.phone = phone;
        this.position = position;
        this.companyName = companyName;
        this.NIP = NIP;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return LastName;
    }

    public Mail getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getNIP() {
        return NIP;
    }

    public String getCompanyAdress() {
        return companyAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getMailAsString() {
        return mail.getValue();
    }
}
