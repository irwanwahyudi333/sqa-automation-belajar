package com.antigravity.steps;

import com.antigravity.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Map;

import org.testng.Assert;

public class LoginSteps {

    // Kita panggil halaman login yang sudah Anda buat sebelumnya
    LoginPage loginPage;
    String pesanErrorAktual;

    // Variabel untuk menyimpan data Excel sementara
    Map<String, String> dataExcel;

    @When("Saya memasukkan data login dari Excel {string} sheet {string} baris ke {int}")
    public void saya_memasukkan_data_login_dari_excel(String fileName, String sheetName, Integer rowIndex) {
        // 1. Suruh asisten membaca file Excel di baris yang diminta
        dataExcel = com.antigravity.utils.ExcelReader.getRowData(fileName, sheetName, rowIndex);

        System.out.println("Langkah Cucumber 2: Login menggunakan email Excel: " + dataExcel.get("email"));

        // 2. Gunakan data tersebut untuk login
        pesanErrorAktual = loginPage.loginToVWOInvalidCreds(dataExcel.get("email"), dataExcel.get("password"));
    }

    @Then("Saya akan melihat pesan error sesuai Excel")
    public void saya_akan_melihat_pesan_error_sesuai_excel() {
        // 3. Bandingkan dengan pesan error yang tertulis di Excel
        String pesanErrorDiharapkan = dataExcel.get("pesan_error");
        Assert.assertEquals(pesanErrorAktual, pesanErrorDiharapkan);
    }

    // Perhatikan bahwa teks di dalam kurung HARUS SAMA PERSIS dengan di
    // login.feature
    @Given("Saya berada di halaman login aplikasi VWO")
    public void saya_berada_di_halaman_login() {
        loginPage = new LoginPage();
        System.out.println("Langkah Cucumber 1: Robot disiapkan di halaman login");
    }

    // Tanda {string} adalah keajaiban Cucumber untuk menangkap kata di dalam tanda
    // kutip ("")
    @When("Saya memasukkan email {string} dan password {string}")
    public void saya_memasukkan_email_dan_password(String email, String password) {
        System.out.println("Langkah Cucumber 2: Robot mencoba login dengan: " + email);

        // Kita lempar email dan password dari .feature ke metode login bawaan Anda
        pesanErrorAktual = loginPage.loginToVWOInvalidCreds(email, password);
    }

    @Then("Saya akan melihat pesan error {string}")
    public void saya_akan_melihat_pesan_error(String pesanErrorDiharapkan) {
        System.out.println("Langkah Cucumber 3: Memvalidasi kecocokan pesan error");

        // Membandingkan error dari website dengan error di cerita .feature
        Assert.assertEquals(pesanErrorAktual, pesanErrorDiharapkan);
    }
}