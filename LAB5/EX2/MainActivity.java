package com.example.travelticketbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner sourceSpinner, destinationSpinner;
    private DatePicker datePicker;
    private ToggleButton ticketTypeToggle;
    private Button submitButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceSpinner = findViewById(R.id.sourceSpinner);
        destinationSpinner = findViewById(R.id.destinationSpinner);
        datePicker = findViewById(R.id.datePicker);
        ticketTypeToggle = findViewById(R.id.ticketTypeToggle);
        submitButton = findViewById(R.id.submitButton);
        resetButton = findViewById(R.id.resetButton);

        // Set up the spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(adapter);
        destinationSpinner.setAdapter(adapter);

        // Submit button action
        submitButton.setOnClickListener(v -> submitDetails());

        // Reset button action
        resetButton.setOnClickListener(v -> resetFields());
    }

    private void submitDetails() {
        String source = sourceSpinner.getSelectedItem().toString();
        String destination = destinationSpinner.getSelectedItem().toString();
        String ticketType = ticketTypeToggle.isChecked() ? "Round-Trip" : "One-Way";

        // Get selected date from the DatePicker
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        String travelDate = day + "/" + month + "/" + year;

        if (source.equals(destination)) {
            Toast.makeText(this, "Source and destination cannot be the same", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
        intent.putExtra("source", source);
        intent.putExtra("destination", destination);
        intent.putExtra("date", travelDate);
        intent.putExtra("ticketType", ticketType);
        startActivity(intent);
    }

    private void resetFields() {
        sourceSpinner.setSelection(0);
        destinationSpinner.setSelection(0);
        ticketTypeToggle.setChecked(false);

        // Reset the date picker to the current date
        Calendar calendar = Calendar.getInstance();
        datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
}
