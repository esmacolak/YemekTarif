package com.example.esma.androidlogin;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MalzemeliTarif extends AppCompatActivity {

    TextView textTarif,textKisi,textSure,textKisiSayisi,textMalzeme,textPisSure,textMalzDetay,textTarifDetay,textYemAd;
    String showUrl = "http://192.168.1.27/dashboard/showYemek.php";
    int a = 0;
    int [] diziIcerik= new int[5];
    int [] dizi2= new int[10];
    int [] diziKisiSayi= new int[10];
    String [] diziSure= new String[10];
    int [] dizi5= new int[10];
    String [] diziMalzDetay= new String[100];
    String [] diziTarif= new String[100];
    String [] diziYemekAd= new String[100];






    String[] malzemeIcerik = new String[300];
    Typeface tf1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malzemeli_tarif);

        textTarif = (TextView) findViewById(R.id.textTarif);
        textKisi = (TextView) findViewById(R.id.textKisi);
        textSure =(TextView) findViewById(R.id.textSure);
        textKisiSayisi = (TextView) findViewById(R.id.textKisiSayisi);
        textPisSure = (TextView) findViewById(R.id.textPisSure);
        textMalzeme = (TextView) findViewById(R.id.textMalzeme);
        textMalzDetay = (TextView) findViewById(R.id.textMalzDetay);
        textTarifDetay = (TextView) findViewById(R.id.textTarifDetay);
        textYemAd = (TextView) findViewById(R.id.textYemAd);


        tf1=Typeface.createFromAsset(getAssets(), "font/macondo.ttf");
        textKisi.setText("KİŞİ SAYISI");
        textKisi.setTypeface(tf1);
        textSure.setText("PİŞİRME SÜRESİ");
        textSure.setTypeface(tf1);
        textMalzeme.setText("MALZEMELER");
        textMalzeme.setTypeface(tf1);
        textTarif.setText("NASIL YAPILIR?");
        textTarif.setTypeface(tf1);


        //final ArrayList<String > secMalzeme =getIntent().getExtras().getStringArrayList("secMalzeme");
        final String[] secMalzeme = getIntent().getStringArrayExtra("secMalzeme");
        final int  sec = getIntent().getExtras().getInt("sec");

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, showUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("json object oluştu");

                try {

                    JSONArray yemek = response.getJSONArray("yemtarif");

                    for (int i = a; i < yemek.length(); i++) {
                        dizi2[i]=i;

                        JSONObject yemTarif = yemek.getJSONObject(i);
                        String yemekAd = (String) yemTarif.get("yemekAd");
                        String malzemeler = yemTarif.getString("malzeme");
                        String malzemeDetay = yemTarif.getString("malzemeDetay");
                        String kisiSayi = yemTarif.getString("kisiSayi");
                        String sure = yemTarif.getString("pisSure");
                        String tarif = yemTarif.getString("tarif");
                        diziMalzDetay[i]=malzemeDetay;
                        diziTarif[i]=tarif;
                        diziKisiSayi[i]=Integer.parseInt(kisiSayi);
                        diziSure[i]=sure;
                        diziYemekAd[i]=yemekAd;
                       // dizi5[i]=Integer.parseInt(tarif);



                        malzemeIcerik = malzemeler.split(",");




                        int sayac=0;
                        for(int k=0;k<malzemeIcerik.length;k++){

                            for(int l=0;l<sec;l++){
                              //  textTarif.append("\n"+malzemeIcerik[k]);

                              //  textTarif.append("---"+secMalzeme[l]);
                                if(malzemeIcerik[k].equals(secMalzeme[l])){
                                    sayac++;

                                    //textTarif.append("\n *** esittt ***  ---- "+secMalzeme[l]);

                                    diziIcerik[i]=sayac;




                                }
                            }


                        }





                    }
                    int en_buyuk=diziIcerik[0];
                    for(int i=0;i<yemek.length();i++)
                    {
                        if(diziIcerik[i]>en_buyuk)en_buyuk=diziIcerik[i];
                    }
                   /* Toast.makeText(MalzemeliTarif.this, ""+diziIcerik[0], Toast.LENGTH_SHORT).show();
                    Toast.makeText(MalzemeliTarif.this, ""+diziIcerik[1], Toast.LENGTH_SHORT).show();
                    Toast.makeText(MalzemeliTarif.this, ""+diziIcerik[2], Toast.LENGTH_SHORT).show();
*/
                    for(int i=0;i<yemek.length(); i++)
                    {
                        if(diziIcerik[i]==en_buyuk)
                        {
                            Toast.makeText(MalzemeliTarif.this, "en yakın tarif bulundu", Toast.LENGTH_SHORT).show();
                            //textTarif.append("kisi sayısı="+dizi3[i]+"sure"+dizi4[i]);
                            textKisiSayisi.setText(" \t \t "+diziKisiSayi[i]);
                            textKisiSayisi.setTypeface(tf1);
                            textPisSure.setText("\t \t "+diziSure[i]);
                            textPisSure.setTypeface(tf1);
                            textMalzDetay.setText(""+diziMalzDetay[i]);
                            textTarifDetay.setText(""+diziTarif[i]);
                            textYemAd.setText(""+diziYemekAd[i]);

                        }
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MalzemeliTarif.this, " " + error.toString(), Toast.LENGTH_LONG).show();
                textTarif.append(error.toString());


            }
        });
        requestQueue.add(jsonObjectRequest);





    }
}
