package com.antigravity.base;

import com.antigravity.driver.DriverManager;
import com.antigravity.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonToAllPage {

    // Metode ini mengambil "kunci kontak" dari DriverManager
    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    // Jalan pintas untuk mengeklik sebuah elemen (tombol/link) di website
    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    // Jalan pintas untuk mengetik teks ke dalam kolom isian
    public void enterInput(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    // Jalan pintas untuk membaca teks yang ada di website
    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    // Jalan pintas untuk membuka URL website berdasarkan buku catatan
    // (data.properties)
    public void openUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }
}