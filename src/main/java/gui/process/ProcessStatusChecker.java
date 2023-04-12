package gui.process;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessStatusChecker {

    WebDriverWait webDriverWait;

    public ProcessStatusChecker(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void pending(){
        WebElement clickPending = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div[2]/ul/li[1]/button/span[1]/span[2]")));
        clickPending.click();
    }
    public void success(){
        WebElement clickSuccess = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div[2]/ul/li[2]/button/span[1]")));
        clickSuccess.click();
    }
    public void failure(){
        WebElement clickFailure = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div[2]/ul/li[3]/button/span[1]")));
        clickFailure.click();
    }
    public void extinct(){
        WebElement clickExtinct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div[2]/ul/li[4]/button/span[1]/span[2]")));
        clickExtinct.click();
    }
    public void withdrawn(){
        WebElement clickWithdrawn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div[2]/ul/li[5]/button/span[1]/span[2]")));
        clickWithdrawn.click();
    }
    public void error(){
        WebElement clickError = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/div[2]/div[2]/ul/li[6]/button/span[1]/span[2]")));
        clickError.click();
    }

    public void clickProcessFlow(){
        WebElement clickProcessFlow = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[3]/div/div[1]/div[2]/div/button[1]")));
        clickProcessFlow.click();
    }
    public String clickFirstParticipantsAndGetMail(){
        WebElement clickParticipants = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[4]/div/div[1]/div[2]/div/button[2]/span[1]")));
        clickParticipants.click();

        WebElement getMail = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[4]/div/div[3]/div/ul/li/ul/li/button/div[2]")));
        String userMail = getMail.getText();
        return userMail;
    }
    public String  clickFirstProcessDetailsAndGetId(){
        WebElement clickDetails = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[5]/div/div[1]/div[2]/div/button[3]")));
        clickDetails.click();

        WebElement checkId =webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[5]/div/div[4]/div/div/section/div/div[2]/div/p")));
        String docId = checkId.getText();
        return docId;
    }

    public void pickFirstDocument(){
        WebElement clickFirstDoc = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[5]/div/div[4]/div/div/section/div/div[2]/div/p")));
        clickFirstDoc.click();
    }

    public String getDocumentStatusAfterSignUp(){
        WebElement docStatus = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[3]/div[2]/div[1]")));
        String docStatusText = docStatus.getText();
        return docStatusText;
    }

    public String getDocumentStatusBeforeSignUp(){
        WebElement docStatus =webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[4]/div[4]/div[2]/div[1]")));
        String docStatusText = docStatus.getText();
        return docStatusText;
    }
}
