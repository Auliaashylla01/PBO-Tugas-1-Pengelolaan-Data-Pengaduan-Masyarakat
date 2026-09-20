/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Masyarakat extends Pengguna{
    protected String nik;
    protected String alamat;
    
    public Masyarakat(String idPengguna, String nama, String nik, String alamat){
        super(idPengguna, nama);
        this.nik = nik;
        this.alamat = alamat;         
    }
    public String getnik (){
        return nik;
    }
    public String getalamat(){
        return alamat;
    }
    public void setnik(String nik){
        this.nik = nik;
    }
    public void setalamat(String alamat){
        this.alamat = alamat;
    }
    public void tampilkanInfoMasyarakat(){
        System.out.println("\n================================");
        System.out.println("====== INFORMASI PENGGUNA ======");
        System.out.println("NIK: " + nik);
        super.tampilkanInfoPengguna();
        System.out.println("Alamat:  " + alamat);
        System.out.println("================================");
    }
}
