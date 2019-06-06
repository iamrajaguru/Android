package com.onedata.kicka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
   TextView e1,e2;
    Button btn;

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
                Toast.makeText(getApplicationContext(),"Entry",Toast.LENGTH_SHORT).show();
                jsonparse();
            }
        });

    }
    private void jsonparse(){
        String url="https://api.myjson.com/bins/v90jj";
        Toast.makeText(getApplicationContext(),"Entry2",Toast.LENGTH_SHORT).show();
        JsonObjectRequest jor=new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    try {
                        e1.setText(response.getString("name"));
                        e2.setText(response.getString("id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                /*catch(JSONException e){
                    e.printStackTrace();*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }


    });

    }
}
