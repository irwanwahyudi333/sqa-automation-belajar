package com.antigravity.listeners;

import com.antigravity.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {

    // Metode ini HANYA akan dipanggil jika ada skenario tes yang GAGAL
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Ups! Tes Gagal! Sedang mengambil screenshot...");
        
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            // Perintah untuk memotret layar
            File tangkapanLayar = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            try {
                // Menyimpan file foto ke folder "error_screenshots" dengan nama skenario tesnya
                File tujuan = new File("error_screenshots/" + result.getName() + ".png");
                FileHandler.copy(tangkapanLayar, tujuan);
                System.out.println("Berhasil! Foto disimpan di: " + tujuan.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Gagal menyimpan file screenshot!");
            }
        }
    }
}