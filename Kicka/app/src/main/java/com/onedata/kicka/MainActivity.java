package com.onedata.kicka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
   TextView e1,e2;
    Button btn;
    String url="http://192.168.0.154/Guru/hello.php";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.textView);
        e2=findViewById(R.id.textView2);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                requestQueue=Volley.newRequestQueue(MainActivity.this);
                StringRequest Req=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        e1.setText(response);
                        requestQueue.stop();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                        e1.setText("Something went wrong");
                    }
                });

                }

               /* jsonparse();*/

        });

    }
  /*  private void jsonparse(){

         JSONObject obj=new JSONObject();

        try {
            obj.put("name","venkat");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        *//*  Toast.makeText(getApplicationContext(),"Entry2",Toast.LENGTH_SHORT).show();*//*
        JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.POST, "http:// 192.168.0.154:8080/seto", obj,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    e1.setText(response.getString("name"));
                   // e2.setText(response.getString("password"));
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }},
                            new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(),error.toString()+"Entry2",Toast.LENGTH_SHORT).show();
                        }
        });

                    requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonRequest);




    }*/
}

