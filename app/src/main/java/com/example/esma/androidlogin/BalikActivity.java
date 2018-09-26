package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BalikActivity extends AppCompatActivity {
    Button btnBuyuk,btnHamsi;
    String secilen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balik);

        btnBuyuk = (Button)findViewById(R.id.btnBuyuk);

        btnBuyuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="buyuk";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
        btnHamsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="hamsi";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
    }
}
