package com.antigravity.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelpers {

    // Metode ini menyuruh robot menunggu maksimal 10 detik sampai elemen (seperti
    // tombol/teks) terlihat di layar
    public static void checkVisibility(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}