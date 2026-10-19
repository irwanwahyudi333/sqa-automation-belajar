package com.antigravity.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // Metode ini tugasnya mencarikan jawaban dari buku catatan kita
    public static String readKey(String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/data.properties")) {
            // Ini adalah alamat tempat kita menyimpan "buku catatan" tadi
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Ups! Gagal membaca file data.properties");
        }

        // Mengembalikan nilai berdasarkan kata kunci yang dicari (misal: "browser" ->
        // "firefox")
        return properties.getProperty(key);
    }
}