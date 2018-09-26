package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YumurtaActivity extends AppCompatActivity {
    Button btnOmlet,btnEkemk;
    String secilen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yumurta);

        btnOmlet = (Button) findViewById(R.id.btnOmlet);
        btnEkemk= (Button) findViewById(R.id.btnEkmek);

        btnOmlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="omlet";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
        btnEkemk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="ekmek";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);

            }
        });

    }
}
