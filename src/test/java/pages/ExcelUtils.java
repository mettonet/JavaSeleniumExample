package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static final String path = System.getProperty("user.dir");


    private static XSSFSheet excelWSheet;

    private static XSSFWorkbook excelWBook;

    private static XSSFCell cell;

    private static XSSFRow row;

    public static void setExcelFileSheet (String testDataExcel, String sheetName)  throws Exception{
        String testDataExcelPath = path+"\\";

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcel);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e){
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as row num and Col num
    public static String getCellData (int RowNum, int ColNum) throws Exception {
        try{
            DataFormatter formatter = new DataFormatter();
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            //String CellData = cell.getStringCellValue(); --AF: This is not working.
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }catch (Exception e){
            throw (e);
        }
    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as row num and Col num
    public static XSSFRow getRowData (int RowNum) throws Exception {
        try{
            DataFormatter formatter = new DataFormatter();
            row = excelWSheet.getRow(RowNum);
            return row;
        }catch (Exception e){
            throw (e);
        }
    }

    //This method is to write in the Excel cell, row num and Col num are the parameters
    public static void setCellData (String testDataExcel, String Result,  int RowNum, int ColNum) {
        String testDataExcelPath = path + "/"+testDataExcel;
        try{
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(Result);
            } else {
                cell.setCellValue(Result);
            }
            // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcel);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }catch(Exception e){
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

}
