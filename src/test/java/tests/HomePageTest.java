package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeEach
    public void setUp(){
        homePage = new HomePage(driver);
        homePage.goToHomePage();
    }

    @Test
    @DisplayName("Sekme adının kontrol edilmesi")
    public void checkTabTitle(){
        homePage.getTabTitle();
    }

    @Test
    @DisplayName("Sayfa adının kontrol edilmesi")
    public void checkPageTitle(){
        homePage.getPageTitle();
    }

    @Test
    @DisplayName("Statü mesajının kontrol edilmesi")
    public void checkStatusMessage(){
        homePage.getStatusMessage();
    }

    @Test
    @DisplayName("Statü mesajının renginin kontrol edilmesi")
    public void CheckStatusMessageColor(){
        homePage.getStatusMessageColor();
    }

    @Test
    @DisplayName("Sayfa açıklaması kontrol edilmesi")
    public void checkPageInformationMessage(){
        homePage.getPageInformationMessage();
    }

    @Test
    @DisplayName("Kullanıcı adı label kontrol edilmesi")
    public void checkUserNameLabel(){
        homePage.getUsernameLabel();
    }

    @Test
    @DisplayName("Password label kontrol edilmesi")
    public void checkPasswordLabel(){
        homePage.getPasswordLabel();
    }

    @Test
    @DisplayName("Failed login case")
    public void FailedLogin(){
        homePage.failedLogin();
    }

    @Test
    @DisplayName("Successful login case")
    public void SuccessfulLogin(){
        homePage.successfulLogin();
    }

}
