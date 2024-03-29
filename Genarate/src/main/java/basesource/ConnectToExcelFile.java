package basesource;

import com.google.common.collect.Table;
import com.mysql.cj.result.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.poi.hssf.usermodel.HSSFCell.*;

public class ConnectToExcelFile {

    public static HSSFWorkbook wb = null;
    public static HSSFSheet sheet = null;
    public static Table.Cell cell = null;
    public static FileOutputStream fio = null;
    public static int numberOfRows, numberOfCol, rowNum;

    public String[][] fileReader1(String path,int sheetIndex) throws IOException {
        String[][] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(sheetIndex);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1][numberOfCol + 1];

        for (int i = 1; i < data.length; i++) {
            HSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                HSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i][j] = cellData;
            }
        }
        return data;
    }

    public String[] fileReader2(String path, int sheetIndex) throws IOException {
        String[] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(sheetIndex);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1];

        for (int i = 0; i < data.length; i++) {
            HSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                HSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i] = cellData;
            }
        }
        return data;
    }

    public static String getCellValue(HSSFCell cell) {
        Object value = null;

        CellType dataType = cell.getCellType();
        switch (dataType) {
            case BLANK:
                value = cell.getNumericCellValue();
                break;
            case BOOLEAN:
                value = cell.getStringCellValue();
                break;
            case FORMULA:
                value = cell.getBooleanCellValue();
                break;
            default:
        }
        return value.toString();

    }

//    public void writeBack(String value) throws IOException {
//        wb = new HSSFWorkbook();
//        sheet = wb.createSheet();
//        Row row = sheet.createRow(rowNum);
//        (row).setHeightInPoints(10);
//
//        fio = new FileOutputStream(new File("ExcelFile.xls"));
//        wb.write(fio);
//        for (int i = 0; i < row.getLastCellNum(); i++) {
//            row.createCell(i);
//            cell.setCellValue(value);
//        }
//        fio.close();
//        wb.close();
//    }
}
