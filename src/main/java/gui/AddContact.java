package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;
import recipient.PrivateContact;
import java.util.List;

public class AddContact {
    WebDriverWait webDriverWait;
    public AddContact(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }

   public void addCompanyContact(List<ContactCompany> contactCompanies) {

        final WebElement contactsSection = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section")));

        contactCompanies.forEach(company -> {
            try {
                addContact(company, contactsSection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

     public void addContact(ContactCompany contactCompany, WebElement contactsSection) {
        if (contactsSection.findElements(By.xpath("div/app-contacts-list")).isEmpty()) {
            WebElement addFirstContactButton =
                    contactsSection.findElement(By.xpath("div/app-empty-contacts-list/section/div/div/button"));
            addFirstContactButton.click();
            addFirstCompanyRecipent(contactCompany);
        } else {
            WebElement addNextContactButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/header/div/button[1]")));
            addNextContactButton.click();
            addCompanyRecipent(contactCompany);
        }
    }

    public void addFirstCompanyRecipent(ContactCompany contactCompany) {

        WebElement clickRepresentingCompany = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal/div/section/form/section[1]/mat-radio-group/mat-radio-button[1]/label")));
        clickRepresentingCompany.click();

        WebElement addContactForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal/div")));

        WebElement fillName = addContactForm.findElement(By.xpath("section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input"));
        fillName.sendKeys(contactCompany.getName());

        WebElement fillLastName = addContactForm.findElement(By.xpath("section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input"));
        fillLastName.sendKeys(contactCompany.getLastName());

        WebElement fillMail = addContactForm.findElement(By.xpath("section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input"));
        fillMail.sendKeys(contactCompany.getMailAsString());

        WebElement fillPhone = addContactForm.findElement(By.xpath("section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input"));
        fillPhone.sendKeys(contactCompany.getPhone());

        WebElement fillPosition = addContactForm.findElement(By.xpath("section/form/section[2]/div/mat-form-field[4]/div/div[1]/div/input"));
        fillPosition.sendKeys(contactCompany.getPosition());

        WebElement fillCompanyName = addContactForm.findElement(By.xpath("section/form/section[3]/div/mat-form-field/div/div[1]/div/input"));
        fillCompanyName.sendKeys(contactCompany.getCompanyName());

        WebElement fillNIP = addContactForm.findElement(By.xpath("section/form/section[3]/div/div[1]/mat-form-field[2]/div/div[1]/div/input"));
        fillNIP.sendKeys(contactCompany.getNIP());

        WebElement clickSubmitAddContact = addContactForm.findElement(By.xpath("footer/button[2]"));
        clickSubmitAddContact.click();
    }

    public void addCompanyRecipent(ContactCompany contactCompany) {

        WebElement addContactForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal")));

        WebElement fillName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal/div/section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input")));
        fillName.sendKeys(contactCompany.getName());

        WebElement fillLastName = addContactForm.findElement(By.xpath("div/section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input"));
        fillLastName.sendKeys(contactCompany.getLastName());

        WebElement fillMail = addContactForm.findElement(By.xpath("div/section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input"));
        fillMail.sendKeys(contactCompany.getMailAsString());

        WebElement fillPhone = addContactForm.findElement(By.xpath("div/section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input"));
        fillPhone.sendKeys(contactCompany.getPhone());

        WebElement fillPosition = addContactForm.findElement(By.xpath("div/section/form/section[2]/div/mat-form-field[4]/div/div[1]/div/input"));
        fillPosition.sendKeys(contactCompany.getPosition());

        WebElement fillCompanyName = addContactForm.findElement(By.xpath("div/section/form/section[3]/div/mat-form-field/div/div[1]/div/input"));
        fillCompanyName.sendKeys(contactCompany.getCompanyName());

        WebElement fillNIP = addContactForm.findElement(By.xpath("div/section/form/section[3]/div/div[1]/mat-form-field[2]/div/div[1]/div/input"));
        fillNIP.sendKeys(contactCompany.getNIP());

        WebElement clickSubmitAddContact = addContactForm.findElement(By.xpath("div/footer/button[2]"));
        clickSubmitAddContact.click();
    }

    public void addFirstCompanyContactWithfullAdress(ContactCompany contactCompany) {

        WebElement clickAddContact = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-empty-contacts-list/section/div/div/button")));
        clickAddContact.click();

        WebElement addContactForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal")));

        WebElement fillName = addContactForm.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input")));
        fillName.sendKeys(contactCompany.getName());

        WebElement fillLastName = addContactForm.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input")));
        fillLastName.sendKeys(contactCompany.getLastName());

        WebElement fillMail = addContactForm.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input")));
        fillMail.sendKeys(contactCompany.getMailAsString());

        WebElement fillPhone = addContactForm.findElement((By.xpath("div/section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input")));
        fillPhone.sendKeys(contactCompany.getPhone());

        WebElement fillPosition = addContactForm.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[4]/div/div[1]/div/input")));
        fillPosition.sendKeys(contactCompany.getPosition());

        WebElement fillCompanyName = addContactForm.findElement((By.xpath("div/section/form/section[3]/div/mat-form-field/div/div[1]/div/input")));
        fillCompanyName.sendKeys(contactCompany.getCompanyName());

        WebElement fillNIP = addContactForm.findElement((By.xpath("div/section/form/section[3]/div/div[1]/mat-form-field[2]/div/div[1]/div/input")));
        fillNIP.sendKeys(contactCompany.getNIP());

        WebElement clickAddCompanyAdress = addContactForm.findElement((By.xpath("div/section/form/section[3]/div/a/span")));
        clickAddCompanyAdress.click();

        WebElement fillCompanyAdress = addContactForm.findElement((By.xpath("div/section/form/section[3]/div/div[2]/mat-form-field[1]/div/div[1]/div/input")));
        fillCompanyAdress.sendKeys(contactCompany.getCompanyAdress());

        WebElement fillPostcode = addContactForm.findElement((By.xpath("div/section/form/section[3]/div/div[2]/mat-form-field[2]/div/div[1]/div/input")));
        fillPostcode.sendKeys(contactCompany.getPostcode());

        WebElement fillCity = addContactForm.findElement((By.xpath("div/section/form/section[3]/div/div[2]/mat-form-field[3]/div/div[1]/div/input")));
        fillCity.sendKeys(contactCompany.getCity());

        WebElement clickSubmitAddContact = addContactForm.findElement((By.xpath("div/footer/button[2]")));
        clickSubmitAddContact.click();
    }

    public void addCompanyContactWithfullAdress(ContactCompany contactCompany) {

        WebElement clickAddContact = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/header/div/button[1]")));
        clickAddContact.click();

        WebElement clickRepresentingCompany = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal/div/section/form/section[1]/mat-radio-group/mat-radio-button[1]/label")));
        clickRepresentingCompany.click();

        WebElement addContactForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal")));

        WebElement fillName = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input"));
        fillName.sendKeys(contactCompany.getName());

        WebElement fillLastName = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input"));
        fillLastName.sendKeys(contactCompany.getLastName());

        WebElement fillMail = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input"));
        fillMail.sendKeys(contactCompany.getMailAsString());

        WebElement fillPhone = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input"));
        fillPhone.sendKeys(contactCompany.getPhone());

        WebElement fillPosition = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[4]/div/div[1]/div/input"));
        fillPosition.sendKeys(contactCompany.getPosition());

        WebElement fillCompanyName = addContactForm.findElement(By.xpath("/div/section/form/section[3]/div/mat-form-field/div/div[1]/div/input"));
        fillCompanyName.sendKeys(contactCompany.getCompanyName());

        WebElement fillNIP = addContactForm.findElement(By.xpath("/div/section/form/section[3]/div/div[1]/mat-form-field[2]/div/div[1]/div/input"));
        fillNIP.sendKeys(contactCompany.getNIP());

        WebElement clickAddCompanyAdress = addContactForm.findElement(By.xpath("/div/section/form/section[3]/div/a/span"));
        clickAddCompanyAdress.click();

        WebElement fillCompanyAdress = addContactForm.findElement(By.xpath("/div/section/form/section[3]/div/div[2]/mat-form-field[1]/div/div[1]/div/input"));
        fillCompanyAdress.sendKeys(contactCompany.getCompanyAdress());

        WebElement fillPostcode = addContactForm.findElement(By.xpath("/div/section/form/section[3]/div/div[2]/mat-form-field[2]/div/div[1]/div/input"));
        fillPostcode.sendKeys(contactCompany.getPostcode());

        WebElement fillCity = addContactForm.findElement(By.xpath("/div/section/form/section[3]/div/div[2]/mat-form-field[3]/div/div[1]/div/input"));
        fillCity.sendKeys(contactCompany.getCity());

        WebElement clickSubmitAddContact = addContactForm.findElement(By.xpath("/div/footer/button[2]"));
        clickSubmitAddContact.click();
    }


    public void addFirstContactforPrivate(PrivateContact privateContact) {

        WebElement clickAddContact = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-empty-contacts-list/section/div/div/button")));
        clickAddContact.click();

        WebElement clickPrivatePerson = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal/div/section/form/section[1]/mat-radio-group/mat-radio-button[2]/label")));
        clickPrivatePerson.click();

        WebElement addContactForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal")));

        WebElement fillName = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input"));
        fillName.sendKeys(privateContact.getName());

        WebElement fillLastName = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input"));
        fillLastName.sendKeys(privateContact.getLastName());

        WebElement fillMail = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input"));
        fillMail.sendKeys(privateContact.getMail());

        WebElement fillPhone = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input"));
        fillPhone.sendKeys(privateContact.getPhone());

        WebElement clickSubmitAddContact = addContactForm.findElement(By.xpath("/div/footer/button[2]"));
        clickSubmitAddContact.click();
    }

    public void addContactforPrivate(PrivateContact privateContact) {

        WebElement clickAddContact = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/header/div/button[1]")));
        clickAddContact.click();

        WebElement clickPrivatePerson = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal/div/section/form/section[1]/mat-radio-group/mat-radio-button[2]/label")));
        clickPrivatePerson.click();

        WebElement addContactForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal")));

        WebElement fillName = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input"));
        fillName.sendKeys(privateContact.getName());

        WebElement fillLastName = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input"));
        fillLastName.sendKeys(privateContact.getLastName());

        WebElement fillMail = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input"));
        fillMail.sendKeys(privateContact.getMail());

        WebElement fillPhone = addContactForm.findElement(By.xpath("/div/section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input"));
        fillPhone.sendKeys(privateContact.getPhone());

        WebElement clickSubmitAddContact = addContactForm.findElement(By.xpath("/div/footer/button[2]"));
        clickSubmitAddContact.click();
    }
}
