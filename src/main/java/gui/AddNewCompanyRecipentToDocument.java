package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;
import java.util.List;
import java.util.stream.IntStream;

public class AddNewCompanyRecipentToDocument {
    WebDriverWait webDriverWait;

    public AddNewCompanyRecipentToDocument(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void addNextNewCompanyRecipent(ContactCompany contactCompany) {

        WebElement markRepresentativeCompany = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[1]/div/label[2]/span[1]")));
        markRepresentativeCompany.click();

        WebElement docRecipentForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div")));

        WebElement fillMail = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[2]/input"));
        fillMail.sendKeys(contactCompany.getMailAsString());

        WebElement fillNIP = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[3]/div[1]/input"));
        fillNIP.sendKeys(contactCompany.getNIP());

        WebElement fillCompanyName = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[3]/div[2]/input"));
        fillCompanyName.sendKeys(contactCompany.getCompanyName());

        WebElement fillName = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[4]/div[1]/input"));
        fillName.sendKeys(contactCompany.getName());

        WebElement fillLastName = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[4]/div[2]/input"));
        fillLastName.sendKeys(contactCompany.getLastName());

        WebElement fillPosition = docRecipentForm.findElement(By.xpath("div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[2]/div[4]/div[5]/input"));
        fillPosition.sendKeys(contactCompany.getPosition());
    }

    public void markForViews() {


        WebElement onlyForViews = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[3]/div[2]/label[2]")));
        onlyForViews.click();
    }

    public void signatureQualified() {
        WebElement clickSignatureQualified = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[4]/div[1]/div/div[3]/label[2]")));
        clickSignatureQualified.click();
    }

    public void authorizeSMS(ContactCompany contactCompany) {
        WebElement clickAuthorizeSMS = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[4]/div[2]/div[3]/div[2]/label/span[1]/span[1]")));
        clickAuthorizeSMS.click();

        WebElement fillPhone = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/form/div[1]/div[4]/div[2]/div[4]/input")));
        fillPhone.sendKeys(contactCompany.getPhone());
    }

    public void addFromBookAdressByMail(ContactCompany contactCompany) throws InterruptedException {
        WebElement clickChooseFromBookAdress = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[1]/ul/li[2]/span/span")));
        clickChooseFromBookAdress.click();

        WebElement typeMailtoAdd = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/div[1]/div/input")));
        typeMailtoAdd.sendKeys(contactCompany.getMailAsString());

        Thread.sleep(600);
        WebElement markCheckbox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[1]/label/div")));
        markCheckbox.click();

        //zakomentować przy uzywaniu fukncji addWholelist
        WebElement clickAddRecipents = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[3]/button[2]")));
        clickAddRecipents.click();
    }

    public void markForViewsAdressBook() {
        WebElement clickContact = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[2]")));
        clickContact.click();

        WebElement contactRoleforViews = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[3]/div[2]/label[2]/span[1]")));
        contactRoleforViews.click();
    }

    public void signatureQualifiedAdressBook() {
        WebElement clickSignatureQualified = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[3]/div[3]/div[2]/label[2]/span[1]")));
        clickSignatureQualified.click();
    }

    public void clickNextRecipent() {
        WebElement clickNextRecipent = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div/div[2]/button")));
        clickNextRecipent.click();
    }

    public void markAll(WebDriver driver) {
        WebElement clickChooseFromBookAdress = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[1]/ul/li[2]/span/span")));
        clickChooseFromBookAdress.click();

        List<WebElement> checkboxes = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='control_indicator']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement checkbox : checkboxes) {

            js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

            checkbox.click();
        }
    }

    public void addWholeList(List<ContactCompany> listOfContactCompanies) {
        listOfContactCompanies.forEach(company -> {
            try {
                addFromBookAdressByMail(company);
                //sprawdz czy widoczny jest markcheckbox
//                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[1]/label/div"))).isDisplayed();
                WebElement typeMailtoAdd = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/div[1]/div/input")));
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[3]/div[3]/div[1]")));
                typeMailtoAdd.clear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        WebElement clickAddRecipents = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[3]/button[2]")));
        clickAddRecipents.click();
    }

    public void clickAddRecipents() {
        WebElement clickAddRecipents = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/div/form/div[3]/button[2]")));
        clickAddRecipents.click();
    }

    public void removeContactFromDocument(int i,Actions actions) throws InterruptedException {

        WebElement hoover = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div/div[1]/div[5]")));
        actions.moveToElement(hoover).perform();
        Thread.sleep(400);
        WebElement clickDelete = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div/div[1]/div[5]/div[1]")));
        clickDelete.click();

        WebElement confirmDelete = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div/button[2]")));
        confirmDelete.click();
    }

    public void remove99ContactsFromDocument(WebDriver driver,Actions actions) throws InterruptedException {
        driver.get("https://create.autenti.com/b33706fe-cdb6-4684-99a2-ffb9e830b48e");
        IntStream.range(0, 99).forEach(i -> {
            try {
                removeContactFromDocument(i,actions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
