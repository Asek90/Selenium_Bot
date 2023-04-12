package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;



public class RemoveContact {
    static WebDriverWait webDriverWait;
    public RemoveContact(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }

    public void removeContactGiveMail(ContactCompany contactCompany) {

        WebElement searchMail = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-contacts-list/section/header/section[2]/app-search-box/div/input")));
        searchMail.sendKeys(contactCompany.getMailAsString());

        WebElement clickRemove = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-contacts-list/section/section/ul/li/div[4]/span")));
        clickRemove.click();

        WebElement clickDeleteButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-contact-details-modal/div/footer/div/button[1]")));
        clickDeleteButton.click();

        WebElement confirmRemove = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-delete-contact-modal/div/footer/button[2]")));
        confirmRemove.click();
    }
    public void removeAllContacts(){

        WebElement selectAll = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section/section[2]/app-contacts/section/div/app-contacts-list/section/section/div/div[1]/mat-checkbox")));
        selectAll.click();

        WebElement clickDeleteContacts = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-contacts-list/section/section/div/div[2]/div[2]/button")));
        clickDeleteContacts.click();

        WebElement findUl =webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[2]/section[2]/app-contacts/section/div/app-contacts-list/section/section/ul")));
        int li = findUl.findElements(By.tagName("li")).size();
        String myString = Integer.toString(li);

        WebElement typeNumberToDelete = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-delete-contact-modal/div/section/form/mat-form-field/div/div[1]/div/input")));
            typeNumberToDelete.sendKeys(myString);

        WebElement clickConfirm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-modal/div/div[2]/app-delete-contact-modal/div/footer/button[2]")));
        clickConfirm.click();
        }
    }
