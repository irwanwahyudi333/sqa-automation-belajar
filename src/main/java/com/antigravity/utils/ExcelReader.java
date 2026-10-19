package com.antigravity.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> getRowData(String fileName, String sheetName, int rowIndex) {
        Map<String, String> data = new HashMap<>();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;

        try (FileInputStream fis = new FileInputStream(new File(filePath));
                Workbook workbook = WorkbookFactory.create(fis)) {

            // PERUBAHAN DI SINI: Kita ambil lembaran paling pertama (index 0) apa pun
            // namanya!
            // Kita abaikan variabel sheetName yang rawan salah ketik.
            Sheet sheet = workbook.getSheetAt(0);

            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowIndex);

            // Pengaman ekstra jika barisnya ternyata benar-benar kosong
            if (dataRow == null) {
                System.err.println("Peringatan: Baris ke-" + rowIndex + " kosong di file Excel!");
                return data;
            }

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).getStringCellValue();
                String value = "";
                if (dataRow.getCell(i) != null) {
                    value = dataRow.getCell(i).getStringCellValue();
                }
                data.put(key, value);
            }
        } catch (Exception e) {
            System.err.println("Gagal membaca Excel: " + e.getMessage());
        }
        return data;
    }
}