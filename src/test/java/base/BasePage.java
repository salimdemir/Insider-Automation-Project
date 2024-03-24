package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }


    public void moveToElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }


    public void click(By by) {
        findElement(by).click();
    }



    public void scroll(By by) {

        WebElement element = driver.findElement(by);
        new Actions(driver)
                .scrollToElement(element)
                .perform();

    }

    public void elementClickableWait(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToActiveTab() {
        String jobDetailTab = findActiveTab();
        driver.switchTo().window(jobDetailTab);
    }

    private String findActiveTab() {
        List<String> tabs = findAllTabs();
        String jobDetailTab = tabs.get(tabs.size() - 1);
        return jobDetailTab;
    }


    private List<String> findAllTabs() {
        List<String> tabs = driver.getWindowHandles().stream().toList();
        return tabs;
    }

    public void closeNewTab() {
        driver.close();
    }


}

