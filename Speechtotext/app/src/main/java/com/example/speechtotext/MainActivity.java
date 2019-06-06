package com.example.speechtotext;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=(TextView)findViewById(R.id.tvResult);
    }

    public void getSpeechOut(View view) {
        Intent in = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        in.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        in.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        if(in.resolveActivity(getPackageManager())!=null){
            startActivityForResult(in,20);
        }
        else {
            Toast.makeText(getApplicationContext(), "Your device not supported", Toast.LENGTH_SHORT).show();
        }
        }

        protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch(requestCode){
            case 20:
                if(resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tvResult.setText(result.get(0));
                    String save=result.get(0).toString();
                    Save in;
                    in=new Save(save);
                    saveData(in);
                }
                break;
        }
    }

    private void saveData(Save in) {


        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=database.getReference();
        myref.push().setValue(in);
    }
}
