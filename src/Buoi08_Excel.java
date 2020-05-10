import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Buoi08_Excel {
    public static void main (String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");

        FileInputStream fis = new FileInputStream(projectPath + "/source/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Account");

        //Get num of sheets and getSheetName
        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("Total sheets: " + numOfSheets);

        for (int i=0; i<numOfSheets; i++){
            String sheetName = workbook.getSheetName(i);
            System.out.println(sheetName);
        }

        //Get num of rows
        int numOfRows = sheet.getLastRowNum() + 1;
        System.out.println("Total rows: " + numOfRows);

        //Get num of cols
        int numOfCols = sheet.getRow(0).getLastCellNum();
        System.out.println("Total cols: " + numOfCols);

        //Get value of A2
        String valueA2 = sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println(valueA2);

        //Get all values of sheet - dùng mảng 2 chiều
        for (int i=0; i<numOfRows; i++){
            for (int j=0; j<numOfCols; j++){
                String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                System.out.println(cellValue);
            }
        }

        //Get email & pass cols
        for(int i=0; i<numOfRows; i++){
            String emailValue = sheet.getRow(i).getCell(0).getStringCellValue();
            String passValue = sheet.getRow(i).getCell(1).getStringCellValue();

            System.out.println("Email: " + emailValue);
            System.out.println("Pass: " + passValue);
        }

        // Set cell C1
        //sheet.getRow(0).createCell(2).setCellValue("PASSED");

        // Set cell C2
        //sheet.getRow(1).createCell(2).setCellValue("FAILED");

        // Set cell C3
        //sheet.getRow(2).createCell(2).setCellValue("PENDING");

        // Set PASSED all rows
        for(int i=0; i<numOfRows; i++){
            sheet.getRow(i).createCell(2).setCellValue("PASSED");
        }

        //Set cell has existing value of C1
        //sheet.getRow(0).getCell(2).setCellValue("PASSED"); // dùng createCell cũng đc

        // Write excel
        FileOutputStream fos = new FileOutputStream(projectPath + "/source/output_data.xlsx");
        workbook.write(fos);
}
}
