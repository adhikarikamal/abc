package com.kamal.cemera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private static int CEMERA_REQUEST =123456789;
ImageView imgCaptured;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCapture=findViewById(R.id.btnCapture);
        imgCaptured=findViewById(R.id.imageCaptured);

        btnCapture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
          Intent cemeraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          startActivityForResult(cemeraIntent,CEMERA_REQUEST);
            }
        });
    }
protected void onActivityResult(int requestCode,int resultCode,Intent data){
    super.onActivityResult(requestCode,resultCode,data);
    if (requestCode == CEMERA_REQUEST && resultCode == Activity.RESULT_OK){
        Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgCaptured.setImageBitmap(photo);
    }
}
}