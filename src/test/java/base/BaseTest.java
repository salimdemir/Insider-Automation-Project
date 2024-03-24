package base;


import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;

public class BaseTest {


    static WebDriver webDriver = null;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        getWebDriver().navigate().to("https://useinsider.com/");
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

    public void takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("test_fail.png"));
    }
}
