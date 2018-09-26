package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EtActivity extends AppCompatActivity {
    Button btnBiftek;
    String secilen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et);
        btnBiftek = (Button)findViewById(R.id.btnBiftek);

        btnBiftek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secilen="biftek";
                Intent intent =new Intent(getApplicationContext(),GelenTarif.class);
                intent.putExtra("secilen", secilen);
                startActivity(intent);

            }
        });
    }
}
