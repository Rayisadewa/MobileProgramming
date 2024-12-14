package com.dodot.rayisadewa;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.appcompat.app.AppCompatActivity;


public class tetris extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
        Button inventory= findViewById(R.id.btnInventory);
        inventory.setOnClickListener(arg0 -> {
            Intent i = new Intent(getApplicationContext(), inventory.class);
            startActivity(i);
        });

    }
}