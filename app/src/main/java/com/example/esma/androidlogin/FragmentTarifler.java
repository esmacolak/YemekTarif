package com.example.esma.androidlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTarifler extends Fragment {
    Button btnCorba,btnSebze,btnTavuk,btnEt,btnYum,btnBalik,btnMak,btnSalata,btnTatli;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tarifler,container,false);

        btnCorba = (Button)rootView.findViewById(R.id.btnCorba);
        btnSebze = (Button)rootView.findViewById(R.id.btnmercimek);
        btnTavuk = (Button)rootView.findViewById(R.id.btnTavuk);
        btnEt = (Button)rootView.findViewById(R.id.btnEt);
        btnYum = (Button)rootView.findViewById(R.id.btnYum);
        btnBalik = (Button)rootView.findViewById(R.id.btnBalik);
        btnMak = (Button)rootView.findViewById(R.id.btnMak);
        btnSalata = (Button)rootView.findViewById(R.id.btnSalata);
        btnTatli = (Button)rootView.findViewById(R.id.btnTatli);

        btnCorba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CorbaActivity.class);
                startActivity(intent);

            }
        });
        btnSebze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SebzeActivity.class);
                startActivity(intent);

            }
        });
        btnEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EtActivity.class);
                startActivity(intent);
            }
        });
        btnTavuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TavukActivity.class);
                startActivity(intent);
            }
        });
        btnYum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),YumurtaActivity.class);
                startActivity(intent);
            }
        });
        btnBalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BalikActivity.class);
                startActivity(intent);
            }
        });
        btnMak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MakarnaActivty.class);
                startActivity(intent);
            }
        });
        btnSalata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SalataActivity.class);
                startActivity(intent);
            }
        });

        btnTatli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TatliActivity.class);
                startActivity(intent);

            }
        });




        return rootView;
    }
}

