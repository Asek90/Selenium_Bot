package gui.process;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ProcessAgreementHandler {
    WebDriverWait webDriverWait;

    public ProcessAgreementHandler(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public String getFirstAgreementText(){
        WebElement getFirstBoxText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div[2]/div[1]/div/label/div[2]/span[2]")));
        String firstAgreement = getFirstBoxText.getText();
        Charset iso88591 = Charset.forName("ISO-8859-1");
        Charset utf8 = StandardCharsets.UTF_8;
        byte[] isoBytes = firstAgreement.getBytes(iso88591);
        String firstAgreement1 = new String(isoBytes, utf8);
        return firstAgreement;
    }

    public String getSecondAgreementText(){
        WebElement getSecondBoxText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div[2]/div[2]/div/label/div[2]/span[2]")));
        String secondAgreement = getSecondBoxText.getText();
        return secondAgreement;
    }
}
