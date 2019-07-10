package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

public class CadastroEvento1 extends AppCompatActivity implements  FragmentCadastroEvento1.FragmentCadastroEventoListener, FragmentCadastroEvento2.FragmentCadastroEvento2Listener,FragmentCadastroEvento3.FragmentCadastroEvento3Listener,FragmentCadastroEvento4.FragmentCadastroEvento4Listener,FragmentCadastroEvento5.FragmentCadastroEvento5Listener,FragmentCadastroEvento6.FragmentCadastroEvento6Listener,FragmentCadastroEvento7.FragmentCadastroEvento7Listener,FragmentCadastroEvento8.FragmentCadastroEvento8Listener,FragmentCadastroEvento9.FragmentCadastroEvento9Listener{
    private Fragment fragment;
    private String tituloEvento,descricaoEvento, categoriaEvento,dataEvento,numeroTelefone;
    private boolean temWhatsapp,temTelegram;
    private Uri imagemEvento;
    private int horaEvento,minutoEvento;
    public Bitmap imagemEventoCamera;
    LocationManager locationManager;

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
    //Vai para tela de titulo e descrição do evento
    public void onClickProximaTela(int A) {
        fragment = new FragmentCadastroEvento2();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }

    @Override
    //Pela o titulo e descrição do evento e cai para proxima tela
    public void onClickTela2(String titulo, String descricao) {
        tituloEvento = titulo;
        descricaoEvento = descricao;
        fragment = new FragmentCadastroEvento3();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestStoragePermissios();
        }
    }
    @Override
    //Pega a imagem do evento e passa para proxima tela (image para foto selecionada da galeria, e image1 para foto tirada com a camera)
    public void onClickTela3(String Tipo, Uri image, Bitmap image1) {
        imagemEvento = image;
        imagemEventoCamera = image1;
        fragment = new FragmentCadastroEvento4();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestMapPermissions();
        }
    }
    @Override
    //Pega o endereço(ainda não terminado, não consegue retornar o endereço, apenas a latitude e longitude) e passa para tela de categoria do evento
    public void onClickTela4() {
        fragment = new FragmentCadastroEvento5();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }

    @Override
    //Pega a categoria do evento e passa para tela de confirmação de criação
    public void onClickTela5(String categoria) {
        categoriaEvento = categoria;
        fragment = new FragmentCadastroEvento7();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
        //Fazer o push das informações para o FireBase aqui
    }
    @Override
    public void onClickTela7(String date) {
        dataEvento = date;
        fragment = new FragmentCadastroEvento8();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    @Override
    public void onClickTela8(int Hora,int Minuto) {
        horaEvento = Hora;
        minutoEvento = Minuto;
        fragment = new FragmentCadastroEvento9();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    @Override
    public void onClickTela9(String numerotelefone,boolean whats,boolean telegram) {
        temTelegram = telegram;
        temWhatsapp = whats;
        numeroTelefone =numerotelefone;
        fragment = new FragmentCadastroEvento6();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    @Override
    //Confirma que o evento foi criado e volta para tela principal(Tela show evento)
    public void onClickTela6() {
        fragment = new FragmentCadastroEvento1();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }
    public void requestMapPermissions() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
    }
    public void requestStoragePermissios() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }
}
