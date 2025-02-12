package com.example.vehicleparkingregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText vehicleNumberEditText, rcNumberEditText;
    private Spinner vehicleTypeSpinner;
    private Button submitButton;
    private String selectedVehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleNumberEditText = findViewById(R.id.vehicleNumberEditText);
        rcNumberEditText = findViewById(R.id.rcNumberEditText);
        vehicleTypeSpinner = findViewById(R.id.vehicleTypeSpinner);
        submitButton = findViewById(R.id.submitButton);

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicle_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(adapter);

        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVehicleType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedVehicleType = "Car"; // Default selection
            }
        });

        submitButton.setOnClickListener(v -> submitDetails());
    }

    private void submitDetails() {
        String vehicleNumber = vehicleNumberEditText.getText().toString().trim();
        String rcNumber = rcNumberEditText.getText().toString().trim();

        if (vehicleNumber.isEmpty() || rcNumber.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
        intent.putExtra("vehicleType", selectedVehicleType);
        intent.putExtra("vehicleNumber", vehicleNumber);
        intent.putExtra("rcNumber", rcNumber);
        startActivity(intent);
    }
}
