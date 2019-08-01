package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseFunctions extends BaseTest{


    public BaseFunctions(WebDriver driver) {
        super();
    }

    public void navigate(String url){
        driver.get(url);
    }

    public void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement find(By by){
        WebElement element = driver.findElement(by);
        return element;
    }



}
