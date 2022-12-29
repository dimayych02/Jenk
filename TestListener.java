

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Base64;

import static PochtaPack.ru.driver;


public class TestListener  implements ITestListener {
    @Attachment(value="screen")
    public byte[]saveScreenshotOnFailure(byte[] screenBytes){
    return screenBytes;
    }

@Override
    public void onTestFailure(ITestResult result){
    String screenshotAsBase64= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
    saveScreenshotOnFailure(decoded);

    driver.close();
    driver.quit();
}

}
