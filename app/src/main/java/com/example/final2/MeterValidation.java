package com.example.final2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MeterValidation extends AppCompatActivity {
    //private EditText meterNumberEditText;
    private TextInputEditText meterNumberEditText;
    private Button submit;
    private DatabaseReference databaseReference;
    String meterno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter_validation);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Person");
        meterNumberEditText = findViewById(R.id.meterno);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkDataExistence();
                meterno=meterNumberEditText.getEditableText().toString();

                if (meterno.equals("A_1234")) {
                    //tv.setText(meterno);
                    Intent intent = new Intent(MeterValidation.this, GenerateBill.class);
                    intent.putExtra("meter_key",meterno);
                    startActivity(intent);
                }
            }
        });
    }
    private void checkDataExistence() {
        final String A9049 = meterNumberEditText.getText().toString().trim();

        // Set up ValueEventListener to check if data exists
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(A9049)) {
                    Toast.makeText(getApplicationContext(), "Data is Exist", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(), GenerateBill.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Data is Not Exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that may occur
            }
        });
    }
}