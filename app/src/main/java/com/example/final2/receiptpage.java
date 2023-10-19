package com.example.final2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class receiptpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiptpage);

        TextView tvReceipt = findViewById(R.id.tvReceipt);

        // Retrieve the receipt string from the intent
        String receipt = getIntent().getStringExtra("receipt");

        // Display the receipt
        tvReceipt.setText(receipt);
    }
}