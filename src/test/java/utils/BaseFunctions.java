package utils;

import org.openqa.selenium.WebDriver;

public class BaseFunctions extends BaseTest{


    public void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
