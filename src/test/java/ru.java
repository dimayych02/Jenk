import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ru {
    public ChromeDriver driver;

    public void SettingDriver(){

       ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-useAutomationExtension");
        options.addArguments("--disable-blink-features=AutomationControlled");

        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");


        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();

        driver =  new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    public void OpenDriver(String google ){

       driver.get(google);

    }
    public void OpenMail(String XpathInput,String mailURL,String mailLink){                            // почта:taskmail123456@mail.ru
        WebElement element1 = driver.findElement(By.xpath(XpathInput));// пароль:vsemprivet@12345671245etedgvg
        element1.sendKeys(mailURL, Keys.ENTER);


        WebElement element2 = driver.findElement(By.xpath(mailLink));

        element2.click();
    }
    public void LogIn(String XpathLogin ,String Login ,String XpathPassword,String pass)  {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


        WebElement FieldLogin = driver.findElement(By.xpath(XpathLogin));
        FieldLogin.click();
        FieldLogin.sendKeys(Login,Keys.ENTER);

        WebElement FieldPass = driver.findElement(By.xpath(XpathPassword));
        FieldPass.sendKeys(pass,Keys.ENTER);

    }
    public void SendMessage(String Exception,String SendMessage,String emailToSend,
                            String email,String XpathField,String fieldToSend,String List){
        try{

            WebElement message = driver.findElement(By.xpath(SendMessage));
            message.click();



            WebElement EmailToSend = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(emailToSend)));

            EmailToSend.click();

            EmailToSend.sendKeys(email);

            WebElement FieldToSend = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(XpathField)));

            FieldToSend.click();
            FieldToSend.sendKeys(fieldToSend);



            WebElement Send = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(List)));

            Send.click();


        }

        catch(Exception e){

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

            WebElement close = driver.findElement(By.xpath(Exception));
            close.click();

            WebElement message = driver.findElement(By.xpath(SendMessage));
            message.click();


            WebElement EmailToSend = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(emailToSend)));

            EmailToSend.click();

            EmailToSend.sendKeys(email);

            WebElement FieldToSend = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(XpathField)));



            FieldToSend.click();
            FieldToSend.sendKeys(fieldToSend);





            WebElement Send = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(List)));

            Send.click();

        }

    }
}
