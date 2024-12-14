package com.dodot.rayisadewa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class inventory extends AppCompatActivity {

    private TableLayout inventoryTable;
    private Button addButton;
    private List<InventoryItem> inventoryItems; // Daftar barang inventaris

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory); // Pastikan ini mengarah ke layout XML yang benar

        inventoryTable = findViewById(R.id.inventory_table);
        addButton = findViewById(R.id.add_button);

        // Inisialisasi daftar barang inventaris
        inventoryItems = new ArrayList<>();
        populateTable(getInventoryData());

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, add_inventory_item.class);
            startActivityForResult(intent, 1); // Menggunakan request code 1 untuk identifikasi
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("ITEM_NAME");
            String description = data.getStringExtra("ITEM_DESCRIPTION");
            int quantity = data.getIntExtra("ITEM_QUANTITY", 0);

            // Tambahkan item baru ke inventaris
            InventoryItem newItem = new InventoryItem(name, description, quantity);
            inventoryItems.add(newItem); // Menambahkan item ke daftar
            populateTable(inventoryItems); // Tampilkan tabel yang diperbarui
        }
    }

    // Mendapatkan data inventaris awal (contoh data)
    private List<InventoryItem> getInventoryData() {
        List<InventoryItem> items = new ArrayList<>();
        items.add(new InventoryItem("", "",0));
        items.add(new InventoryItem("", "", 0));
        items.add(new InventoryItem("", "", 0));
        return items;
    }

    // Mengisi tabel dengan data inventaris
    private void populateTable(List<InventoryItem> items) {
        inventoryTable.removeAllViews(); // Menghapus semua tampilan dari tabel

        // Membuat header tabel
        TableRow headerRow = new TableRow(this);
        String[] headers = {"Nama Barang", "Deskripsi", "Jumlah"};
        for (String header : headers) {
            TextView textView = new TextView(this);
            textView.setText(header);
            textView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            textView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            textView.setTextColor(getResources().getColor(android.R.color.white));
            headerRow.addView(textView);
        }
        inventoryTable.addView(headerRow);

        // Mengisi tabel dengan data inventaris
        for (InventoryItem item : items) {
            TableRow row = new TableRow(this);

            TextView nameTextView = new TextView(this);
            nameTextView.setText(item.getName());
            nameTextView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

            TextView descriptionTextView = new TextView(this);
            descriptionTextView.setText(item.getDescription());
            descriptionTextView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

            TextView quantityTextView = new TextView(this);
            quantityTextView.setText(String.valueOf(item.getQuantity()));
            quantityTextView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

            // Menambahkan TextView ke TableRow
            row.addView(nameTextView);
            row.addView(descriptionTextView);
            row.addView(quantityTextView);

            // Menambahkan TableRow ke TableLayout
            inventoryTable.addView(row);
        }
    }
}