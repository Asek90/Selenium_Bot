package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;

public class EditContact {
    static WebDriverWait webDriverWait;
    public EditContact(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }
    public void editContact(ContactCompany oldContact, ContactCompany newContact){

        WebElement searchMail = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-contacts-list/section/header/section[2]/app-search-box/div/input")));
        searchMail.sendKeys(oldContact.getMailAsString());

        WebElement clickEdit = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-contacts-list/section/section/ul/li/div[4]/span")));
        clickEdit.click();

        WebElement update = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-details-modal/div/footer/div/button[2]")));
        update.click();

        WebElement editSection = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-form-modal")));

        WebElement fillName = editSection.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[1]/div/div[1]/div/input")));
        fillName.clear();
        fillName.sendKeys(newContact.getName());

        WebElement fillLastName = editSection.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[2]/div/div[1]/div/input")));
        fillLastName.clear();
        fillLastName.sendKeys(newContact.getLastName());

        WebElement fillMail = editSection.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[3]/div/div[1]/div[1]/input")));
        fillMail.clear();
        fillMail.sendKeys(newContact.getMailAsString());

        WebElement fillPhone = editSection.findElement((By.xpath("div/section/form/section[2]/div/div/mat-form-field[2]/div/div[1]/div/input")));
        fillPhone.clear();
        fillPhone.sendKeys(newContact.getPhone());

        WebElement fillPosition = editSection.findElement((By.xpath("div/section/form/section[2]/div/mat-form-field[4]/div/div[1]/div/input")));
        fillPosition.clear();
        fillPosition.sendKeys(newContact.getPosition());

        WebElement fillCompanyName = editSection.findElement((By.xpath("div/section/form/section[3]/div/mat-form-field/div/div[1]/div/input")));
        fillCompanyName.clear();
        fillCompanyName.sendKeys(newContact.getCompanyName());

        WebElement fillNIP = editSection.findElement((By.xpath("div/section/form/section[3]/div/div[1]/mat-form-field[2]/div/div[1]/div/input")));
        fillNIP.clear();
        fillNIP.sendKeys(newContact.getNIP());

        WebElement clickSubmitAddContact = editSection.findElement((By.xpath("div/footer/button[2]")));
        clickSubmitAddContact.click();

    }
}
