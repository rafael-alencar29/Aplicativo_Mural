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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class FragmentCadastroEvento7 extends Fragment {
    private ImageView voltaTela;
    private CalendarView calendarView;
    public String date="";
    public FragmentCadastroEvento7Listener cadastroEvento7Listener;

    public interface FragmentCadastroEvento7Listener{
        void onClickTela7(String dataEvento);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_7, container,false);

        calendarView = v.findViewById(R.id.calendario);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                date = i2+"/"+(i1+1)+"/"+i;
            }
        });
        if(date.isEmpty()){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.format(new Date(calendarView.getDate()));
        }
        voltaTela = v.findViewById(R.id.Volta_para_tela_anterior);
        voltaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroEvento7Listener.onClickTela7(date);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento7Listener){
            cadastroEvento7Listener = (FragmentCadastroEvento7Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento7Listener=null;
    }
}