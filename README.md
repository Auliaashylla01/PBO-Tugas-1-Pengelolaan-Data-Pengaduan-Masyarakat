# Sistem Pengelolaan Pengaduan Masyarakat

**Oleh:** Aulia Ashylla Ananda Putri Hariawan  
**NIM:** 2509116076  
**Mata Kuliah:** Pemrograman Berbasis Objek (PBO)

---

## 1. Deskripsi Singkat Program

Sistem Pengelolaan Pengaduan Masyarakat merupakan program berbasis Java yang digunakan untuk mencatat dan mengelola data pengaduan yang disampaikan oleh masyarakat. Program ini dapat digunakan untuk menangani berbagai laporan, seperti kerusakan fasilitas umum, masalah kebersihan, keamanan, jalan, maupun pelayanan. 

Setiap data pengaduan memuat informasi penting seperti **ID Pengaduan**, **Nama Pelapor**, **Jenis Pengaduan**, **Isi Pengaduan**, **Tanggal Pengaduan**, dan **Status Pengaduan**. ID pengaduan dibuat secara otomatis oleh sistem, sedangkan jenis pengaduan dipilih melalui kategori yang telah disediakan agar data yang tersimpan tetap konsisten. Pengguna dapat mengelola data melalui menu interaktif (CRUD) berbasis CLI (*Command Line Interface*). Program dibangun menerapkan konsep *Object-Oriented Programming* (OOP) serta memanfaatkan `ArrayList` sebagai media penyimpanan data dinamis secara *in-memory*.

---

## 2. Tujuan Program

Program ini dibuat untuk menerapkan konsep dasar Pemrograman Berorientasi Objek (PBO) melalui sistem CRUD sederhana.

Tujuan utama dari program ini adalah:
* Mencatat data pengaduan masyarakat secara terstruktur dan otomatis.
* Menampilkan seluruh data pengaduan yang telah tersimpan.
* Mengubah status pengaduan sesuai dengan progres penanganannya di lapangan.
* Menghapus data pengaduan dari sistem jika sudah tidak diperlukan.

---

## 3. Struktur & Hierarki Class

Berikut adalah pembagian peran kelas dalam proyek ini:

| Class | Peran & Deskripsi |
| --- | --- |
| `Pengguna` *(Superclass)* | Parent class yang menyimpan atribut dasar pengguna seperti `idPengguna` dan `nama`. |
| `Masyarakat` *(Subclass)* | Subclass dari `Pengguna` yang merepresentasikan data pelapor, dilengkapi atribut `nik` dan `alamat`. |
| `Petugas` *(Subclass)* | Subclass dari `Pengguna` yang merepresentasikan data petugas/admin, dilengkapi atribut `nip` dan `jabatan`. |
| `Pengaduan` | Class entitas yang merepresentasikan satu laporan pengaduan (termasuk objek `Masyarakat` di dalamnya). |
| `PengelolaDataPengaduan` | Class yang bertugas mengelola kumpulan objek `Pengaduan` menggunakan `ArrayList` serta menyediakan method operasi CRUD. |
| `PengelolaPengaduanMasyarakatMatkulPbo` | Class *entry point* (Main) yang menjalankan antarmuka menu CLI dan menangani alur interaksi pengguna. |

### Struktur Directory Project
```text
src/
├── main/
│   ├── PengelolaDataPengaduan.java
│   └── PengelolaPengaduanMasyarakatMatkulPbo.java
└── model/
    ├── Pengguna.java
    ├── Masyarakat.java
    ├── Petugas.java
    └── Pengaduan.java
```
---                                                     

## 4. Konsep OOP & Penerapan Kode

### A. Inheritance (Pewarisan)
Penerapan *Inheritance* ditunjukkan pada kelas `Masyarakat` dan `Petugas` yang mewarisi (*extends*) atribut serta method dari superclass `Pengguna`. Pemanggilan fungsi `super()` digunakan untuk menginisialisasi nilai pada constructor parent class.                            

