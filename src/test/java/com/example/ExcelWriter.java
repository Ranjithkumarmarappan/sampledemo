package com.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    private static int nextRowIndex = 0;
    private static String filePath = "C:\\Users\\manir\\Desktop\\Sample.xlsx";

    public static void appendDataToExcel() {
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            // Load the existing workbook
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Find the next available row index
            int lastRowIndex = sheet.getLastRowNum();

            // If there is existing data, increment the row index
            if (lastRowIndex >= nextRowIndex) {
                nextRowIndex = lastRowIndex + 2; // Add 2 for the cell space
            }

            // Create a new row
            Row row = sheet.createRow(nextRowIndex);

            // Write data to specific cells
            Cell cell1 = row.createCell(0);
            cell1.setCellValue("Opportunity");

            Cell cell2 = row.createCell(1);
            cell2.setCellValue("123456");

            // Increment the row index for the next iteration
            nextRowIndex++;

            // Save the changes to the workbook
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Close the workbook
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        appendDataToExcel(); // First iteration
        appendDataToExcel(); // Second iteration

        appendDataToExcel(); // Third iteration
    }
}
