package com.example.aplicativomural;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.sql.Time;
import java.util.Objects;

public class FragmentCadastroEvento9 extends Fragment {
    private ImageView voltaTela;
    private EditText editText;
    private String numeroTelefone = "";
    private Switch whatsapp, telegram;
    private boolean tem_whats,tem_telegram;
    public FragmentCadastroEvento9Listener cadastroEvento9Listener;

    public interface FragmentCadastroEvento9Listener{
        void onClickTela9(String numerotelefone,boolean whats,boolean telegram);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_9, container,false);
        editText = v.findViewById(R.id.telefone_evento);
        whatsapp = v.findViewById(R.id.whats);
        telegram = v.findViewById(R.id.telegram);
        voltaTela = v.findViewById(R.id.Volta_para_tela_anterior);

        voltaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroTelefone = editText.getText().toString();
                whatsapp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            tem_whats=true;
                        }else {
                            tem_whats=false;
                        }
                    }
                });
                telegram.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            tem_telegram=true;
                        }else {
                            tem_telegram=false;
                        }
                    }
                });
                if(numeroTelefone.isEmpty()){
                    Toast.makeText(Objects.requireNonNull(getContext()),"Digite o numero de telefone!",Toast.LENGTH_LONG).show();
                }else{
                    //Toast.makeText(Objects.requireNonNull(getContext()),numeroTelefone,Toast.LENGTH_LONG).show();
                    cadastroEvento9Listener.onClickTela9(numeroTelefone,tem_whats,tem_telegram);
                }
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento9Listener){
            cadastroEvento9Listener = (FragmentCadastroEvento9Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento9Listener=null;
    }
}