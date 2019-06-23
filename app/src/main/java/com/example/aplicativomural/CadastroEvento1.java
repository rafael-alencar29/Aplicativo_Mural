package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class CadastroEvento1 extends AppCompatActivity implements FragmentCadastroEvento1.FragmentCadastroEventoListener, FragmentCadastroEvento2.FragmentCadastroEvento2Listener,FragmentCadastroEvento3.FragmentCadastroEvento3Listener,FragmentCadastroEvento4.FragmentCadastroEvento4Listener,FragmentCadastroEvento5.FragmentCadastroEvento5Listener,FragmentCadastroEvento6.FragmentCadastroEvento6Listener{
    private Fragment fragment;
    private String tituloEvento,descricaoEvento, categoriaEvento;
    private Uri imagemEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento1);

        fragment = new FragmentCadastroEvento1();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void onClickProximaTela(int A) {
        fragment = new FragmentCadastroEvento2();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }

    @Override
    public void onClickTela2(String titulo, String descricao) {
        tituloEvento = titulo;
        descricaoEvento = descricao;
        fragment = new FragmentCadastroEvento3();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }else{
            requestMapPermissions();
        }
    }
    @Override
    public void onClickTela3(Uri image) {
        imagemEvento = image;
        fragment = new FragmentCadastroEvento4();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    @Override
    public void onClickTela4() {
        fragment = new FragmentCadastroEvento5();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }

    @Override
    public void onClickTela5(String categoria) {
        categoriaEvento = categoria;
        fragment = new FragmentCadastroEvento6();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    @Override
    public void onClickTela6() {
        fragment = new FragmentCadastroEvento1();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    public void requestMapPermissions() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
    }
}
