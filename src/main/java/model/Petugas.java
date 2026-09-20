/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Petugas extends Pengguna {
    protected String nip;
    protected String jabatan;
    
    public Petugas (String idPengguna, String nama, String nip, String jabatan){
        super(idPengguna, nama);
        this.nip = nip;
        this.jabatan = jabatan;
    }
    public String getnip (){
        return nip;
    }
    public String getjabatan(){
        return jabatan;
    }
    public void setnip(String nip){
        this.nip = nip;
    }
    public void setjabatan(String jabatan){
        this.jabatan = jabatan;
    }
    public void tampilkanInfoPetugas(){
        System.out.println("\n================================");
        System.out.println("====== INFORMASI PENGGUNA ======");
        System.out.println("NIP: " + nip);
        super.tampilkanInfoPengguna();
        System.out.println("Jabatan:  " + jabatan);
        System.out.println("================================");
    }
}
