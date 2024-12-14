package com.dodot.rayisadewa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculatorangka extends AppCompatActivity {
    EditText angkaSatu, angkaDua;
    Button tambah, kurang, kali, bagi;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatorangka);
        angkaSatu = findViewById(R.id.txtAngka1);
        angkaDua = findViewById(R.id.txtAngka2);
        tambah = findViewById(R.id.btnTambah);
        kurang = findViewById(R.id.btnKurang);
        kali = findViewById(R.id.btnKali);
        bagi = findViewById(R.id.btnBagi);
        hasil = findViewById(R.id.txtHasil);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("+");
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("-");
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("*");
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("/");
            }
        });
    }

    private void hitung(String operator) {
        if (angkaSatu.length() == 0 && angkaDua.length() == 0) {
            Toast.makeText(getApplication(), "Angka tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (angkaSatu.length() == 0) {
            Toast.makeText(getApplication(), "Angka 1 tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (angkaDua.length() == 0) {
            Toast.makeText(getApplication(), "Angka 2 tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            String isiAngka1 = angkaSatu.getText().toString();
            String isiAngka2 = angkaDua.getText().toString();
            double A1 = Double.parseDouble(isiAngka1);
            double A2 = Double.parseDouble(isiAngka2);
            double hs = 0;

            switch (operator) {
                case "+":
                    hs = A1 + A2;
                    break;
                case "-":
                    hs = A1 - A2;
                    break;
                case "*":
                    hs = A1 * A2;
                    break;
                case "/":
                    if (A2 != 0) {
                        hs = A1 / A2;
                    } else {
                        Toast.makeText(getApplication(), "Tidak bisa dibagi dengan 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            String output = String.valueOf(hs);
            hasil.setText(output);
        }
    }
}