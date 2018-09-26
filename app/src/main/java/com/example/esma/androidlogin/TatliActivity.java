package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TatliActivity extends AppCompatActivity {
    Button btnCheeseCake,btnKurabiye;
    String secilen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tatli);
        btnCheeseCake = (Button)findViewById(R.id.btnCheeseCake);
        btnKurabiye = (Button)findViewById(R.id.btnKurabiye);


        btnCheeseCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="cheeseCake";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);
            }
        });
        btnKurabiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="kurabiye";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);

            }
        });
    }
}
