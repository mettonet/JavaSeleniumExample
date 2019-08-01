package pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseFunctions;


public class HomePage extends BaseFunctions {


    private String tabTitle  = null;
    private String pageTitle = "//p/big/strong";
    private String statusMessage = "//blockquote/font/center/b";
    private String statusMessageTxt;
    private String statusMessageColorAttribute = "//blockquote/font";
    private String pageInformationMessage = "//blockquote/p";
    private String usernameLabel = "//p/font/small[text()='Username:']";
    private String passwordLabel = "//p/font/small[text()='Password:']";
    private String usernameInput = "//p/input[@name='username']";
    private String passwordInput = "//p/input[@name='password']";
    private String loginButton   = "//p/input[@type='button' and @value='Test Login']";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage(){
        navigate(testUrl);
    }

    public void getTabTitle(){
        tabTitle = driver.getTitle();
        System.out.println("Sekme başlığı: "+tabTitle);
        Assertions.assertEquals(tabTitle,"Login example page to test the PHP MySQL online system");
    }

    public void getPageTitle(){
        pageTitle =  find(By.xpath(pageTitle)).getText();
        System.out.println("Sayfa başlığı: "+ pageTitle);
        Assertions.assertEquals(pageTitle,"4. Login");
    }

    public void getStatusMessage(){
        statusMessageTxt =  find(By.xpath(statusMessage)).getText();
        System.out.println("Statü mesajı: "+ statusMessageTxt);
        Assertions.assertEquals(statusMessageTxt,"**No login attempted**");

    }

    public void getStatusMessageColor(){
        statusMessageColorAttribute = find(By.xpath(statusMessageColorAttribute)).getAttribute("color");
        System.out.println("Statü color değeri: "+ statusMessageColorAttribute);
        Assertions.assertEquals(statusMessageColorAttribute,"#ff8000");
    }

    public void getPageInformationMessage(){
        pageInformationMessage =  find(By.xpath(pageInformationMessage)).getText();
        System.out.println("Sayfa bilgi mesajı: "+ pageInformationMessage);
        Assertions.assertEquals(pageInformationMessage,"Enter your login details you added on the previous page and test the login.\n" +
                "The success or failure will be shown above.");
    }

    public void getUsernameLabel(){
        usernameLabel =  find(By.xpath(usernameLabel)).getText();
        System.out.println("Kullanıcı adı giriş alanı adı: "+ usernameLabel);
        Assertions.assertEquals(usernameLabel,"Username:");
    }

    public void getPasswordLabel(){
        passwordLabel =  find(By.xpath(passwordLabel)).getText();
        System.out.println("Şifre giriş alanı adı: "+ passwordLabel);
        Assertions.assertEquals(passwordLabel,"Password:");
    }

    public void failedLogin(){
        find(By.xpath(usernameInput)).sendKeys("testuser1");
        find(By.xpath(passwordInput)).sendKeys("testpass1");
        find(By.xpath(loginButton)).click();
        wait(1000);
        statusMessageTxt =  find(By.xpath(statusMessage)).getText();
        Assertions.assertEquals(statusMessageTxt,"**Failed Login**");
    }

    public void successfulLogin(){
        find(By.xpath(usernameInput)).sendKeys("testuser");
        find(By.xpath(passwordInput)).sendKeys("testpass");
        find(By.xpath(loginButton)).click();
        wait(1000);
        statusMessageTxt =  find(By.xpath(statusMessage)).getText();
        Assertions.assertEquals(statusMessageTxt,"**Successful Login**");
    }
}
