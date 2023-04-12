package gui.process;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessIdExtractor {

     public static String getId(WebDriver driver){
         String currentUrl = driver.getCurrentUrl();
         final Pattern pattern = Pattern.compile("=(.*)$");
         final Matcher matcher = pattern.matcher(currentUrl);
         String id = null;
         if (matcher.find()){
             id=matcher.group(1);
         }
         return id;
     }
}
