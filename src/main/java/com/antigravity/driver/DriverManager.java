package com.antigravity.driver;

import com.antigravity.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverLocal.get();
    }

    public static void init() {
        if (driverLocal.get() == null) {
            String browser = PropertiesReader.readKey("browser");
            WebDriver driver;

            switch (browser.toLowerCase()) {
                case "firefox":
                    System.out.println("Membuka Mozilla Firefox (Mode Siluman/Headless)...");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless"); // <-- INI KODE RAHASIANYA
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    System.out.println("Membuka Microsoft Edge (Mode Siluman/Headless)...");
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                default:
                    System.out.println("Membuka Google Chrome (Mode Siluman/Headless)...");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }

            driver.manage().window().maximize();
            driverLocal.set(driver);
        }
    }

    public static void down() {
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
            driverLocal.remove();
        }
    }
}