package Page;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CareersPage extends BasePage {


    public CareersPage(WebDriver driver) {

        super(driver);
    }

    public void clickTeams() throws InterruptedException {


        WebElement cookiesElement = findElement(By.xpath("/html/body/div[2]/div[1]/div/span/div/div[2]/a[1]"));
        elementClickableWait(By.xpath("/html/body/div[2]/div[1]/div/span/div/div[2]/a[1]"));
        cookiesElement.click();
        Thread.sleep(2000);
        By locationsText = By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div/section/div/div/div/div[1]/h3");
        scroll(locationsText);
        Thread.sleep(2000);
        By seeTeams = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/section/div/div/a");
        click(seeTeams);
        Thread.sleep(5000);
    }

    public void qaButtonClick() throws InterruptedException {
        Thread.sleep(4);
        By positionsText = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/section/div/div/div[2]/div[12]/div[2]/a/h3");
        scroll(positionsText);
        findElement(By.xpath("//a[h3[text()='Quality Assurance']]")).click();
    }

    public void openAllJobs() {
        findElement(By.xpath("//a[text()='See all QA jobs']")).click();
    }

    private void selectJobLocation() {
        findElement(By.id("select2-filter-by-location-container")).click();
        findElement(By.xpath("//li[text()='Istanbul, Turkey']")).click();
    }

    private void selectJobDepartment() {
        findElement(By.id("select2-filter-by-department-container")).click();
        findElement(By.xpath("//li[text()='Quality Assurance']")).click();
    }

    public void selectJobLocationAndDepartment() {
        selectJobLocation();
        selectJobDepartment();
    }

    public void verifyJob() {
        WebElement jobTable = findElement(By.id("jobs-list"));
        List<WebElement> jobs = jobTable.findElements(By.xpath("./*"));

        Assert.assertFalse("Aranılan kriterde iş bulunmamaktadır.", jobs.isEmpty());
        for (WebElement job : jobs) {
            verifyJobDepartment(job, "Quality Assurance");
            verifyJobLocation(job, "Istanbul, Turkey");
            verifyJobDetailPage(job);
        }
    }

    private void verifyJobDetailPage(WebElement job) {
        moveToElement(job);
        WebElement viewRoleButton = job.findElement(By.xpath("//a[text()='View Role']"));
        viewRoleButton.click();
        switchToActiveTab();
        Assert.assertTrue(getPageUrl().startsWith("https://jobs.lever.co/useinsider/"));
        closeNewTab();
        switchToActiveTab();
    }

    private static void verifyJobLocation(WebElement job, String locationName) {
        WebElement location = job.findElement(By.className("position-location"));
        Assert.assertNotNull(location);
        Assert.assertEquals(locationName, location.getText());
    }

    private static void verifyJobDepartment(WebElement job, String departmentName) {
        WebElement department = job.findElement(By.className("position-department"));
        Assert.assertNotNull(department);
        Assert.assertEquals(departmentName, department.getText());

    }


}
