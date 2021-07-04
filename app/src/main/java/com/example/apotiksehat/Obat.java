package com.example.apotiksehat;

import java.io.Serializable;

public class Obat implements Serializable {
    private String kode;
    private String nama;
    private String jumlah;
    private String harga;


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    public Obat(String kode, String nama, String jumlah, String harga){
        this.kode = kode;
        this.nama = nama;
        this. jumlah = jumlah;
        this.harga = harga;

    }
}
