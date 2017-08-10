package com.example.tico.empresalivingtech;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tico.empresalivingtech.view.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private final static int SPLASH_TIME_OUT = 2500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //Executar alguma regra de negocios
        //enquanto carrega a tela splash
        //-GPS
        //-Ler Preferencia do Usuario
        //-Enviar notificações

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
