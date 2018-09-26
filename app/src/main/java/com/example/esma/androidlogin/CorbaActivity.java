package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CorbaActivity extends AppCompatActivity {
    Button btnMercimek,btnSebz,btnMantar;
    String secilen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corba);

        btnMercimek = (Button) findViewById(R.id.btnmercimek);
        btnSebz = (Button)findViewById(R.id.btnSeb);
        btnMantar = (Button) findViewById(R.id.btnBuyuk);

        btnMercimek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="mercimek";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });

        btnSebz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="sebze";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });

        btnMantar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="mantar";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });

    }
}
