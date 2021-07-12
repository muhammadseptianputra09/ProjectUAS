package com.example.apotiksehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Daftar extends AppCompatActivity {
    // deklarasi komponen
    TextView edemail;
    TextInputEditText edpassword;
    Button btndftr;

    FirebaseAuth mAuth;
    // kondisi awal saat Activity baru dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        // inisialisasi komponen
        edemail = findViewById(R.id.eddafemail);
        btndftr = findViewById(R.id.btndaftar);

        mAuth = FirebaseAuth.getInstance();

        btndftr.setOnClickListener(v -> {
            daftar();
            startActivity(new Intent(Daftar.this, MainActivity.class));

        });

    }
    //method daftar
    private void daftar() {
        String Email = edemail.getText().toString();
        String password = edpassword.getText().toString();
        // kondisi
        if (TextUtils.isEmpty(Email)) {
            edemail.setError("Email Tidak Boleh Kosong");
            edemail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            edemail.setError("password Tidak Boleh Kosong");
            edemail.requestFocus();
        } else {
            // ini merupakan proses authentifikasi kedalam firebase
            mAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Daftar.this, " Daftar Berhasil ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Daftar.this, MainActivity.class));
                    } else {
                        Toast.makeText(Daftar.this, "Daftar Gagal" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}