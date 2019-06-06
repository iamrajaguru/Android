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
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
   TextView e1,e2;
    Button btn;
    String url="http://192.168.1.102:8083/setuser";

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

                jsonparse();
            }
        });

    }
    private void jsonparse(){

      /*  Toast.makeText(getApplicationContext(),"Entry2",Toast.LENGTH_SHORT).show();*/
        JsonRequest<JSONObject> jsonRequest=new JsonRequest(Request.Method.POST, "http://192.168.1.102:8083/setuser", null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),"Entry",Toast.LENGTH_SHORT).show();
                try {
                    e1.setText(response.getString("name"));
                    e2.setText(response.getString("password"));
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }},
                            new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
        });
                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonRequest);




    }
}

