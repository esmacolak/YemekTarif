package com.example.esma.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Material extends AppCompatActivity {
    CheckBox checkYum, checkBalik, checkTavuk, checkEt, checkSosis, checkUn, checkPirinc, checkBulgur, checkYufka, checkIspanak, checkKabak, checkFasulye, checkEnginar, checkBezelye, checkLahana, checkPatates, checkDomates, checkCiko, checkSut, checkKrema, checkCilek, checkElma;
    Button tarifGetir;
    int i = 0;
    int sec = 0;
    String[] secMalzeme = new String[30];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        tarifGetir = (Button) findViewById(R.id.tarifGetir);
        checkYum = (CheckBox) findViewById(R.id.checkYum);
        checkBalik = (CheckBox) findViewById(R.id.checkBalik);
        checkTavuk = (CheckBox) findViewById(R.id.checkTavuk);
        checkEt = (CheckBox) findViewById(R.id.checkEt);
        checkSosis = (CheckBox) findViewById(R.id.checkSosis);
        checkUn = (CheckBox) findViewById(R.id.checkUn);
        checkPirinc = (CheckBox) findViewById(R.id.checkPirinc);
        checkBulgur = (CheckBox) findViewById(R.id.checkBulgur);
        checkYufka = (CheckBox) findViewById(R.id.checkYufka);
        checkIspanak = (CheckBox) findViewById(R.id.checkIspanak);
        checkKabak = (CheckBox) findViewById(R.id.checkKabak);
        checkFasulye = (CheckBox) findViewById(R.id.checkFasulye);
        checkEnginar = (CheckBox) findViewById(R.id.checkEnginar);
        checkBezelye = (CheckBox) findViewById(R.id.checkBezelye);
        checkLahana = (CheckBox) findViewById(R.id.checkLahana);
        checkPatates = (CheckBox) findViewById(R.id.checkPatates);
        checkDomates = (CheckBox) findViewById(R.id.checkDomates);
        checkCiko = (CheckBox) findViewById(R.id.checkCiko);
        checkSut = (CheckBox) findViewById(R.id.checkSut);
        checkKrema = (CheckBox) findViewById(R.id.checkKrema);
        checkCilek = (CheckBox) findViewById(R.id.checkCilek);
        checkElma = (CheckBox) findViewById(R.id.checkElma);


        tarifGetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarifBul();
            }
        });


    }

    private void tarifBul() {


        if (checkYum.isChecked()) {
            //secMalzeme.add("yumurta");
            // String a=new String("yumurta");
            secMalzeme[i] = "yumurta";
            i++;
            sec++;

        }
        if (checkBalik.isChecked()) {
            //secMalzeme.add("balik");
            secMalzeme[i] = "balik";
            i++;
            sec++;

        }
        if (checkTavuk.isChecked()) {
            // secMalzeme.add("tavuk");
            secMalzeme[i] = "tavuk";
            i++;
            sec++;

        }
        if (checkEt.isChecked()) {
            // secMalzeme.add("et");
            secMalzeme[i] = "et";
            i++;
            sec++;
        }
        if (checkSosis.isChecked()) {
            // secMalzeme.add("sosis");
            secMalzeme[i] = "sosis";
            i++;
            sec++;


        }
        if (checkUn.isChecked()) {
            //secMalzeme.add("un");
            secMalzeme[i] = "un";
            i++;
            sec++;
        }
        if (checkPirinc.isChecked()) {
            // secMalzeme.add("pirinc");
            secMalzeme[i] = "pirinc";
            i++;
            sec++;

        }
        if (checkBulgur.isChecked()) {
            // secMalzeme.add("bulgur");
            secMalzeme[i] = "bulgur";
            i++;
            sec++;

        }
        if (checkYufka.isChecked()) {
            //secMalzeme.add("yufka");
            secMalzeme[i] = "yufka";
            i++;
            sec++;

        }
        if (checkIspanak.isChecked()) {
            //secMalzeme.add("ıspanak");
            secMalzeme[i] = "ispanak";
            i++;
            sec++;

        }
        if (checkKabak.isChecked()) {
            // secMalzeme.add("kabak");
            secMalzeme[i] = "kabak";
            i++;
            sec++;

        }
        if (checkFasulye.isChecked()) {
            // secMalzeme.add("fasulye");
            secMalzeme[i] = "fasulye";
            i++;
            sec++;

        }
        if (checkEnginar.isChecked()) {
            //secMalzeme.add("enginar");
            secMalzeme[i] = "enginar";
            i++;
            sec++;

        }
        if (checkBezelye.isChecked()) {
            //secMalzeme.add("bezelye");
            secMalzeme[i] = "bezelye";
            i++;
            sec++;

        }
        if (checkLahana.isChecked()) {
            // secMalzeme.add("lahana");
            secMalzeme[i] = "lahana";
            i++;
            sec++;

        }
        if (checkPatates.isChecked()) {
            // secMalzeme.add("patates");
            secMalzeme[i] = "patates";
            i++;
            sec++;


        }
        if (checkDomates.isChecked()) {
            //secMalzeme.add("domates");
            secMalzeme[i] = "domates";
            i++;
            sec++;

        }
        if (checkCiko.isChecked()) {
            // secMalzeme.add("çikolata");
            secMalzeme[i] = "cikolata";
            i++;
            sec++;

        }
        if (checkSut.isChecked()) {
            // secMalzeme.add("süt");
            secMalzeme[i] = "sut";
            i++;
            sec++;

        }
        if (checkKrema.isChecked()) {
            //secMalzeme.add("krema");
            secMalzeme[i] = "krema";
            i++;
            sec++;

        }
        if (checkCilek.isChecked()) {
            //secMalzeme.add("çilek");
            secMalzeme[i] = "cilek";
            i++;
            sec++;

        }

        if (checkElma.isChecked()) {

            //secMalzeme.add("elma");
            secMalzeme[i] = "elma";
            i++;
            sec++;


        }
        // Toast.makeText(Material.this, " "+secMalzeme[0], Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MalzemeliTarif.class);
        intent.putExtra("secMalzeme", secMalzeme);
        intent.putExtra("sec",i);
        startActivity(intent);


    }
}