<img width="487" height="118" alt="image" src="https://github.com/user-attachments/assets/109c768f-954a-41ad-9fc9-4c591ccc9fb5" />   

*Gambar 1: Penerapan kata kunci `extends` dan `super()` pada class `Masyarakat` yang mewarisi class `Pengguna`.*

---

### B. Access Modifier & Encapsulation
* **Access Modifier**: Seluruh atribut pada kelas model menggunakan access modifier `private` atau `protected` untuk menyembunyikan data secara langsung dari luar kelas.
* **Encapsulation**: Pembacaan data dilakukan melalui method *getter*, dan perubahan data dilakukan melalui *setter*. Atribut `idPengaduan` sengaja tidak diberi *setter* agar nilainya tetap konsisten sebagai ID unik yang di-generate otomatis oleh sistem.

<img width="235" height="94" alt="image" src="https://github.com/user-attachments/assets/ab45131c-256a-4f2c-9c9e-f99831e5363e" />                                                

<img width="247" height="278" alt="image" src="https://github.com/user-attachments/assets/98739dd0-696d-4e56-97e0-b88fc6011937" />                                            

*Gambar 2: Deklarasi atribut berakses `private` serta penerapan method *getter* & *setter* pada class `Pengaduan`.*

---

## 5. Implementasi & Tampilan Program (Running Program)

Berikut adalah dokumentasi hasil jalannya program (*running program*) untuk setiap fitur CRUD yang tersedia:

### 1. Tampilan Utama (Header & Menu)
Saat program pertama kali dijalankan, sistem akan menampilkan header data petugas yang sedang bertugas beserta 5 menu navigasi utama.

![Gambar 3: Tampilan menu utama dan informasi petugas](assets/gambar-3.png)
*Gambar 3: Tampilan menu utama dan informasi petugas saat aplikasi dijalankan.*

---

### 2. Tambah Pengaduan (Create)
Menu 1 digunakan untuk memasukkan laporan baru. Sistem secara otomatis membuatkan **ID Pengaduan** unik (misal: `P001`), kemudian pengguna mengisikan data pelapor (Nama, NIK, Alamat), memilih kategori pengaduan (1–5), mengisikan deskripsi laporan, serta tanggal. Status awal laporan secara otomatis diset menjadi `"Pengaduan Kamu sedang Menunggu Konfirmasi..."`.

![Gambar 4: Proses menginputkan data pengaduan baru](assets/gambar-4.png)
*Gambar 4: Proses menginputkan data pengaduan baru ke dalam sistem.*

---

### 3. Lihat Pengaduan (Read)
Menu 2 digunakan untuk menampilkan seluruh daftar pengaduan yang telah tersimpan di dalam memori (`ArrayList`). Setiap laporan menampilkan detail ID, data pelapor (NIK, Nama, Alamat), jenis, isi, tanggal, dan status terkini.

![Gambar 5: Tampilan daftar seluruh laporan pengaduan](assets/gambar-5.png)
*Gambar 5: Tampilan daftar seluruh laporan pengaduan yang tersimpan.*

---

### 4. Ubah Status Pengaduan (Update)
Menu 3 digunakan untuk memperbarui status penanganan laporan berdasarkan ID Pengaduan. Pengguna dapat memilih status baru:
1. Menunggu
2. Diproses
3. Selesai

![Gambar 6: Proses pencarian ID laporan dan pembaruan status](assets/gambar-6.png)
*Gambar 6: Proses pencarian ID laporan dan pembaruan status pengaduan.*

---

### 5. Hapus Pengaduan (Delete)
Menu 4 digunakan untuk menghapus data pengaduan tertentu. Sebelum menghapus, sistem akan menampilkan data laporan yang ditemukan dan meminta konfirmasi (`y/n`) dari pengguna agar data tidak terhapus secara tidak sengaja.

![Gambar 7: Proses konfirmasi dan penghapusan data](assets/gambar-7.png)
*Gambar 7: Proses konfirmasi dan penghapusan data pengaduan dari sistem.*
