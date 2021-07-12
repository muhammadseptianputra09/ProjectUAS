package Transaksi;


// class pada database dengan nama database transaksi yang telah di generate
public class Transaksi {
    String kode;
    String namaobat;
    String jumlah;
    String Harga;
    String Total;

    public Transaksi(String kode, String namaobat, String jumlah, String harga, String total) {
        this.kode = kode;
        this.namaobat = namaobat;
        this.jumlah = jumlah;
        Harga = harga;
        Total = total;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaobat() {
        return namaobat;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getHarga() {
        return Harga;
    }

    public String getTotal() {
        return Total;
    }
}
