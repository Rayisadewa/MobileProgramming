package com.dodot.rayisadewa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword;
    private Button btnRegister;

    private DatabaseReference database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = findViewById(R.id.username);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnRegister = findViewById(R.id.registerButton);

        TextView register = findViewById(R.id.login);

        register.setOnClickListener(v -> {
            Intent i = new Intent(register.this, login.class);
            startActivity(i);
            finish();
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                } else{
                    database = FirebaseDatabase.getInstance().getReference("Users");
                    database.child(username).child("Username").setValue(username);
                    database.child(username).child("Email").setValue(email);
                    database.child(username).child("Password").setValue(password);

                    Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(getApplicationContext(), login.class);
                    startActivity(register);
                    finish();
                }
            }
        });
    }
}