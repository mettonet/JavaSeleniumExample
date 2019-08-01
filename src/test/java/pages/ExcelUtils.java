package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public  XSSFWorkbook workbook;
    public  XSSFSheet sheet;
    public  int rowCount;


    public ExcelUtils(String excelPath, String sheetName) {
        try{
            workbook = new XSSFWorkbook(excelPath);
            sheet    = workbook.getSheet(sheetName);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public  void getRowCount(){
            rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
            System.out.println(rowCount);
    }

    public  void getCellDataString(int rowNum, int colNum){
            String cellDataString = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println(cellDataString);
    }

    public  void getCellDataNumber(int rowNum, int colNum){
            double cellDataNumber = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellDataNumber);
    }

}
