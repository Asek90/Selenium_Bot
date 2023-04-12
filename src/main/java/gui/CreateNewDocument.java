package gui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class CreateNewDocument {
    WebDriverWait webDriverWait;
    public CreateNewDocument(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }
    public void createDoc(File file,String fileName) {

        WebElement createNewDocument = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("docs-create_new_document-button")));
        createNewDocument.click();

        WebElement uploadFile = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div/div[3]/div/input")));
          uploadFile.sendKeys(file.getAbsolutePath());

        WebElement typeFileName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[3]/div/div[1]/div/input")));
        typeFileName.sendKeys(fileName);
    }
        public void sendDoc(){
        WebElement send = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/div/button")));
        send.click();
    }
}
