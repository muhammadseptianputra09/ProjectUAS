package com.example.apotiksehat;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Obat.Obat;
import Transaksi.Transaksi;

public class DataObat extends AppCompatActivity {
    // deklarasi komponen
    DatabaseReference mAuth;
    private EditText edkode;
    private EditText nmobat;
    private EditText edjml;
    private EditText edhrga;
    public Button btntmbh;


    @Override
    // kondisi awal saat Activity baru dibuat
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_obat);

        // inisialisasi komponen

        edkode = (EditText) findViewById(R.id.edikode);
        nmobat = (EditText) findViewById(R.id.edinmobt);
        edjml = (EditText) findViewById(R.id.edijml);
        edhrga = (EditText) findViewById(R.id.edihrga);
        btntmbh = (Button) findViewById(R.id.btntmbh);

        //PROSES input data kedalam firebase dengan nama database Obat
        mAuth = FirebaseDatabase.getInstance().getReference().child("Obat");
        // method onclick
        btntmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tambahobat();
            }
        });
    }

    //methode untuk menambahkan obat
    private void Tambahobat() {

        String kode = edkode.getText().toString();
        String namaobat = nmobat.getText().toString();
        String jumlah = edjml.getText().toString();
        String Harga = edhrga.getText().toString();

        Obat obat = new Obat(kode, namaobat, jumlah, Harga);

        //Memigrasikan Aplikasi Parse pada Android ke Firebase
        mAuth.push().setValue(obat);
        Toast.makeText(DataObat.this, "obat berhasil di tambahkan", Toast.LENGTH_SHORT);
    }
}
