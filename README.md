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
