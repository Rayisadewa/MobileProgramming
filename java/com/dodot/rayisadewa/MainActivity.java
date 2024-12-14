package com.dodot.rayisadewa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button menu= findViewById(R.id.btnmenu);
        menu.setOnClickListener(arg0 -> {
            Intent i = new Intent(getApplicationContext(), MenuProgram.class);
            startActivity(i);
        });

    }
}