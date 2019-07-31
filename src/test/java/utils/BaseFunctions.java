package utils;

import org.openqa.selenium.WebDriver;

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

}
