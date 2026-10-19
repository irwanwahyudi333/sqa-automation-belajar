Feature: Fitur Login VWO

  Scenario Outline: Login dinamis membaca dari file Excel
    Given Saya berada di halaman login aplikasi VWO
    # Robot akan membaca parameter angka baris ini
    When Saya memasukkan data login dari Excel "DataLogin.xlsx" sheet "Sheet1" baris ke <baris_excel>
    Then Saya akan melihat pesan error sesuai Excel

    Examples:
      | baris_excel |
      | 1           |
      | 2           |
      | 3           |