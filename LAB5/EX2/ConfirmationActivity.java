package com.example.travelticketbooking;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView sourceText, destinationText, dateText, ticketTypeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        sourceText = findViewById(R.id.sourceText);
        destinationText = findViewById(R.id.destinationText);
        dateText = findViewById(R.id.dateText);
        ticketTypeText = findViewById(R.id.ticketTypeText);

        // Retrieve details from intent
        String source = getIntent().getStringExtra("source");
        String destination = getIntent().getStringExtra("destination");
        String date = getIntent().getStringExtra("date");
        String ticketType = getIntent().getStringExtra("ticketType");

        // Display details
        sourceText.setText("Source: " + source);
        destinationText.setText("Destination: " + destination);
        dateText.setText("Travel Date: " + date);
        ticketTypeText.setText("Ticket Type: " + ticketType);
    }
}
