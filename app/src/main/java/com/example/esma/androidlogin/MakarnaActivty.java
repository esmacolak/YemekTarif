package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakarnaActivty extends AppCompatActivity {
    Button btnFırınMak,btnPesto;
    String secilen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makarna_activty);
        btnFırınMak = (Button)findViewById(R.id.btnFırınMak);
        btnPesto = (Button)findViewById(R.id.btnPesto);

        btnFırınMak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="fırınMak";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
        btnPesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="pesto";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
    }
}
