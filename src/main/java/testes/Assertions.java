package testes;

import gui.process.ProcessStatusChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import recipient.Mail;

public class Assertions {

    public static void assertThatStartedProcessIdEqualsIdProcessList(String startedProcessId, String idOnProcessList) {
        if(!startedProcessId.equals(idOnProcessList)){
            throw new IllegalStateException("started process id doesn't equals id on process list : "
                    + startedProcessId + " and " + idOnProcessList);
        }
    }
    public static void assertThatGivenMailIsEqualToDocumentMail(String startedMail, String mailOnProcessList){
        if(!startedMail.equals(mailOnProcessList)){
            throw new IllegalStateException("started process mail doesn't equals mail on process list : "
                    + startedMail + " and " + mailOnProcessList);
        }
    }
    public static void assertThatDocumentStatusChangeAfterSignUp(String docStatusBeforeSignUp, String docStatusAfterSignUp){
        if(docStatusBeforeSignUp.equals(docStatusAfterSignUp)){
            throw new IllegalStateException("Status of Document didnt change after sign up :"
                    + docStatusBeforeSignUp + " and " + docStatusAfterSignUp);
        }
    }
    public static void assertThatFirstAgreementBoxMatchText(String agreementText, String text){
        if(!agreementText.equals(text)){
            throw new IllegalStateException("The agreement Text doesnt match text :"
                    + agreementText + " and " + text);
        }
    }
    public static void assertThatSecondAgreementBoxMatchText(String agreementText, String text){
        if(!agreementText.equals(text)){
            throw new IllegalStateException("The agreement Text doesnt match text :"
                    + agreementText + " and " + text);
        }
    }
}
