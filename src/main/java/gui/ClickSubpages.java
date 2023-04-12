package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickSubpages {
    static WebDriverWait webDriverWait;
    public ClickSubpages(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }
    public void clickContacts(){
        WebElement clickContacts = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[4]/div/div/nav/ul/li[2]/a")));
        clickContacts.click();
    }
    public void clickMyDocuments(){
        WebElement clikDocuments = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[1]/app-side-menu/section/nav/ul/li[1]/a/mat-icon")));
        clikDocuments.click();
    }
    public void clickAutentiClassic(){
        WebElement clickAutentiClassic = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/nav/ul/li[3]/a")));
        clickAutentiClassic.click();
    }
    public void clickValidator(){
        WebElement clickValidator = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[1]/app-side-menu/section/nav/ul/li[4]/a/mat-icon")));
        clickValidator.click();
    }
    public void clickTemplate(){
        WebElement clickTemplate = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[1]/app-side-menu/section/nav/ul/li[5]/a/mat-icon")));
        clickTemplate.click();
    }
    public void brokerId(){
        WebElement brokerId = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-main-layout/section/section[1]/app-side-menu/section/nav/ul/li[6]/a/mat-icon/svg")));
        brokerId.click();
    }

}