package pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelUtils2 {

    public  XSSFWorkbook workbook;
    public  XSSFSheet sheet;
    public  int rowCount;
    FileOutputStream out;


    public ExcelUtils2(String excelPath, String sheetName) {
        try{
            workbook = new XSSFWorkbook(excelPath);
            sheet    = workbook.getSheet(sheetName);
            out = new FileOutputStream(excelPath);
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

    public void setCellData() throws Exception {
        sheet.getRow(0).createCell(2).setCellValue("pass");
        //sheet.getRow(2).createCell(2).setCellValue("pass");
        workbook.write(out);
        workbook.close();
    }

}
