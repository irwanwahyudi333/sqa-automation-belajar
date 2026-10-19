package com.antigravity.steps;

import com.antigravity.driver.DriverManager; // Sesuaikan jika nama kelas driver Anda berbeda
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    // Perintah ini akan dijalankan otomatis SEBELUM setiap skenario Cucumber
    // dimulai
    @Before
    public void setUp() {
        System.out.println("Cucumber Hook: Membuka browser...");
        // Panggil metode inisialisasi driver Anda di sini
        // Biasanya bernama init(), setUp(), atau startBrowser()
        DriverManager.init();
    }

    // Perintah ini akan dijalankan otomatis SETELAH setiap skenario selesai (lulus
    // atau gagal)
    @After
    public void tearDown() {
        System.out.println("Cucumber Hook: Menutup browser...");
        // Panggil metode penutup driver Anda di sini
        // Biasanya bernama down(), quit(), atau closeBrowser()
        DriverManager.down();
    }
}