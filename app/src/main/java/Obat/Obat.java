package Obat;


// class pada database dengan nama database obat yang telah di generate
public class Obat {
    String kode;
    String namaobat;
    String jumlah;
    String Harga;

    public Obat(String kode, String namaobat, String jumlah, String harga) {
        this.kode = kode;
        this.namaobat = namaobat;
        this.jumlah = jumlah;
        Harga = harga;
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

    public String string(){
        return this.kode + " " + namaobat + " " + jumlah;

    }
}
