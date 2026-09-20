/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Pengaduan {
    private String idPengaduan;
    private Masyarakat Pengguna;
    private String jenisPengaduan;
    private String isiPengaduan;
    private String tanggalPengaduan;
    private String status;
    
    public Pengaduan (String idPengaduan, Masyarakat Pengguna, String jenisPengaduan, String isiPengaduan, String tanggalPengaduan){
        this.idPengaduan = idPengaduan;
        this.Pengguna = Pengguna;
        this.jenisPengaduan = jenisPengaduan;
        this.isiPengaduan = isiPengaduan;
        this.tanggalPengaduan = tanggalPengaduan;
        this.status = "Pengaduan Kamu sedang Menunggu Konfirmasi...";
    }
    public String getidPengaduan (){
        return idPengaduan;
}
    public Masyarakat getPengguna(){
        return Pengguna;
    }
    public String getjenisPengaduan(){
        return jenisPengaduan;
    }
    public String getisiPengaduan(){
        return isiPengaduan;
    }
    public String gettanggalPengaduan(){
        return tanggalPengaduan;
    }
    public String getstatus(){
        return status;
    }
    public void setstatus(String status){
        this.status = status;
    }
    public void tampilkanInfoPengaduan(){
        System.out.println("ID Pengaduan: " + idPengaduan);
        Pengguna.tampilkanInfoMasyarakat();
        System.out.println("Jenis Pengaduan: " + jenisPengaduan);
        System.out.println("Isi Pengaduan: " + isiPengaduan);
        System.out.println("Tanggal Pengaduan(dd/mm/yyyy): " + tanggalPengaduan);
        System.out.println("Status: " + status);
    }
}
