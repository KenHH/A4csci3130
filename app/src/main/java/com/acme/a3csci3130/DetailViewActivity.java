package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText nameField, busField,adrField;
    private Spinner typeSpinner, provSpinner;
    private DatabaseReference userRef;
    private MyApplicationData appState;
    private FirebaseDatabase database;
    Business receivedPersonInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.name);
        busField = (EditText) findViewById(R.id.number);
        adrField = (EditText) findViewById(R.id.address);

        typeSpinner = (Spinner) findViewById(R.id.type_spin);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.bus_type_array, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        provSpinner = (Spinner) findViewById(R.id.prov_spin);
        ArrayAdapter<CharSequence> provAdapter = ArrayAdapter.createFromResource(this, R.array.business_prov_array, android.R.layout.simple_spinner_item);
        provAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provSpinner.setAdapter(provAdapter);

        database=FirebaseDatabase.getInstance();
        userRef=database.getReference();
        
        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            busField.setText(receivedPersonInfo.businessNumber);
            adrField.setText(receivedPersonInfo.address);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality

        String uid=receivedPersonInfo.uid;
        String newName=nameField.getText().toString();
        String newPrim= typeSpinner.getSelectedItem().toString();
        String newBusNum=busField.getText().toString();
        String newAdr=adrField.getText().toString();
        String newProv=provSpinner.getSelectedItem().toString();


        Business newInfo=new Business(uid,newBusNum,newName,newPrim, newAdr, newProv);
        userRef.child("business").child(uid).setValue(newInfo);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String uid=receivedPersonInfo.uid;
        userRef.child("business").child(uid).removeValue();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
