package com.example.vehicleparkingregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.UUID;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView vehicleTypeText, vehicleNumberText, rcNumberText;
    private Button confirmButton, editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        vehicleTypeText = findViewById(R.id.vehicleTypeText);
        vehicleNumberText = findViewById(R.id.vehicleNumberText);
        rcNumberText = findViewById(R.id.rcNumberText);
        confirmButton = findViewById(R.id.confirmButton);
        editButton = findViewById(R.id.editButton);

        String vehicleType = getIntent().getStringExtra("vehicleType");
        String vehicleNumber = getIntent().getStringExtra("vehicleNumber");
        String rcNumber = getIntent().getStringExtra("rcNumber");

        vehicleTypeText.setText("Vehicle Type: " + vehicleType);
        vehicleNumberText.setText("Vehicle Number: " + vehicleNumber);
        rcNumberText.setText("RC Number: " + rcNumber);

        confirmButton.setOnClickListener(v -> confirmDetails());
        editButton.setOnClickListener(v -> finish());
    }

    private void confirmDetails() {
        String serialNumber = UUID.randomUUID().toString();
        Toast.makeText(this, "Parking Allotted! Serial Number: " + serialNumber, Toast.LENGTH_LONG).show();
    }
}
