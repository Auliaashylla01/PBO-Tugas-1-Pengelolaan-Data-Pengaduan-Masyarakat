/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import java.util.Scanner;
import model.Pengaduan;
import model.Masyarakat;
import model.Petugas;
/**
 *
 * @author ASUS
 */
public class PengelolaPengaduanMasyarakatMatkulPbo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        PengelolaDataPengaduan pengelola = new PengelolaDataPengaduan();
        int menu;
        
        Petugas petugas = new Petugas("PET-001", "Budi Santoso", "198501012010011001", "Admin Layanan");
        
        do {
            tampilkanHeader(petugas);
            tampilkanMenu();
            
            menu = inputAngka (scanner, "Pilih Menu (1-5): ");
            
            switch (menu){
                case 1 -> tambahPengaduan(scanner, pengelola);
                case 2 -> pengelola.lihatPengaduan();
                case 3 -> ubahStatus (scanner, pengelola);
                case 4 -> hapusPengaduan (scanner, pengelola);
                case 5 -> System.out.println("\nTerima kasih telah menggunakan Sistem Pengelolaan Pengaduan Masyarakat.");
                default -> System.out.println("\n[Error] Menu tidak tersedia. Silakan pilih menu 1-5!");  
        }
            if (menu != 5){
                System.out.println("\n Teken [ENTER] untuk kembali ke menu..");
                scanner.nextLine();
            }
            
        } while (menu != 5);
        scanner.close();  
    }
    public static void tampilkanHeader(Petugas petugas){
        System.out.println("\n==================================================");
        System.out.println("      SISTEM PENGELOLAAN PENGADUAN MASYARAKAT");
        System.out.println("==================================================");
        petugas.tampilkanInfoPetugas();
        System.out.println("==================================================");
    }
    public static void tampilkanMenu(){
        System.out.println("1. Tambah Pengaduan");
        System.out.println("2. Lihat Pengaduan");
        System.out.println("3. Ubah Status Pengaduan");
        System.out.println("4. Hapus Pengaduan");
        System.out.println("5. Keluar");
    }
    public static void tambahPengaduan(Scanner scanner, PengelolaDataPengaduan pengelola){
        System.out.println("\n==================================================");
        System.out.println("               TAMBAH PENGADUAN");
        System.out.println("==================================================");
        
        String id = pengelola.generateId();
        System.out.println("ID Pengaduan: " + id);
        
        String nama = inputTeks(scanner, "Masukkan Nama Pelapor    : ");
        String nik = inputTeks(scanner, "Masukkan NIK Pelapor     : ");
        String alamat = inputTeks(scanner, "Masukkan Alamat Pelapor  : ");
        
        Masyarakat Pengguna = new Masyarakat("USR-" + id, nama, nik, alamat);
        
        System.out.println("\nJenis Pengaduan:");
        System.out.println("1. Fasilitas Umum");
        System.out.println("2. Kebersihan");
        System.out.println("3. Keamanan");
        System.out.println("4. Jalan");
        System.out.println("5. Pelayanan");
        
        String jenis = "";
        while (true) {
            System.out.print("Pilih Jenis Pengaduan (1-5): ");
            String pilihanJenis = scanner.nextLine().trim();

            switch (pilihanJenis) {
                case "1" -> jenis = "Fasilitas Umum";
                case "2" -> jenis = "Kebersihan";
                case "3" -> jenis = "Keamanan";
                case "4" -> jenis = "Jalan";
                case "5" -> jenis = "Pelayanan";
                default -> {
                    System.out.println("[Error] Pilihan jenis pengaduan tidak tersedia.");
                    continue;
                }
            }
            break;
            }

        String isi = inputTeks(scanner, "Masukkan Isi Pengaduan   : ");
        String tanggal = inputTeks(scanner, "Masukkan Tanggal(dd/mm/yyyy) : ");

        Pengaduan pengaduan = new Pengaduan(id, Pengguna, jenis, isi, tanggal);
        pengelola.tambahPengaduan(pengaduan);
        System.out.println("\n[Sukses] Pengaduan berhasil ditambahkan ke dalam sistem!");
    }
    public static void ubahStatus(Scanner scanner, PengelolaDataPengaduan pengelola) {
        System.out.println("\n==================================================");
        System.out.println("               UBAH STATUS PENGADUAN");
        System.out.println("==================================================");

        String id = inputTeks(scanner, "Masukkan ID Pengaduan : ");
        Pengaduan pengaduan = pengelola.cariPengaduan(id);

        if (pengaduan == null) {
            System.out.println("\n[Error] ID Pengaduan tidak ditemukan!");
            return;
        }
        System.out.println("\n[Informasi Data]");
        System.out.println("Pelapor         : " + pengaduan.getPengguna().getnama());
        System.out.println("Jenis Pengaduan : " + pengaduan.getjenisPengaduan());
        System.out.println("Status saat ini : " + pengaduan.getstatus());

        System.out.println("\nPilih Status Baru:");
        System.out.println("1. Menunggu");
        System.out.println("2. Diproses");
        System.out.println("3. Selesai");

        int pilihanStatus = inputAngka(scanner, "Pilih Status Baru (1-3): ");
        String statusBaru = switch (pilihanStatus) {
            case 1 -> "Pengaduan Kamu sedang Menunggu Konfirmasi...";
            case 2 -> "Pengaduan Kamu sedang Diproses...";
            case 3 -> "Pengaduan Kamu telah Selesai Ditindaklanjuti";
            default -> "Pengaduan Kamu sedang Menunggu Konfirmasi...";
        };

        pengelola.ubahStatus(id, statusBaru);
        System.out.println("\n[Sukses] Status pengaduan berhasil diperbarui!");
    }

    public static void hapusPengaduan(Scanner scanner, PengelolaDataPengaduan pengelola) {
        System.out.println("\n==================================================");
        System.out.println("               HAPUS PENGADUAN");
        System.out.println("==================================================");

        String id = inputTeks(scanner, "Masukkan ID Pengaduan : ");
        Pengaduan pengaduan = pengelola.cariPengaduan(id);

        if (pengaduan == null) {
            System.out.println("\n[Error] ID Pengaduan tidak ditemukan!");
            return;
        }
        System.out.println("\n ID Pengaduan ditemukan:");
        System.out.println("ID Pengaduan: "+ pengaduan.getidPengaduan());
        System.out.println("Pelapor: " + pengaduan.getPengguna().getnama());
        System.out.println("Status: " + pengaduan.getstatus());
        
        System.out.print("\nApakah Kamu yakin ingin menghapus pengaduan ini? (y/n): ");
        String konfirmasi = scanner.nextLine().trim();
        
        if (konfirmasi.equalsIgnoreCase("y") || konfirmasi.equalsIgnoreCase("ya")){
            pengelola.hapusPengaduan(id);
            System.out.println("\n[Sukses] Data pengaduan berhasil dihapus.");
        }else{
            System.out.println("\n[Batal] Penghapusan dibatalkan.");
        }
    }
    
    private static String inputTeks(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("[ERROR] Input tidak boleh kosong! Silakan coba lagi.\n");
        }
    }

    private static int inputAngka(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[Error] Input harus berupa angka!");
            }
        }
    }
}
    