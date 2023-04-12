package testes;

import gui.AgreementComparer;
import gui.AutentiFullAccessLogIn;
import gui.SignFromMail;
import gui.process.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;
import recipient.Mail;
import recipient.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProcessTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/main/resources/chrome_110/chromedriver.exe").toAbsolutePath().toString());

        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        final String autentiPasswordMainAccount = System.getProperty("autentiPasswordMainAccount");
        final String autentiMail = System.getProperty("autentiMail");
        File file = new File("src/main/resources/Autenti_File/Umowa.pdf");
        Mail mail = new Mail("johndoe-do-testowania", "op.pl");
        ContactCompany contactCompany = new ContactCompany("Greg", "Ken", mail, "500500500", "", "", "");
        User user = new User(autentiMail, autentiPasswordMainAccount, "Jhon", "Doe", "500500500");
        AutentiFullAccessLogIn autentiFullAccessLogIn = new AutentiFullAccessLogIn(webDriverWait);
        ProcessRunner processTest = new ProcessRunner(webDriverWait);
        SignDocumentViaProcess signDocumentViaProcess = new SignDocumentViaProcess(webDriverWait);
        ProcessStatusChecker processStatusChecker = new ProcessStatusChecker(webDriverWait);
        ProcessIdExtractor processIdExtractor = new ProcessIdExtractor();
        SignFromMail signFromMail = new SignFromMail(webDriverWait, driver);
        ProcessAgreementHandler processAgreementHandler = new ProcessAgreementHandler(webDriverWait);

        //#Agreements
        File firstAgreementFile = new File("src/main/resources/Agreement_Files/First_Agreement");
        File secondAgreementFile = new File("src/main/resources/Agreement_Files/Second_Agreement");


        //#Login to Autentii
//       autentiFullAccessLogIn.logIn(user,driver);

        //#Go through process
//        processTest.startProcess();
//        processTest.uploadFile(file);
//        processTest.addSignatoryParticipant(contactCompany);

//          #Get ID from Url
//        String startedProcessId = processTest.confirmProcess(driver);
//        String pendingId = processStatusChecker.clickFirstProcessDetailsAndGetId();
//        Assertions.assertThatStartedProcessIdEqualsIdProcessList(startedProcessId,pendingId);

        //#Check Document Status
//        String documentStatusBeforeSignUp = processStatusChecker.getDocumentStatusBeforeSignUp();
//        String documentMail = processStatusChecker.clickFirstParticipantsAndGetMail();
//        Assertions.assertThatGivenMailIsEqualToDocumentMail(contactCompany.getMailAsString(),documentMail);
//           #Open mail and sign document
        signFromMail.openLinkFromMailToSignDoc();

        //#Check if agreements are the same
        String firstAgreementText = processAgreementHandler.getFirstAgreementText();
        String secondAgreementText = processAgreementHandler.getSecondAgreementText();
        Assertions.assertThatFirstAgreementBoxMatchText(firstAgreementText,AgreementComparer.getAgreementFromFile(firstAgreementFile));
        Assertions.assertThatSecondAgreementBoxMatchText(secondAgreementText,AgreementComparer.getAgreementFromFile(secondAgreementFile));

//        signDocumentViaProcess.signDocument();
//        processStatusChecker.pickFirstDocument();

        //#Back on the main page
//        autentiFullAccessLogIn.logIn(user,driver);
//        String completedProcessId = processStatusChecker.clickFirstProcessDetailsAndGetId();
//        Assertions.assertThatStartedProcessIdEqualsIdProcessList(startedProcessId,completedProcessId);
//         String documentStatusAfterSignUp = processStatusChecker.getDocumentStatusAfterSignUp();

//        Assertions.assertThatDocumentStatusChangeAfterSignUp(documentStatusBeforeSignUp,documentStatusAfterSignUp);
    }
}
