package com.example.aplicativomural;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import com.example.aplicativomural.models.Evento;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;

public class CadastroEvento1 extends AppCompatActivity implements  FragmentCadastroEvento1.FragmentCadastroEventoListener, FragmentCadastroEvento2.FragmentCadastroEvento2Listener,FragmentCadastroEvento3.FragmentCadastroEvento3Listener,FragmentCadastroEvento4.FragmentCadastroEvento4Listener,FragmentCadastroEvento5.FragmentCadastroEvento5Listener,FragmentCadastroEvento6.FragmentCadastroEvento6Listener,FragmentCadastroEvento7.FragmentCadastroEvento7Listener,FragmentCadastroEvento8.FragmentCadastroEvento8Listener,FragmentCadastroEvento9.FragmentCadastroEvento9Listener{
    private Fragment fragment;
    private String tituloEvento,descricaoEvento, categoriaEvento,dataEvento,numeroTelefone,enderecoEvento;
    private boolean temWhatsapp,temTelegram;
    private Uri imagemEvento;
    private int horaEvento,minutoEvento;
    private Intent telaPrincipal;
    public Bitmap imagemEventoCamera;
    public GoogleMap mGoogleMap;
    LocationManager locationManager;
    public Evento evento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Atribuição feita por motivo de teste
        categoriaEvento = "sem categoria";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento1);
        telaPrincipal= new Intent(CadastroEvento1.this, MainActivity.class);

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
    public void onClickTela4(String enderco) {
        enderecoEvento = enderco;
        //Mudança de evento5 para evento6 por motivo de teste
        fragment = new FragmentCadastroEvento6();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
    }

    @Override
    //Pega a categoria do evento e passa para tela de confirmação de criação
    public void onClickTela5(String categoria) {
        categoriaEvento = categoria;
        fragment = new FragmentCadastroEvento7();
        getSupportFragmentManager().beginTransaction().replace(R.id.LinearCadastroEvento,fragment).commit();
        evento.writeEvento(tituloEvento,descricaoEvento, categoriaEvento,dataEvento,numeroTelefone,enderecoEvento,temWhatsapp,temTelegram,imagemEvento,horaEvento,minutoEvento,"2");
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
    public void onClickTela6() {
        CadastroEvento1.this.startActivity(telaPrincipal);
    }
    public void requestMapPermissions() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
    }
    public void requestStoragePermissios() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }


}
