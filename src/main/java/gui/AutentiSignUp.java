package gui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recipient.User;

public class AutentiSignUp {

    static WebDriverWait webDriverWait;
    public AutentiSignUp(WebDriverWait webDriverWait) {
        this.webDriverWait=webDriverWait;
    }
    public void register(User user, WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://autenti.com/pl/");

        WebElement acceptCookies = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hs-eu-confirmation-button")));
        acceptCookies.click();

        WebElement SignIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("au-primary-cta")));
        SignIn.click();

        WebElement AccountType = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid=register_form-select_private_account_type_checkbox]")));
        AccountType.click();

        WebElement eMail = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='register_form-private_user_email_input']")));
        eMail.sendKeys(user.getMail());

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='register_form-private_user_password_input']")));
        password.sendKeys(user.getPassword());

        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='register_form-private_user_name_input']")));
        firstName.sendKeys(user.getFirstName());

        WebElement secondName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='register_form-private_user_surname_input']")));
        secondName.sendKeys(user.getSecondName());

        WebElement telephoneNumber = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='register_form-private_user_phone_number_input']")));
        telephoneNumber.sendKeys(user.getPhone());

        js.executeScript("document.querySelector('.MuiButton-label').scrollIntoView()", "");

        WebElement sendButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiButton-label")));
        sendButton.click();
    }
}

