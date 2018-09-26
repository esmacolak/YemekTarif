package com.example.esma.androidlogin;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class GelenTarif extends AppCompatActivity {
    private TextView textGelTarif,textAd,textKisi,textSure,textKisiSayisi,textPisSuresi,textTarifDet;
    public ArrayList liste = new ArrayList();
    public ArrayList liste2 = new ArrayList();
    public ArrayList liste3 = new ArrayList();


    private static String URL="https://www.nefisyemektarifleri.com/mercimek-corbasi-tarifi/";
    private static String mantarUrl="https://www.nefisyemektarifleri.com/mantar-corbasi-nasil-hazirlanir/";
    private static String sebzeUrl="https://www.nefisyemektarifleri.com/mantar-corbasi-nasil-hazirlanir/";
    private static String ispanakUrl="https://www.nefisyemektarifleri.com/ispanak-yemegi-tarifi/";
    private static String BezUrl="https://www.nefisyemektarifleri.com/patatesli-havuclu-bezelye-yemegi-tarifi/";
    private static String DolmaUrl="https://www.nefisyemektarifleri.com/firinda-zeytinyagli-biber-dolmasi-284529/";
    private static String BiftekUrl="https://www.nefisyemektarifleri.com/soslu-biftek-tarifi/";
    private static String sisUrl="https://www.nefisyemektarifleri.com/soslu-biftek-tarifi/";
    private static String ButUrl="https://www.nefisyemektarifleri.com/firinda-tavuk-but/";
    private static String BuyukUrl="https://www.nefisyemektarifleri.com/firinda-balik-4982728/";
    private static String OmletUrl="https://www.nefisyemektarifleri.com/kahvaltilik-pizza-omlet/";
    private static String EkmekUrl="https://www.nefisyemektarifleri.com/tavada-yumurtali-tost/";
    private static String FırınMakUrl="https://www.nefisyemektarifleri.com/firinda-makarna-besamel-soslu/";
    private static String PestoUrl="https://www.nefisyemektarifleri.com/pesto-soslu-makarna-tavuk-dunyasi-tarifi/";
    private static String PatatesUrl="https://www.nefisyemektarifleri.com/patates-salatasi-tarifi-3/";
    private static String BrokoliUrl="https://www.nefisyemektarifleri.com/zeytinyagli-enfes-brokoli-salatasi-4175248/";
    private static String cakeUrl="https://www.nefisyemektarifleri.com/meyve-soslu-cheesecake-ve-yapim-asamalari/";
    private static String KurabiyeUrl="https://www.nefisyemektarifleri.com/kara-kiz-kurabiyesi-bu-tarif-kacmaz/";


    private ProgressDialog progressDialog;
    Typeface tf1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelen_tarif);
        textGelTarif = (TextView)findViewById(R.id.textGelTarif);
        textKisi = (TextView)findViewById(R.id.textKis);
        textSure = (TextView)findViewById(R.id.textSur);
        textKisiSayisi = (TextView)findViewById(R.id.textKisiSay);
        textTarifDet = (TextView)findViewById(R.id.textTarifDet);


        final String secilen = getIntent().getStringExtra("secilen");

        tf1= Typeface.createFromAsset(getAssets(), "font/macondo.ttf");
        textKisi.setText("KİŞİ SAYISI");
        textKisi.setTypeface(tf1);
        textSure.setText("PİŞİRME SÜRESİ");
        textSure.setTypeface(tf1);

        if(secilen.equals("mercimek")){
            Toast.makeText(this, "mercimek", Toast.LENGTH_SHORT).show();
            new MerVeriGetir().execute();

        }
        if(secilen.equals("sebze")){
            Toast.makeText(this, "sebze", Toast.LENGTH_SHORT).show();
            new SebVeriGetir().execute();

        }if(secilen.equals("mantar")){
            Toast.makeText(this, "sebze", Toast.LENGTH_SHORT).show();
            new ManVeriGetir().execute();
        }
        if(secilen.equals("ispanak")){
            new IspVeriGetir().execute();
        }
        if(secilen.equals("bezelye")){
            new BezVeriGetir().execute();
        }
        if (secilen.equals("dolma")){
            new DolmaVeriGetir().execute();
        }
        if (secilen.equals("biftek")){
            new BifVeriGetir().execute();
        }
        if (secilen.equals("sis")){
            new SisVeriGetir().execute();
        }
        if(secilen.equals("but")){
            new ButVeriGetir().execute();
        }
        if (secilen.equals("buyuk")){
            new BuyukVeriGetir().execute();
        }
        if (secilen.equals("omlet")){
            new OmletVeriGetir().execute();
        }
        if (secilen.equals("ekmek")){
            new EkmekVeriGetir().execute();
        }
        if (secilen.equals("fırınMak")){
            new FırınMakVeriGetir().execute();
        }
        if (secilen.equals("pesto")){
            new PestoVeriGetir().execute();
        }
        if (secilen.equals("patates")){
            new PatatesVeriGetir().execute();
        }
        if (secilen.equals("brokoli")){
            new BrokoliVeriGetir().execute();
        }
        if (secilen.equals("cheeseCake")){
            new CheeseCakeVeriGetir().execute();
        }
        if (secilen.equals("kurabiye")){
            new KurabiyeVeriGetir().execute();
        }




    }
    private class MerVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(URL).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }


    private class SebVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(sebzeUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }



    private class ManVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(mantarUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }


    private class IspVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(ispanakUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class BezVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(BezUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }
    private class DolmaVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(DolmaUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }
    private class BifVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(BiftekUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }
    private class SisVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(sisUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }
    private class ButVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(ButUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class BuyukVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(BuyukUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");




                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }


            progressDialog.dismiss();
        }
    }

    private class OmletVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(OmletUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class EkmekVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(EkmekUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class FırınMakVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(FırınMakUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class PestoVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(PestoUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class PatatesVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(PatatesUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class BrokoliVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(BrokoliUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class CheeseCakeVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(cakeUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }

    private class KurabiyeVeriGetir extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(GelenTarif.this);
            progressDialog.setMessage("Lütfen Bekleyiniz..");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(KurabiyeUrl).timeout(30*1000).get();

                Elements malzeme = doc.select("li[itemprop]");
                Elements kisiSayi =doc.select("span[itemprop]");

                for (int i=0; i<malzeme.size();i++) {

                    liste.add(malzeme.get(i).text());



                }
                liste2.add(kisiSayi.text());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            textKisiSayisi.append(liste2.toString());

            for(int j=0;j<liste.size();j++){
                textGelTarif.append(liste.get(j).toString());
                textGelTarif.append("\n ");


            }

            progressDialog.dismiss();
        }
    }







}
