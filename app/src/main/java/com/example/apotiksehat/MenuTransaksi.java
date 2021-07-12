package com.example.apotiksehat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Obat.Obat;
import Transaksi.Transaksi;

public class MenuTransaksi extends AppCompatActivity {
    // deklarasi komponen
    DatabaseReference mAuth;
    private EditText edkode;
    private EditText nmobat;
    private EditText edjml;
    private EditText edhrga;
    private EditText edtotal;
    public Button submit;

    @Override
    // kondisi awal saat Activity baru dibuat
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_transaksi);

        // inisialisasi komponen
        edkode = (EditText) findViewById(R.id.edkdobt);
        nmobat = (EditText) findViewById(R.id.ednmobt);
        edjml = (EditText) findViewById(R.id.edjml);
        edhrga = (EditText) findViewById(R.id.edhrg);
        edtotal = (EditText) findViewById(R.id.edttl);
        submit = (Button) findViewById(R.id.tblSubmit);

        //PROSES input data kedalam firebase dengan nama database Transaksi
        mAuth = FirebaseDatabase.getInstance().getReference().child("Transaksi");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            // method onclick
            public void onClick(View v) {
                transaksi();
            }
        });
    }
    //methode untuk menambahkan transaksi
    private void transaksi() {

        String kode = edkode.getText().toString();
        String namaobat = nmobat.getText().toString();
        String jumlah = edjml.getText().toString();
        String Harga = edhrga.getText().toString();
        String Total = edtotal.getText().toString();

        Transaksi transaksi = new Transaksi(kode, namaobat, jumlah, Harga, Total);

        //Memigrasikan Aplikasi Parse pada Android ke Firebase
        mAuth.push().setValue(transaksi);
        Toast.makeText(MenuTransaksi.this, "Transaksi berhasil di tambahkan", Toast.LENGTH_SHORT);
    }
}
