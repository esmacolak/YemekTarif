package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalataActivity extends AppCompatActivity {
    Button btnPatates,btnBrokoli;
    String secilen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salata);
        btnPatates = (Button)findViewById(R.id.btnPatates);
        btnBrokoli = (Button)findViewById(R.id.btnBrokoli);


        btnPatates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="patates";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
        btnBrokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="brokoli";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
    }
}
