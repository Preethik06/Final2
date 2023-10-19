package com.example.final2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class GenerateBill extends AppCompatActivity {
    TextInputEditText v1,v2;
    TextView meterno;
    Button calculate;
    TextView textView;
    String meter_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_bill);
        v1=findViewById(R.id.prevReading);
        v2=findViewById(R.id.currReading);
        meterno=findViewById(R.id.meterno);
        textView=findViewById(R.id.textView1);
        calculate=findViewById(R.id.submit);

        Intent intent=getIntent();
        meter_display=intent.getStringExtra("meter_key");
        meterno.setText(meter_display);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(v1.getText().toString());;
                int n2 = Integer.parseInt(v2.getText().toString());
                int unit = n2 - n1;
                double billAmount = calculateElectricityBill(unit);
                textView.setText(String.valueOf(billAmount));
                Intent intent = new Intent(GenerateBill.this, receiptpage.class);
//tyehdgj
                String name = "Abc";
                String meterNo = "1234";
                String caNo = "1234";
                String address = "Ponda";
                String currentReading = "2345";
                // Create the receipt string
                String receipt = "Name: " + name + "\n" +
                        "Meter No: " + meterNo + "\n" +
                        "CA No: " + caNo + "\n" +
                        "Address: " + address + "\n" +
                        "Current Reading: " + currentReading + "\n" +
                        "Total: [Calculate total here]";

                intent.putExtra("receipt", receipt);
                startActivity(intent);
            }
        });
    }

    private double calculateElectricityBill(int unit) {
        double billAmount = 0;
        int slab;
        switch (unit / 100) {
            case 0:
                slab = 0;
                break;
            case 1:
                slab = 1;
                break;
            case 2:
                slab = 2;
                break;
            case 3:
                slab = 3;
                break;
            case 4:
                slab = 4;
                break;
            default:
                slab = 5;
                break;
        }
        switch (slab) {
            case 0:
                billAmount = (unit * 1.75);
                break;
            case 1:
                billAmount = 100 * 1.75 + (unit-100) * 2.60;
                break;
            case 2:
                billAmount = 100 * 1.75 + 100 * 2.60 + (unit-200) * 3.30;
                break;
            case 3:
                billAmount = 100 * 1.75 + 100 * 2.60 + 100 * 3.30 + (unit-300) * 4.40;
                break;
            default:
                billAmount = 100 * 1.75 + 100 * 2.60 + 100 * 3.30 + 100 * 4.40 + (unit-400) * 5.10;
                break;
        }
        return billAmount;
    }
}