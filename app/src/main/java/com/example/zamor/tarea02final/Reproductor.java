package com.example.zamor.tarea02final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Reproductor extends AppCompatActivity {
    MediaPlayer rola1;
    ImageView atras;
    ImageView iniciar;
    ImageView pausar;
    ImageView siguiente;
    ImageView flecha;
    ImageView repetir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);


        rola1 = MediaPlayer.create(this, R.raw.rola1);
        atras = (ImageView) findViewById(R.id.atras);
        iniciar = (ImageView) findViewById(R.id.iniciar);
        pausar = (ImageView) findViewById(R.id.pausar);
        siguiente = (ImageView) findViewById(R.id.siguiente);
        flecha = (ImageView) findViewById(R.id.flecha);
        repetir = (ImageView) findViewById(R.id.repetir);

        if(savedInstanceState == null){
            rola1.start();
        }else{
            int seg = savedInstanceState.getInt("guardado");
            rola1.seekTo(seg);
            rola1.start();
        }

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola1.start();
            }
        });

        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola1.pause();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor.this,Reproductor3.class);
                rola1.stop();
                startActivity(intent);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor.this,Reproductor2Activity.class);
                rola1.stop();
                startActivity(intent);
            }
        });

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor.this, MainActivity.class);
                rola1.stop();
                startActivity(intent);
            }
        });

        repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola1.stop();
                rola1.start();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        int guardado = rola1.getCurrentPosition();
        outState.putInt("guardado",guardado);
        super.onSaveInstanceState(outState);
    }

    public void onPause() {
        rola1.stop();
        super.onPause();
    }
}