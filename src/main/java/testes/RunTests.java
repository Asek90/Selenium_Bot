package testes;

import gui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;
import recipient.Mail;
import recipient.PrivateContact;
import recipient.User;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunTests {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/main/resources/chrome_110/chromedriver.exe").toAbsolutePath().toString());

        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
//        Actions action = new Actions(driver);
        File file = new File("src/main/resources/Autenti_File/autenti.pdf");
        //Instance of classess
        AddContact addContact = new AddContact(webDriverWait);
        AddNewCompanyRecipentToDocument addNewCompanyRecipentToDocument = new AddNewCompanyRecipentToDocument(webDriverWait);
        AddNewPrivateRecipentToDocument addNewPrivateRecipentToDocument = new AddNewPrivateRecipentToDocument(webDriverWait);
        AutentiLogIn autentiLogIn = new AutentiLogIn(webDriverWait);
        AutentiSignUp autentiSignUp = new AutentiSignUp(webDriverWait);
        ClickSubpages clickSubpages = new ClickSubpages(webDriverWait);
        CreateNewDocument createNewDocument = new CreateNewDocument(webDriverWait);
        EditContact editContact = new EditContact(webDriverWait);
        RemoveContact removeContact = new RemoveContact(webDriverWait);
        final String autentiPassword = System.getProperty("autentiPassword");
        SignCertificate signCertificate = new SignCertificate(webDriverWait);

        User user = new User("johndoe-do-testowania@op.pl", autentiPassword, "Jhon", "Doe", "500500500");
        User user1 = new User("Labadu-do-testowania@op.pl", autentiPassword, "Jhon", "Doe", "500500500");
        ContactCompany contactCompany = new ContactCompany("Mat", "Pat", new Mail("johndoe-do-testowania", "op.pl"), "504054392", "dev", "Amazon", "1000000000");
//        Mail mail = new Mail("crocodile", "gmail.com");
//        ContactCompany contactCompany1 = new ContactCompany("Rat", "Pat", mail, "504054392", "dev", "Amazon", "1000000000");
        ContactCompany contactCompanySameMail = new ContactCompany("Rat", "Pat", new Mail("johndoe-do-testowania", "@op.pl"), "504054392", "dev", "Amazon", "1000000000");

        final List<ContactCompany> listOfContactCompanies = IntStream.range(0, 100).mapToObj(i -> {
            Mail mail = new Mail("johndoe-do-testowania",i, "op.pl");
            ContactCompany contactCompany2 = new ContactCompany("Rat", "Pat", mail, "504054392", "dev", "Amazon", "1000000000");
            return contactCompany2;
        }).collect(Collectors.toList());

        PrivateContact privateContact = new PrivateContact("Riczi", "Pal", "JacobPal@gma.com", "816253468");
        PrivateContact privateContact1 = new PrivateContact("Carl","Longski","Icarli@gmail.com");

//        autentiLogIn.logIn(user,driver);
//        clickSubpages.clickContacts();
//        addContact.addCompanyContact(listOfContactCompanies);
//        removeContact.removeAllContacts();
//        clickSubpages.clickMyDocuments();
//        createNewDocument.CreateDoc(file,"RandomName");
//        addNewCompanyRecipentToDocument.clickNextRecipent();
//        addNewCompanyRecipentToDocument.addFromBookAdressByMail(contactCompany);
//        addNewCompanyRecipentToDocument.removeContactFromDocument();
//        addNewCompanyRecipentToDocument.addFromBookAdressByMail(contactCompany);
//        gui.AddNewCompanyRecipentToDocument.markAll(driver);
//        addNewCompanyRecipentToDocument.addWholeList(listOfContactCompanies);
//        addNewCompanyRecipentToDocument.clickAddRecipents();
//        addNewCompanyRecipentToDocument.remove99ContactsFromDocument(driver,action);
        ///#######  Send Doc
        autentiLogIn.logIn(user,driver);
//        clickSubpages.clickMyDocuments();
        createNewDocument.createDoc(file,"RandomName");
//        addNewCompanyRecipentToDocument.clickNextRecipent();
//        addNewCompanyRecipentToDocument.addFromBookAdressByMail(contactCompany);
//        addNewCompanyRecipentToDocument.addWholeList(listOfContactCompanies);
//        createNewDocument.sendDoc();
//        signCertificate.sign();
//        signCertificate.moveToDocs();

    }
}
