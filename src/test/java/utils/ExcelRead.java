package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;

public class ExcelRead {
    private static final String FILE_NAME = "D:/Testing/Amdocs Testing/amdocs/src/test/resources/files/SIMIMEI.xlsx";
    private static final String SHEET_NAME = "IMEI";
    private static final int COLUMN_INDEX = 2;

    public static ArrayList<String> getImei() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE_NAME);

        // Create a Workbook object to represent the Excel file.
        Workbook workbook = WorkbookFactory.create(inputStream);

        // Get the sheet by name.
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        // Loop through the rows and get the value in the specified column.
        ArrayList<String> imeiList = new ArrayList<String>();
        for (Row row : sheet) {
            Boolean valid=isValidSim(row);
            if (valid==true){
                Cell cell = row.getCell(COLUMN_INDEX);
                if (cell != null) {
                    System.out.println(cell.getStringCellValue());
                    imeiList.add(cell.getStringCellValue());
                }
            }
        }
        workbook.close();
        inputStream.close();
        return imeiList;
    }
    private static Boolean isValidSim(Row fila){
        String usado = fila.getCell(8).getStringCellValue();
        String fecha = fila.getCell(9).getStringCellValue();
        String nombre= fila.getCell(10).getStringCellValue();
        //si los tres atributos son null retornar true
        if (usado.equals("") && fecha.equals("") && nombre.equals("")){
            return true;
        }
        return false;
        

    }
}
