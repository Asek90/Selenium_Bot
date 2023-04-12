package gui.process;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignDocumentViaProcess {
    WebDriverWait webDriverWait;

    public SignDocumentViaProcess(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void signDocument() {

        WebElement markCheckBox1 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div[2]/div[1]/div/label/div[1]")));
        markCheckBox1.click();

        WebElement markCheckBox2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div[2]/div[2]/div/label/div[1]")));
        markCheckBox2.click();

        WebElement clickSignButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accept\"]")));
        clickSignButton.click();
    }
//    public void smsHanlder(SmsCode smsCode){
//        WebElement clickSendSms = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[4]/button")));
//        clickSendSms.click();
//
//        WebElement typeCode = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[4]/div[1]/div/input")));
//        typeCode.sendKeys(smsCode);
//    }
}
