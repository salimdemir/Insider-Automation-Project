package tests;

import Page.CareersPage;
import Page.HomePage;
import base.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class CareersPageTest extends BaseTest {

    CareersPage careersPage;
    HomePage homePage;

    @Before
    public void before(){
        homePage = new HomePage(getWebDriver());
        careersPage = new CareersPage(getWebDriver());
    }

    @Test
    public void test() throws IOException {

        try {
            homePage.navbarClick();
            homePage.careerClick();
            careersPage.teamsClick();
            careersPage.qaButtonClick();
            careersPage.openAllJobs();
            Thread.sleep(10000);
            careersPage.selectJobLocationAndDepartment();
            Thread.sleep(5000);
            careersPage.verifyJob();
        } catch (Exception e){
            System.out.println("Test Failed");
            takeScreenshot();
        }

    }
}
