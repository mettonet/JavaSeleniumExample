package utils;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static String browserName = null;
    public static String testUrl = null;

    @BeforeEach
    public void setUpTest(){
        String projectPath = System.getProperty("user.dir");
        PropertiesFile.getProperties();

        //Chrome
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        //Firefox
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterEach
    public void tearDown() {
        //quit driver
        driver.quit();
    }

}
