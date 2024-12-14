package com.dodot.rayisadewa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class add_inventory_item extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextDescription;
    private EditText editTextQuantity;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory_item); // Pastikan ini mengarah ke layout XML yang dibuat

        editTextName = findViewById(R.id.editTextName);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(v -> addItem());
    }

    private void addItem() {
        String name = editTextName.getText().toString();
        String description = editTextDescription.getText().toString();
        String quantityStr = editTextQuantity.getText().toString();

        if (name.isEmpty() || description.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Mohon lengkapi semua kolom", Toast.LENGTH_SHORT).show();
        } else {
            int quantity = Integer.parseInt(quantityStr);
            // Implementasikan logika untuk menambahkan item ke basis data atau list
            // Misalnya, ini bisa menjadi intent kembali atau penyimpanan ke database

            // Kembali ke InventoryActivity
            Intent intent = new Intent();
            intent.putExtra("ITEM_NAME", name);
            intent.putExtra("ITEM_DESCRIPTION", description);
            intent.putExtra("ITEM_QUANTITY", quantity);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}