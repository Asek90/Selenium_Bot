package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import mail.LinkExtractor;
import recipient.User;

public class SignFromMail {

    WebDriverWait webDriverWait;
    WebDriver webDriver;

    public SignFromMail(WebDriverWait webDriverWait, WebDriver webDriver) {
        this.webDriverWait = webDriverWait;
        this.webDriver = webDriver;
    }

    LinkExtractor linkExtractor = new LinkExtractor();

    public void openLinkFromMailToSignDoc(){
        String link = linkExtractor.getLastDocLink();
        webDriver.get(link);
    }


    public void logInFromMail(User user){
        WebElement logIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div/a/button/span[1]")));
        logIn.click();

        WebElement typeMailAdress = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div[3]/form/div[3]/div/div")));
        typeMailAdress.clear();
        typeMailAdress.sendKeys(user.getMail());

        WebElement clickNextToLogIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div[3]/form/div[4]/button")));
        clickNextToLogIn.click();

        WebElement typePassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='accounts-login-password-input'")));
        typePassword.sendKeys(user.getPassword());

        WebElement clickConfirmPassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accounts-login-submit-button")));
        clickConfirmPassword.click();
    }

}
