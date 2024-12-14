package com.dodot.rayisadewa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Kalender extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView selectedDateTextView;
    private EditText noteInput;
    private Button saveNoteButton;
    private Button deleteNoteButton; // Button untuk menghapus catatan
    private TextView storedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalender); // Pastikan ini merujuk ke layout Anda

        calendarView = findViewById(R.id.calender);
        selectedDateTextView = findViewById(R.id.today_date);
        noteInput = findViewById(R.id.note_input);
        saveNoteButton = findViewById(R.id.save_note_button);
        deleteNoteButton = findViewById(R.id.delete_note_button); // Inisialisasi button hapus
        storedNote = findViewById(R.id.stored_note);

        // Set default date to today
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        selectedDateTextView.setText("Hari Ini: " + currentDate);

        // Listener untuk menangani ketika pengguna memilih tanggal
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/   " + (month + 1) + "/" + year;
            selectedDateTextView.setText("Tanggal Terpilih: " + selectedDate);
        });

        // Listener untuk menyimpan catatan
        saveNoteButton.setOnClickListener(v -> {
            String note = noteInput.getText().toString();
            if (!note.isEmpty()) {
                storedNote.setText("Catatan: " + note);
                noteInput.setText(""); // Clear input field
            } else {
                storedNote.setText("Catatan tidak boleh kosong.");
            }
        });

        // Listener untuk menghapus catatan
        deleteNoteButton.setOnClickListener(v -> {
            storedNote.setText(""); // Clear the stored note TextView
            noteInput.setText(""); // Clear the input field
        });
    }
}