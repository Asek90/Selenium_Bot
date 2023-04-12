package gui.process;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.ContactCompany;

import java.io.File;

public class ProcessRunner {
    WebDriverWait webDriverWait;

    public ProcessRunner(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void startProcess() {
        WebElement clickStartProcess = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[1]/button")));
        clickStartProcess.click();
    }

    public void uploadFile(File file) {
        final WebElement input = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/section[1]/div[2]/div/section")));
        input.findElement(By.xpath("input")).sendKeys(file.getAbsolutePath());
    }

    public void addSignatoryParticipant(ContactCompany contactCompany) {

        WebElement clickAddParticipant = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/section[2]/div/ul/li[2]/div[1]/button/span[1]")));
        clickAddParticipant.click();

        WebElement fillName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        fillName.sendKeys(contactCompany.getName());

        WebElement fillLastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("surname")));
        fillLastName.sendKeys(contactCompany.getLastName());

        WebElement fillMail = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        fillMail.sendKeys(contactCompany.getMailAsString());

        WebElement fillPhone = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='phone']")));
        fillPhone.sendKeys(contactCompany.getPhone());

        WebElement clickConfirm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div/button")));
        clickConfirm.click();
    }

    public String confirmProcess (WebDriver webDriver){
        WebElement clickStartProcess = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[1]/div[3]/div/button")));
        clickStartProcess.click();
        String id = ProcessIdExtractor.getId(webDriver);
        return id;
    }

    public void sendSms(){
        WebElement clickSendSms = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[4]/button")));
        clickSendSms.click();
    }

}
