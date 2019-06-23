package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentCadastroEvento3 extends Fragment {
    private ImageView fotoEvento;
    private FragmentCadastroEvento3Listener cadastroEvento3Listener = null;
    public  Uri image;
    private static final int GALLERY_REQUEST_CODE = 1;

    public interface FragmentCadastroEvento3Listener{
        void onClickTela3(Uri image);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_3, container,false);
        //Componentes do fragment
        ImageView proximaTela = v.findViewById(R.id.Vai_para_fragment_4);
        fotoEvento = v.findViewById(R.id.Foto_evento);
        fotoEvento.setBackgroundColor(Color.parseColor("#A6FFFFFF"));
        final TextView galeria = v.findViewById(R.id.Galeria);
        final TextView camera = v.findViewById(R.id.Camera);

        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fotoEvento.getDrawable() == null){
                    Toast.makeText(Objects.requireNonNull(getContext()),"Selecione uma imagem",Toast.LENGTH_LONG).show();
                }else{
                    cadastroEvento3Listener.onClickTela3(image);
                }
            }
        });
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                pickFromGallery();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFromGallery();
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento3Listener){
            cadastroEvento3Listener = (FragmentCadastroEvento3Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento3Listener=null;
    }
    private void pickFromGallery(){
        //Create an Intent with action as ACTION_PICK
        Intent intent=new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        // Launching the Intent
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK) switch (requestCode) {
            case GALLERY_REQUEST_CODE:
                //data.getData returns the content URI for the selected Image
                image = data.getData();
                fotoEvento.setImageURI(data.getData());
                break;
        }

    }
}
