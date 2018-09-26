package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SebzeActivity extends AppCompatActivity {
    Button btnIspanak,btnBezelye,btnDolma;
    String secilen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sebze);

        btnIspanak = (Button)findViewById(R.id.btnIspanak);
        btnBezelye = (Button)findViewById(R.id.btnBezelye);
        btnDolma = (Button)findViewById(R.id.btnDolma);

        btnIspanak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="ispanak";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });

        btnBezelye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="bezelye";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });

        btnDolma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="dolma";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });


    }
}
