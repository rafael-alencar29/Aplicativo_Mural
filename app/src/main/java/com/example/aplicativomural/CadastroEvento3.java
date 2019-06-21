package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CadastroEvento3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento3);
        //Componentes da tela
        final ImageView telaCadastroEvento4 = findViewById(R.id.Tela_4_cadastro_evento);
        final TextView galeria = (TextView)findViewById(R.id.Galeria);
        final TextView camera = (TextView)findViewById(R.id.Camera);
        //Logida da Tela
        //fotoEvento.setBackgroundColor(Color.rgb(255, 255, 255));//Quando nao tem image coloca fundo branco
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                CropImage.startPickImageActivity(CadastroEvento3.this);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.startPickImageActivity(CadastroEvento3.this);
            }
        });
        telaCadastroEvento4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proximaTela= new Intent(CadastroEvento3.this,CadastroEvento4.class);
                CadastroEvento3.this.startActivity(proximaTela);
            }
        });
    }
    @Override
    @SuppressLint("NewApi")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);
            Log.i("RESPONSE getPath", imageUri.getPath());
            Log.i("RESPONSE getScheme", imageUri.getScheme());
            Log.i("RESPONSE PathSegments", imageUri.getPathSegments().toString());

            //NOW CROP IMAGE URI
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setMultiTouchEnabled(true)
                    //REQUEST COMPRESS SIZE
                    .setRequestedSize(800, 800)
                    //ASPECT RATIO, DELETE IF YOU NEED CROP ANY SIZE
                    .setAspectRatio(1,1)
                    .start(this);
        }


        CropImage.ActivityResult result = CropImage.getActivityResult(data);
        if (resultCode == RESULT_OK) {
            Log.i("RESPONSE getUri", result.getUri().toString());
            ImageView fotoEvento = (ImageView)findViewById(R.id.Foto_evento);
            fotoEvento.setImageURI(result.getUri());
            fotoEvento.setBackgroundColor(Color.parseColor("#A6FFFFFF"));
        }
    }
}

