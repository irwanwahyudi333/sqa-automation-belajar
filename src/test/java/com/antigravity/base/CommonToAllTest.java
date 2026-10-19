package com.antigravity.base;

import com.antigravity.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    // Tanda @BeforeMethod artinya: "Lakukan ini SEBELUM setiap tes dimulai"
    @BeforeMethod
    public void setUp() {
        System.out.println("Memulai tes, membuka browser...");
        DriverManager.init(); // Memanggil kunci kontak untuk menyalakan browser
    }

    // Tanda @AfterMethod artinya: "Lakukan ini SETELAH setiap tes selesai"
    @AfterMethod
    public void tearDown() {
        System.out.println("Tes selesai, menutup browser...");
        DriverManager.down(); // Mematikan mesin browser
    }
}