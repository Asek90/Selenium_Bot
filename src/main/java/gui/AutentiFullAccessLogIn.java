package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.User;

public class AutentiFullAccessLogIn {
    static WebDriverWait webDriverWait;

    public AutentiFullAccessLogIn(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void logIn(User user, WebDriver driver) {
//        driver.get("https://processes.accept.autenti.net");
        driver.get("https://processes.accept.autenti.net/");
        WebElement acceptCookies = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hs-eu-confirmation-button")));
        acceptCookies.click();

        WebElement typeMailAdress = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accounts-login-email-input")));
        typeMailAdress.sendKeys(user.getMail());

        WebElement clickNextToLogIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accounts-login-submit-button")));
        clickNextToLogIn.click();

        WebElement typePassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='accounts-login-password-input'")));
        typePassword.sendKeys(user.getPassword());

        WebElement clickConfirmPassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accounts-login-submit-button")));
        clickConfirmPassword.click();

    }
}