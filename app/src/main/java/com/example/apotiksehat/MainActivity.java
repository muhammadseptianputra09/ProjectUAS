package com.example.apotiksehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //declare variable
    Button btnlogin;
    EditText edEmail, edPwd;
    TextView tvdaftar;
    String Email, password;
    private FirebaseAuth mAuth;


    @Override
    // kondisi awal saat Activity baru dibuat
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inisialisasi komponen
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btnmasuk);
        edEmail = findViewById(R.id.edEmail);
        edPwd = findViewById(R.id.edPass);
        tvdaftar = findViewById(R.id.tvDaftar);


        btnlogin = findViewById(R.id.btnmasuk);
        mAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(View -> {
            Masuk();
        });
        tvdaftar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Daftar.class));
        });
    }
    // method proses daripada login
    private void Masuk() {
        String Email = edEmail.getText().toString();
        String password = edPwd.getText().toString();
        // kondisi pada pilihan
        if (TextUtils.isEmpty(Email)) {
            edEmail.setError("Email Tidak Boleh Kosong");
            edEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            edPwd.setError("Email Tidak Boleh Kosong");
            edPwd.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, " Login Berhasil ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HalamanDashboard.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Login Gagal" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}


