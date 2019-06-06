package com.onedata.volleytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.POST, "http://192.168.1.102:8083/setuser", null,
                        new Response.Listener< JSONObject >() {
                            @Override
                            public void onResponse(JSONObject response) {
                    try {
                        t1.setText(response.getString("name"));
                        t2.setText(response.getString("password"));
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        }


                );

               /* {
                    @Override
                    protected Response parseNetworkResponse(NetworkResponse response) {
                        return null;
                    }

                    @Override
                    public int compareTo(Object o) {
                        return 0;
                    }
                };*/ RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonRequest);

            }
        });



    }
}
