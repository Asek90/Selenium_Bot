package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignCertificate {
    WebDriverWait webDriverWait;

    public SignCertificate(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }
    public void sign() {

        WebElement clickProceedToSigning = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[5]/div[4]/div[2]/div[1]/div[3]/div/div[1]/div/div/a")));
        clickProceedToSigning.click();

        WebElement markCheckBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[10]/div/div/div/label/span[1]/span[1]/input")));
        markCheckBox.click();

        WebElement clickProceedToSigning2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/button[2]/span[1]")));
        clickProceedToSigning2.click();


//        WebElement clickSign = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/button[2]")));
//        clickSign.click();
    }
        public void moveToDocs(){
        WebElement clickMoveToDocsButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/a/button")));
        clickMoveToDocsButton.click();
        }
    }

