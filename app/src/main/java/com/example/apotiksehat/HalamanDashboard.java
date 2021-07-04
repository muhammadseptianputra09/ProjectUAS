package com.example.apotiksehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HalamanDashboard extends AppCompatActivity {
    private ImageView RW;
    private ImageView IO;
    private ImageView DO;
    private ImageView MT;
    private Button btnkeluar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_dashboard);

        RW = (ImageView) findViewById(R.id.RW);
        IO = (ImageView) findViewById(R.id.IO);
        DO = (ImageView) findViewById(R.id.Do);
        MT = (ImageView) findViewById(R.id.MT);

        RW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HalamanDashboard.this,RiwayatTransaksi.class);
                    startActivity(intent);

            }
        });
        IO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HalamanDashboard.this,InfoObat.class);
                startActivity(intent);

            }
        });
        MT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HalamanDashboard.this,MenuTransaksi.class);
                startActivity(intent);

            }
        });
        DO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HalamanDashboard.this,DataObat.class);
                startActivity(intent);

            }
        });
    }

}

