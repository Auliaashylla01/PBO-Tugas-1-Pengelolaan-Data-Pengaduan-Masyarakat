/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.ArrayList;
import model.Pengaduan;
/**
 *
 * @author ASUS
 */
public class PengelolaDataPengaduan {
    private ArrayList <Pengaduan> daftarPengaduan = new ArrayList <> ();
    
    public boolean idSudahAda (String idPengaduan){
        for (Pengaduan p : daftarPengaduan){
            if (p.getidPengaduan().equalsIgnoreCase(idPengaduan)) return true;
        }
        return false;
    }
    public String generateId(){
        int nomor = 1;
        String idBaru;
        do {
            idBaru = String.format ("P%03d", nomor);
            nomor++;
        } while (idSudahAda(idBaru));
        return idBaru;
    }
    public void tambahPengaduan (Pengaduan pengaduan){
        daftarPengaduan.add(pengaduan);
    }
    public void lihatPengaduan (){
        if (daftarPengaduan.isEmpty()){
            System.out.println("\n[Informasi] Belum ada data pengaduan yang tersimpan.");
            return;
        }
        System.out.println("==================================================");
        System.out.println("                    DAFTAR PENGADUAN              ");
        System.out.println("==================================================");
        
        for (Pengaduan p : daftarPengaduan){
            p.tampilkanInfoPengaduan();
            System.out.println("--------------------------------------------------");
        }
    }
    public Pengaduan cariPengaduan (String idPengaduan){
        for (Pengaduan p : daftarPengaduan){
            if (p.getidPengaduan().equalsIgnoreCase(idPengaduan)) return p;
        }
        return null;      
    }
    public boolean ubahStatus (String idPengaduan, String statusBaru){
        Pengaduan p = cariPengaduan(idPengaduan);
        if (p != null){
            p.setstatus(statusBaru);
            return true;
        }
        return false;
    }
    public boolean hapusPengaduan (String idPengaduan){
        Pengaduan p = cariPengaduan(idPengaduan);
        if (p != null){
            daftarPengaduan.remove(p);
            return true;
        }
        return false;
    }
}
