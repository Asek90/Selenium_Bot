package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.PrivateContact;

public class AddNewPrivateRecipentToDocument {

    static WebDriverWait webDriverWait;
    public AddNewPrivateRecipentToDocument(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }

    public static void addNextNewPrivateRecipent(PrivateContact privateContact) {
        WebElement clickNextRecipent = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div/div[2]/button")));
        clickNextRecipent.click();

        WebElement docRecipentForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div")));

        WebElement fillMail = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[2]/input"));
        fillMail.sendKeys(privateContact.getMail());

        WebElement fillFirstName = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[1]/input"));
        fillFirstName.sendKeys(privateContact.getName());

        WebElement fillLastName = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[2]/input"));
        fillLastName.sendKeys(privateContact.getLastName());
    }
    public static void addToAdressContact() {
        WebElement checkBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[3]/div/label/div")));
        checkBox.click();
    }
    public static void markForViews() {
        WebElement onlyForViews = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[3]/div[2]/label[2]")));
        onlyForViews.click();
    }
    public static void signatureQualified() {
        WebElement clickSignatureQualified = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[4]/div[1]/div/div[3]/label[2]")));
        clickSignatureQualified.click();
    }
    public static void authorizeSMS(PrivateContact privateContact) {
        WebElement clickAuthorizeSMS = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[4]/div[2]/div[3]/div[2]/label/span[1]/span[1]")));
        clickAuthorizeSMS.click();

        WebElement fillPhone = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[4]/div[2]/div[4]/input")));
        fillPhone.sendKeys(privateContact.getPhone());
    }
    public static void addFromBookAdressByMail(PrivateContact privateContact) {
        WebElement clickChooseFromBookAdress = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[1]/ul/li[2]/span/span")));
        clickChooseFromBookAdress.click();

        WebElement typeMailtoAdd = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/div[1]/div/input")));
        typeMailtoAdd.sendKeys(privateContact.getMail());
    }
    public static void markForViewsAdressBook() {
        WebElement clickContact = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[2]")));
        clickContact.click();

        WebElement contactRoleforViews = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[3]/div[2]/label[2]/span[1]")));
        contactRoleforViews.click();
    }
    public static void signatureQualifiedAdressBook() {
        WebElement clickSignatureQualified = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[3]/div[3]/div[2]/label[2]/span[1]")));
        clickSignatureQualified.click();
    }
}