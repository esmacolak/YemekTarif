package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TavukActivity extends AppCompatActivity {
    Button btntavSis,btnBut;
    String secilen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tavuk);

        btntavSis = (Button) findViewById(R.id.btntavSis);
        btnBut = (Button) findViewById(R.id.btnBut);


        btntavSis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="sis";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
        btnBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="but";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });

    }
}
