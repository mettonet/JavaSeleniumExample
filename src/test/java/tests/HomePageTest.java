package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.Test;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {


    @Test
    public void HomePageTest(){
        HomePage homePage = new HomePage(driver);

        homePage.goToHomePage();
        homePage.getTabTitle();
        homePage.getPageTitle();
        homePage.getStatusMessage();
        homePage.getStatusMessageColor();
        homePage.getPageInformationMessage();
        homePage.getUsernameLabel();
        homePage.getPasswordLabel();
        homePage.failedLogin();
        homePage.successfulLogin();
    }


}
