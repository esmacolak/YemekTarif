package com.example.esma.androidlogin;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ListView list;
    private Button getir;
    private TextView text;
    public ArrayList liste = new ArrayList();
    private ArrayAdapter<String> adapter;
    private static String URL="https://www.nefisyemektarifleri.com/firinda-soslu-tavuk-4989209/";

    private ProgressDialog progressDialog;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        //list = (ListView) findViewById(R.id.list);
        getir = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.textGel);
        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,liste);

        getir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new VeriGetir().execute();
            }
        });








    }
    private class VeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(Main2Activity.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(URL).timeout(30*1000).get();

                Elements oyunAdi = doc.select("li[itemprop]");

                for (int i=0; i<oyunAdi.size();i++) {

                    liste.add(oyunAdi.get(i).text());


                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);

            //list.setAdapter(adapter);
            for(int j=0;j<liste.size();j++){
                text.append(liste.get(j).toString());
                text.append("\n ");


            }


            progressDialog.dismiss();
        }
    }




}
