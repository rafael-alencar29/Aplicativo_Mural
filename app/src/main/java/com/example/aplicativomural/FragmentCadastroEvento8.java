package com.example.aplicativomural;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Objects;

public class FragmentCadastroEvento8 extends Fragment {
    private ImageView voltaTela;
    private TimePicker timePicker;
    public FragmentCadastroEvento8Listener cadastroEvento8Listener;

    public interface FragmentCadastroEvento8Listener{
        void onClickTela8(int Hora,int Minuto);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_8, container,false);

        timePicker = v.findViewById(R.id.pega_horas);
        timePicker.setIs24HourView(true);
        voltaTela = v.findViewById(R.id.Volta_para_tela_anterior);
        voltaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = timePicker.getMinute();
                int hora = timePicker.getHour();
                //Toast.makeText(Objects.requireNonNull(getContext()),hora+":"+min,Toast.LENGTH_LONG).show();
                cadastroEvento8Listener.onClickTela8(hora,min);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento8Listener){
            cadastroEvento8Listener = (FragmentCadastroEvento8Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento8Listener=null;
    }
}