/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Pengguna {
    protected String idPengguna;
    protected String nama;
    
    public Pengguna(String idPengguna, String nama){
        this.idPengguna = idPengguna;
        this.nama = nama;
    } 
    public String getidPengguna(){
        return idPengguna;
    }
    public String getnama (){
        return nama;
    }
    public void setnama(String nama){
        this.nama = nama;
    }
    public void tampilkanInfoPengguna(){
        System.out.println("===============================");
        System.out.println("ID Pengguna: " + idPengguna);
        System.out.println("Nama: " + nama);
        System.out.println("===============================");
    }
}
