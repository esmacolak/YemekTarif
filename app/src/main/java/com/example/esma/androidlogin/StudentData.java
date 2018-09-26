package com.example.esma.androidlogin;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentData extends Activity{
    public char []dizi;
    public int m,n;
    EditText firstname,lastname,age;
    Button insert,show;
    TextView result,tv_deneme;

    RequestQueue requestQueue;

    String insertUrl= "http://192.168.1.3/dashboard/insertStudent.php";
    String showUrl= "http://192.168.1.3/dashboard/showStudents.php";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_layout);
        tv_deneme=(TextView)findViewById(R.id.tv_deneme);
        firstname = (EditText)findViewById(R.id.firstname);
        lastname =(EditText)findViewById(R.id.lastname);
        age=(EditText)findViewById(R.id.age);
        insert = (Button) findViewById(R.id.insertBtn);
        show = (Button) findViewById(R.id.showBtn);
        result = (TextView)findViewById(R.id.textView2);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tv_deneme.setText(lastname.getText().toString());                ;
                System.out.println("ww");
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        showUrl, (String) null, new Response.Listener<JSONObject>() {
                   @Override
                    public void onResponse(JSONObject response) {
                        System.out.print("----asdcfvbnm---");

                        System.out.println(response.toString());
                        try {
                            System.out.print("-----asdc--");

                            JSONArray students = response.getJSONArray("students");
                            for (int i = 0; i < students.length(); i++) {

                                JSONObject student = students.getJSONObject(i);

                                String firstName = student.getString("firstname");
                                String lastName = student.getString("lastname");
                                String age1 = student.getString("age");

                                System.out.print("-------");




                                result.append( firstName);
                                for(int j=0;j<lastName.length();j++){
                                    if(lastname.getText().charAt(j)==lastName.charAt(j) && lastName.length()==lastname.getText().length()) m=1;

                                    else m=0;
                                }
                                for(int k=0;k<firstName.length();k++){
                                    if(firstname.getText().charAt(k)==firstName.charAt(k) && firstName.length()==firstname.getText().length()) n=1;

                                    else n=0;
                                }

                                if(Integer.parseInt(age.getText().toString()) == Integer.parseInt(age1.toString()) && m==1 &&n==1){
                                    Toast.makeText(StudentData.this, "Login Succesfully", Toast.LENGTH_SHORT).show();


                                }
                                else{
                                    Toast.makeText(StudentData.this, " "+lastName.length(), Toast.LENGTH_SHORT).show();


                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.append(error.getMessage());
                        Toast.makeText(StudentData.this, " "+error.toString(), Toast.LENGTH_SHORT).show();


                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });

       insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(StudentData.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();


                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("firstname",firstname.getText().toString());
                        parameters.put("lastname",lastname.getText().toString());



                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });








    }
}
