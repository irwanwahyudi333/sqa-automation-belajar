package com.antigravity.tests;

import org.testng.annotations.Listeners;
import com.antigravity.utils.PropertiesReader;
import com.antigravity.base.CommonToAllTest;
import com.antigravity.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

// Tanda "extends CommonToAllTest" artinya tes ini mematuhi aturan buka-tutup browser otomatis
@Listeners(com.antigravity.listeners.ScreenshotListener.class)
public class LoginTest extends CommonToAllTest {

    // Tanda @Test memberi tahu program bahwa bagian di bawah ini adalah skenario
    // yang harus dijalankan
    @Test
    public void testLoginDenganPasswordSalah() {
        System.out.println("Langkah 1: Berada di Halaman Login");
        LoginPage loginPage = new LoginPage();

        System.out.println("Langkah 2: Membaca data dari buku catatan dan mencoba login...");
        // Kita tidak lagi mengetik email secara langsung, melainkan menyuruh asisten
        // membacanya
        String email = PropertiesReader.readKey("email_salah");
        String password = PropertiesReader.readKey("password_salah");
        String pesanErrorDiharapkan = PropertiesReader.readKey("pesan_error_diharapkan");

        String pesanErrorAktual = loginPage.loginToVWOInvalidCreds(email, password);

        System.out.println("Langkah 3: Memeriksa pesan error...");
        System.out.println("Pesan error dari website: " + pesanErrorAktual);

        // Membandingkan hasil dari website dengan teks yang ada di buku catatan
        Assert.assertEquals(pesanErrorAktual, pesanErrorDiharapkan);

        System.out.println("Hore! Tes dengan data eksternal berhasil!");
    }

    @Test
    public void testLoginDenganDataBenar() {
        System.out.println("=== Memulai Skenario 2: Login Data Benar ===");
        LoginPage loginPage = new LoginPage();

        // Simulasi menggunakan email dan password yang valid
        String emailBenar = "qa.sukses@gmail.com";
        String passwordBenar = "PasswordRahasia123!";

        System.out.println("Robot mencoba login dengan data yang benar...");

        // Catatan: Karena kita tidak punya akun asli di VWO, kita tetap memanggil
        // metode yang sama.
        // Di dunia nyata, Anda akan membuat metode loginToVWOValidCreds() yang langsung
        // mengecek apakah robot berhasil masuk ke halaman Dashboard.
        loginPage.loginToVWOInvalidCreds(emailBenar, passwordBenar);

        System.out.println("Kerangka tes login positif berhasil dijalankan!");
    }
}