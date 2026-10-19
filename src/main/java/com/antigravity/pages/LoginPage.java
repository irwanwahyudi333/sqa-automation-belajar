package com.antigravity.pages;

import com.antigravity.base.CommonToAllPage;
import com.antigravity.utils.WaitHelpers;
import org.openqa.selenium.By;

// Tanda "extends CommonToAllPage" artinya halaman ini meminjam jalan pintas (klik, ketik) yang kita buat tadi
public class LoginPage extends CommonToAllPage {

    // 1. MENCATAT ALAMAT ELEMEN (Locators)
    // Robot butuh "ID" atau "nama jalan" untuk menemukan kolom di layar website
    private By usernameLocator = By.id("login-username");
    private By passwordLocator = By.id("login-password");
    private By signButtonLocator = By.id("js-login-btn");
    private By errorMessageLocator = By.id("js-notification-box-msg");

    // 2. MEMBUAT AKSI (Action)
    // Ini adalah instruksi beruntun untuk mencoba login dengan password yang salah
    public String loginToVWOInvalidCreds(String user, String pwd) {

        // Buka website (memanggil jalan pintas dari CommonToAllPage)
        openUrl();

        // Ketik username dan password ke kolom yang tepat
        enterInput(usernameLocator, user);
        enterInput(passwordLocator, pwd);

        // Klik tombol login
        clickElement(signButtonLocator);

        // Panggil "Asisten Penunggu" agar robot bersabar menunggu pesan error muncul
        WaitHelpers.checkVisibility(getDriver(), errorMessageLocator);

        // Baca teks pesan error tersebut dan laporkan hasilnya
        return getText(errorMessageLocator);
    }
}