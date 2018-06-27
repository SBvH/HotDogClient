package com.example.sebas.hotdogclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    private String mIsHotDog;
    private TextView mOrderNumber;
    private ImageButton mReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                mIsHotDog= null;
            } else {
                mIsHotDog= extras.getString("key");
            }
        }

        mOrderNumber = (TextView) findViewById(R.id.order_number_text);
        mOrderNumber.setText(mIsHotDog);

        mReturn = (ImageButton) findViewById(R.id.return_button);
        mReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(ConfirmationActivity.this, MainActivity.class);
                ConfirmationActivity.this.startActivity(myIntent);

            }
        });
    }
}
