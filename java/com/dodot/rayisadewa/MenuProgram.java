package com.dodot.rayisadewa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MenuProgram extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_program);

        // Inisialisasi CardView
        CardView btnProg1 = findViewById(R.id.btnprog1);
        CardView btnProg2 = findViewById(R.id.btnprog2);
        CardView btnProg3 = findViewById(R.id.btnprog3);
        CardView btnProg4 = findViewById(R.id.btnprog4);
        CardView btnProg5 = findViewById(R.id.btnprog5);
        CardView btnProg6 = findViewById(R.id.btnprog6);
        CardView btnProg7 = findViewById(R.id.btnprog7);
        CardView btnProg8 = findViewById(R.id.btnprog8);

        // Tambahkan OnClickListener ke setiap CardView
        btnProg1.setOnClickListener(this);
        btnProg2.setOnClickListener(this);
        btnProg3.setOnClickListener(this);
        btnProg4.setOnClickListener(this);
        btnProg5.setOnClickListener(this);
        btnProg6.setOnClickListener(this);
        btnProg7.setOnClickListener(this);
        btnProg8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Tangani klik pada setiap CardView
        if (view.getId() == R.id.btnprog1) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg1
            startActivity(new Intent(this, ScrollingActivity.class));
        } else if (view.getId() == R.id.btnprog2) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg2
            startActivity(new Intent(this, tampilanweb.class));
        } else if (view.getId() == R.id.btnprog3) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg3
            startActivity(new Intent(this, calculatorangka.class));
        } else if (view.getId() == R.id.btnprog4) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg4
            startActivity(new Intent(this, Kalender.class));
        } else if (view.getId() == R.id.btnprog5) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg5
            startActivity(new Intent(this, tabbiodata.class));
        } else if (view.getId() == R.id.btnprog6) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg6
            startActivity(new Intent(this, biodata.class));
        } else if (view.getId() == R.id.btnprog7) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg6
            startActivity(new Intent(this, Drawer.class));
        }
        else if (view.getId() == R.id.btnprog8) {
            // Pindah ke aktivitas yang diinginkan untuk btnProg8
            startActivity(new Intent(this, tetris.class));
        }
    }
}
