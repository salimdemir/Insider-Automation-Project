package Page;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void clickNavbar(){

        Assert.assertTrue(getPageUrl().startsWith("https://useinsider.com/"));
        WebElement companySection = findElement(By.xpath("//a[contains(text(), 'Company')]"));
        companySection.click();
    }

    public void clickCareerButton(){
        elementClickableWait(By.xpath("//a[text()='Careers']"));
        findElement(By.xpath("//a[text()='Careers']")).click();
    }
}
