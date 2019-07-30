package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseFunctions;


public class HomePage extends BaseFunctions {

    private WebDriver driver;
    private String testUrl = "http://thedemosite.co.uk/login.php";
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
        this.driver = driver;
    }

    public void goToHomePage(){
        driver.get(testUrl);
    }

    public void getTabTitle(){
        tabTitle = driver.getTitle();
        System.out.println("Sekme başlığı: "+tabTitle);
        Assert.assertEquals(tabTitle,"Login example page to test the PHP MySQL online system");
    }

    public void getPageTitle(){
        pageTitle =  driver.findElement(By.xpath(pageTitle)).getText();
        System.out.println("Sayfa başlığı: "+ pageTitle);
        Assert.assertEquals(pageTitle,"4. Login");
    }

    public void getStatusMessage(){
        statusMessageTxt =  driver.findElement(By.xpath(statusMessage)).getText();
        System.out.println("Statü mesajı: "+ statusMessageTxt);
        Assert.assertEquals(statusMessageTxt,"**No login attempted**");

    }

    public void getStatusMessageColor(){
        statusMessageColorAttribute = driver.findElement(By.xpath(statusMessageColorAttribute)).getAttribute("color");
        System.out.println("Statü color değeri: "+ statusMessageColorAttribute);
        Assert.assertEquals(statusMessageColorAttribute,"#ff8000");
    }

    public void getPageInformationMessage(){
        pageInformationMessage =  driver.findElement(By.xpath(pageInformationMessage)).getText();
        System.out.println("Sayfa bilgi mesajı: "+ pageInformationMessage);
        Assert.assertEquals(pageInformationMessage,"Enter your login details you added on the previous page and test the login.\n" +
                "The success or failure will be shown above.");
    }

    public void getUsernameLabel(){
        usernameLabel =  driver.findElement(By.xpath(usernameLabel)).getText();
        System.out.println("Kullanıcı adı giriş alanı adı: "+ usernameLabel);
        Assert.assertEquals(usernameLabel,"Username:");
    }

    public void getPasswordLabel(){
        passwordLabel =  driver.findElement(By.xpath(passwordLabel)).getText();
        System.out.println("Şifre giriş alanı adı: "+ passwordLabel);
        Assert.assertEquals(passwordLabel,"Password:");
    }

    public void failedLogin(){
        driver.findElement(By.xpath(usernameInput)).sendKeys("testuser1");
        driver.findElement(By.xpath(passwordInput)).sendKeys("testpass1");
        driver.findElement(By.xpath(loginButton)).click();
        wait(1000);
        statusMessageTxt =  driver.findElement(By.xpath(statusMessage)).getText();
        Assert.assertEquals(statusMessageTxt,"**Failed Login**");
    }

    public void successfulLogin(){
        driver.findElement(By.xpath(usernameInput)).sendKeys("testuser");
        driver.findElement(By.xpath(passwordInput)).sendKeys("testpass");
        driver.findElement(By.xpath(loginButton)).click();
        wait(1000);
        statusMessageTxt =  driver.findElement(By.xpath(statusMessage)).getText();
        Assert.assertEquals(statusMessageTxt,"**Successful Login**");
    }
}