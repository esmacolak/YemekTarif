package com.example.esma.androidlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class FragmentMaterial extends Fragment {
    CheckBox checkYum, checkBalik, checkTavuk, checkEt, checkSosis, checkUn, checkPirinc, checkBulgur, checkYufka, checkIspanak, checkKabak, checkFasulye, checkEnginar, checkBezelye, checkLahana, checkPatates, checkDomates, checkCiko, checkSut, checkKrema, checkCilek, checkElma;
    Button tarifGetir;
    int i = 0;
    int sec = 0;
    String[] secMalzeme = new String[30];
    FragmentMaterial context=this;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_material,container,false);

        tarifGetir = (Button)  rootView.findViewById(R.id.tarifGetir);
        checkYum = (CheckBox) rootView.findViewById(R.id.checkYum);
        checkBalik = (CheckBox) rootView.findViewById(R.id.checkBalik);
        checkTavuk = (CheckBox) rootView.findViewById(R.id.checkTavuk);
        checkEt = (CheckBox) rootView.findViewById(R.id.checkEt);
        checkSosis = (CheckBox) rootView.findViewById(R.id.checkSosis);
        checkUn = (CheckBox) rootView.findViewById(R.id.checkUn);
        checkPirinc = (CheckBox) rootView.findViewById(R.id.checkPirinc);
        checkBulgur = (CheckBox) rootView.findViewById(R.id.checkBulgur);
        checkYufka = (CheckBox) rootView.findViewById(R.id.checkYufka);
        checkIspanak = (CheckBox) rootView.findViewById(R.id.checkIspanak);
        checkKabak = (CheckBox) rootView.findViewById(R.id.checkKabak);
        checkFasulye = (CheckBox) rootView.findViewById(R.id.checkFasulye);
        checkEnginar = (CheckBox) rootView.findViewById(R.id.checkEnginar);
        checkBezelye = (CheckBox) rootView.findViewById(R.id.checkBezelye);
        checkLahana = (CheckBox) rootView.findViewById(R.id.checkLahana);
        checkPatates = (CheckBox) rootView.findViewById(R.id.checkPatates);
        checkDomates = (CheckBox) rootView.findViewById(R.id.checkDomates);
        checkCiko = (CheckBox) rootView.findViewById(R.id.checkCiko);
        checkSut = (CheckBox) rootView.findViewById(R.id.checkSut);
        checkKrema = (CheckBox) rootView.findViewById(R.id.checkKrema);
        checkCilek = (CheckBox) rootView.findViewById(R.id.checkCilek);
        checkElma = (CheckBox) rootView.findViewById(R.id.checkElma);


        tarifGetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarifBul();
            }
        });

        return rootView;




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

        Intent intent = new Intent(getActivity(), MalzemeliTarif.class);
        intent.putExtra("secMalzeme", secMalzeme);
        intent.putExtra("sec",i);
        startActivity(intent);

    }



}

