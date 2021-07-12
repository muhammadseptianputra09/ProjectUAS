package com.example.apotiksehat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RiwayatTransaksi extends AppCompatActivity {
    //deklarasi komponen
    ListView listtransaksi;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    // kondisi awal saat Activity baru dibuat
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_transaksi);
        // inisialisasi komponen
        Button buttonkembali = findViewById(R.id.btnkmbliio);
        //untuk menambahkan data ke daftar dalam database dengan nama database Transaksi
        databaseReference= FirebaseDatabase.getInstance().getReference("Transaksi");
        listtransaksi = findViewById(R.id.listtransaksi);
        //Mengatur ArrayAdapter untuk listView
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.activity_list_item, arrayList);
        listtransaksi.setAdapter(arrayAdapter);
        databaseReference.addChildEventListener(new ChildEventListener() {

            //method yang akan ditampilkan pada listview
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    arrayList.add(dataSnapshot.getValue().toString());

                }

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        // sebuah action dan komunikasi antar komponen aplikasi.
        buttonkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RiwayatTransaksi.this,HalamanDashboard.class);
                startActivity(intent);
            }
        });
    }
}