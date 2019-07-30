package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

public class BaseTest {

    public WebDriver driver;
    public static String browserName = null;

    @Before
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







    @After
    public void tearDown() {
        //quit driver
        driver.quit();
    }

}
