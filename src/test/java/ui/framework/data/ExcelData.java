package ui.framework.data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ui.framework.util.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {
    private static ExcelData instance;
    private Workbook workbook;

    private ExcelData() {
        try {
            InputStream inputStream = new FileInputStream(Utils.getDataFile());
            workbook = new XSSFWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Iterator<Object[]> getDataFromSheet(String sheetName, boolean skipHeader) {
        synchronized (ExcelData.class) {
            if (instance == null) {
                instance = new ExcelData();
            }
        }
        List<Object[]> data = new ArrayList<>();
        Sheet sheet = instance.workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.rowIterator();
        if (skipHeader && rowIterator.hasNext()) {
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            List<Object> cellData = new ArrayList<>();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType()== CellType.STRING) {
                    cellData.add(cell.getStringCellValue());
                }
                if (cell.getCellType()== CellType.NUMERIC) {
                    cellData.add(cell.getNumericCellValue());
                }
                if (cell.getCellType()== CellType.BOOLEAN) {
                    cellData.add(cell.getBooleanCellValue());
                }

            }
            data.add(cellData.toArray());

        }
        return data.iterator();

    }
}
