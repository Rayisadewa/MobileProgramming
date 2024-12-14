package com.dodot.rayisadewa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login extends AppCompatActivity {

    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnRegister.setOnClickListener(v -> startRegisterActivity());

        btnLogin.setOnClickListener(v -> loginUser());
    }

    private void startRegisterActivity() {
        Intent register = new Intent(getApplicationContext(), register.class);
        startActivity(register);
    }

    private void loginUser() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            showToast("Username atau Password Salah");
        } else {
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.child(username).exists()) {
                        if (Objects.equals(snapshot.child(username).child("password").getValue(String.class), password)) {
                            showToast("Login Berhasil");
                            startMenuProgramActivity();
                        } else {
                            showToast("Password Salah");
                        }
                    } else {
                        showToast("Data Belum Terdaftar");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    showToast("Error: " + error.getMessage());
                }
            });
        }
    }

    private void startMenuProgramActivity() {
        Intent menuProgram = new Intent(getApplicationContext(), MenuProgram.class);
        startActivity(menuProgram);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
