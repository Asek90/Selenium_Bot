package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesHandler {
    WebDriverWait webDriverWait;

    public CookiesHandler(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }
    public void acceptCookies(){
        WebElement markCookies = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hs-eu-confirmation-button")));
        markCookies.click();
    }
}
