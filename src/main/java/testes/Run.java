package testes;

import gui.AddContact;
import gui.AutentiLogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;
import recipient.Mail;
import recipient.PrivateContact;
import recipient.User;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class Run {
    public static void main(String[] args) throws IOException, MessagingException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/main/resources/chrome_110/chromedriver.exe").toAbsolutePath().toString());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        final String autentiPassword = System.getProperty("autentiPassword");

        File file = new File("src/main/resources/Autenti_File/autenti.pdf");
        AddContact addContact = new AddContact(webDriverWait);
        User user = new User("johndoe-do-testowania@op.pl", autentiPassword, "Jhon", "Doe", "500500500");
        User user1 = new User("Labadu-do-testowania@op.pl", autentiPassword, "Jhon", "Doe", "500500500");

        ContactCompany contactCompany = new ContactCompany("Mat", "Pat", new Mail("MatPat", "gmail.com"), "504054392", "dev", "Amazon", "1000000000");
        ContactCompany contactCompany1 = new ContactCompany("Rat", "Pat", new Mail("crocodile", "gmail.com"), "504054392", "dev", "Amazon", "1000000000");
//        ContactCompany contactCompany2 = new ContactCompany("Martin", "Nunok", "MartinNunuk@mail.com", "504547707", "Team Lead", "Apple", "1000000000", "valley", "12-321", "Las vegas");
        PrivateContact privateContact = new PrivateContact("Riczi", "Pal", "JacobPal@gma.com", "816253468");

        //#Sign up to Autenti.com
//      gui.AutentiSignUp.register(user, driver, webDriverWait);

        //# Log in
        AutentiLogIn autentiLogIn = new AutentiLogIn(webDriverWait);
        autentiLogIn.logIn(user, driver);

        //# Upload File
//        gui.CreateNewDocument.CreateDoc(webDriverWait,file,"file name");

        //# Add company contact
//        gui.ClickSubpages.clickContacts();
//        gui.AddContact.addCompanyContact(webDriverWait, contactCompany1, 100);

        //#Edit Contact
//        gui.ClickSubpages.clickContacts(webDriverWait);
//        gui.EditContact.editContact(webDriverWait,contactCompany,contactCompany2);

        //remove contact using mail
//        gui.ClickSubpages.clickContacts(webDriverWait);
//        gui.RemoveContact.removeContactGiveMail(webDriverWait,contactCompany);
        //remove all
//        gui.RemoveContact.removeAllContacts(webDriverWait);

    }
}
