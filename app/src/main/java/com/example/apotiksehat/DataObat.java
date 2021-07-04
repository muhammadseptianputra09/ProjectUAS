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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataObat extends AppCompatActivity {
    private DatabaseReference database;
    private EditText edkode;
    private EditText nmobat;
    private EditText edjml;
    private EditText edhrga;
    public Button btntmbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_obat);

        edkode = (EditText) findViewById(R.id.edikode);
        nmobat = (EditText) findViewById(R.id.edinmobt);
        edjml  = (EditText) findViewById(R.id.edijml);
        edhrga = (EditText) findViewById(R.id.edihrga);
        btntmbh = (Button) findViewById(R.id.btntmbh);

        database = FirebaseDatabase.getInstance().getReference();

        btntmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(edkode.getText().toString().isEmpty()) && !(nmobat.getText().toString().isEmpty()) && edjml.getText().toString().isEmpty() && edhrga.getText().toString().isEmpty())
                    submitObat(new Obat(edkode.getText().toString(), nmobat.getText().toString(), edjml.getText().toString(), edhrga.getText().toString()));
                else
                    Toast.makeText(getApplicationContext(), "Data TIdak Boleh Kosong", Toast.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edkode.getWindowToken(),0);
            }
        });


    }

    private void submitObat(Obat obat) {
        database.child("Barang").push().setValue(obat).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                edkode.setText("");
                nmobat.setText("");
                edjml.setText("");
                edhrga.setText("");
                Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
            }
        });

    }
    public static Intent getActIntent(DataObat dataObat ) {
        return new Intent(dataObat, DataObat.class);
    }

}