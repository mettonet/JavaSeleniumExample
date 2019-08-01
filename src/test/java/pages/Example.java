package pages;


import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseFunctions;

import java.io.FileInputStream;


public class Example extends BaseFunctions {



    public Example(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage(){
        navigate(testUrl);
    }





}
