package tests;

import org.junit.jupiter.api.Test;
import pages.ExcelUtils;

public class ExcelDemo {

    @Test
    public void readExcel(){
        String path = System.getProperty("user.dir");
        ExcelUtils excelUtils = new ExcelUtils(path+"/rapor.xlsx","Sheet1");

        excelUtils.getRowCount();
        excelUtils.getCellDataString(1,0);
        excelUtils.getCellDataNumber(1,1);
    }
}
