package com.onedata.camerapermission;

import android.Manifest;
import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE=1000;
    private static final int IMAGE_CAPTURE_CODE=1001;
    Button captureBtn;
    ImageView imageView;
    Uri image_uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
      /*  ActionBar actionBar = getActionBar();
        actionBar.hide();

*/


        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image_view);
        captureBtn=findViewById(R.id.capture_image_btn);
         captureBtn.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.M)
          @Override
          public void onClick(View v) {
              if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
              if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED
              ||checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED)
              {
                  String[] permission={Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                  requestPermissions(permission, PERMISSION_CODE  );
              }
          else{
              openCamera();

              }
          }
          else{
                openCamera();
              }
          }
      });

}
private void openCamera(){
        ContentValues values=new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION,"From the camera");
        image_uri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
        Intent camI=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camI.putExtra(MediaStore.EXTRA_OUTPUT,image_uri);
        startActivityForResult(camI,IMAGE_CAPTURE_CODE);

}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0&& grantResults[0]==
                PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else{
                    Toast.makeText(this,"Permission Denied...",Toast.LENGTH_SHORT).show();
                }
            }
    }
}
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(resultCode== RESULT_OK ){
            imageView.setImageURI(image_uri);
        }
    }}