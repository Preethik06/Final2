package com.example.final2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class receiptfinal extends AppCompatActivity {
    EditText etName, etMeterNo, etCANo, etAddress, etCurrentReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiptfinal);

        etName = findViewById(R.id.etName);
        etMeterNo = findViewById(R.id.etMeterNo);
        etCANo = findViewById(R.id.etCANo);
        etAddress = findViewById(R.id.etAddress);
        etCurrentReading = findViewById(R.id.etCurrentReading);
    }
    public void generateReceipt(View view) {
        // Get user input
        String name = etName.getText().toString();
        String meterNo = etMeterNo.getText().toString();
        String caNo = etCANo.getText().toString();
        String address = etAddress.getText().toString();
        String currentReading = etCurrentReading.getText().toString();
        name = "Abc";
        meterNo = "1234";
        caNo = "1234";
        address = "Ponda";
        currentReading = "2345";

        // Create the receipt string
        String receipt = "Name: " + name + "\n" +
                "Meter No: " + meterNo + "\n" +
                "CA No: " + caNo + "\n" +
                "Address: " + address + "\n" +
                "Current Reading: " + currentReading + "\n" +
                "Total: [Calculate total here]";

        // Start the ReceiptActivity and pass the receipt string
        Intent intent = new Intent(this, receiptpage.class);
        intent.putExtra("receipt", receipt);
        startActivity(intent);
    }
}