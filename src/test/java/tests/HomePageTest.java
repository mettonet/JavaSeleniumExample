package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ExcelUtils;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeEach
    public void setUp() throws Exception {
        homePage = new HomePage(driver);
        homePage.goToHomePage();
        ExcelUtils.setExcelFileSheet("rapor.xlsx", "Sheet1");
    }

    @Test
    @DisplayName("Sekme adının kontrol edilmesi")
    public void checkTabTitle(){
        homePage.getTabTitle();
        ExcelUtils.setCellData("rapor.xlsx","pass",1,1);
    }

    @Test
    @DisplayName("Sayfa adının kontrol edilmesi")
    public void checkPageTitle(){
        homePage.getPageTitle();
        ExcelUtils.setCellData("rapor.xlsx","pass",2,2);
    }

    @Test
    @DisplayName("Statü mesajının kontrol edilmesi")
    public void checkStatusMessage(){
        homePage.getStatusMessage();
        ExcelUtils.setCellData("rapor.xlsx","pass",3,2);
    }

    @Test
    @DisplayName("Statü mesajının renginin kontrol edilmesi")
    public void CheckStatusMessageColor(){
        homePage.getStatusMessageColor();
        ExcelUtils.setCellData("rapor.xlsx","pass",4,2);
    }

    @Test
    @DisplayName("Sayfa açıklaması kontrol edilmesi")
    public void checkPageInformationMessage(){
        homePage.getPageInformationMessage();
        ExcelUtils.setCellData("rapor.xlsx","pass",5,2);
    }

    @Test
    @DisplayName("Kullanıcı adı label kontrol edilmesi")
    public void checkUserNameLabel(){
        homePage.getUsernameLabel();
        ExcelUtils.setCellData("rapor.xlsx","pass",6,2);
    }

    @Test
    @DisplayName("Password label kontrol edilmesi")
    public void checkPasswordLabel(){
        homePage.getPasswordLabel();
        ExcelUtils.setCellData("rapor.xlsx","pass",7,2);
    }

    @Test
    @DisplayName("Failed login case")
    public void FailedLogin(){
        homePage.failedLogin();
        ExcelUtils.setCellData("rapor.xlsx","pass",8,2);
    }

    @Test
    @DisplayName("Successful login case")
    public void SuccessfulLogin(){
        homePage.successfulLogin();
    }

}
