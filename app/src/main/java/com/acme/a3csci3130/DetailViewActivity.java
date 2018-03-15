package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, busField;
    Business receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.name);
        busField = (EditText) findViewById(R.id.number);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            busField.setText(receivedPersonInfo.businessNumber);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
