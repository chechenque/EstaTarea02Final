package com.example.zamor.tarea02final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Reproductor2Activity extends AppCompatActivity {
    MediaPlayer rola2;
    ImageView atras;
    ImageView iniciar;
    ImageView pausar;
    ImageView siguiente;
    ImageView flecha;
    ImageView repetir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor2);

        rola2 = MediaPlayer.create(this, R.raw.rola2);


        atras = (ImageView) findViewById(R.id.atras);
        iniciar = (ImageView) findViewById(R.id.iniciar);
        pausar = (ImageView) findViewById(R.id.pausar);
        siguiente = (ImageView) findViewById(R.id.siguiente);
        flecha = (ImageView) findViewById(R.id.flecha);
        repetir = (ImageView) findViewById(R.id.repetir);

        if(savedInstanceState == null){
            rola2.start();
        }else{
            int seg = savedInstanceState.getInt("guardado");
            rola2.seekTo(seg);
            rola2.start();
        }

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola2.start();
            }
        });

        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola2.pause();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor2Activity.this, Reproductor.class);
                rola2.stop();
                startActivity(intent);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor2Activity.this, Reproductor3.class);
                rola2.stop();
                startActivity(intent);
            }
        });

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor2Activity.this, MainActivity.class);
                rola2.stop();
                startActivity(intent);
            }
        });

        repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola2.stop();
                rola2.start();
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        int guardado = rola2.getCurrentPosition();
        outState.putInt("guardado",guardado);
        super.onSaveInstanceState(outState);
    }

    public void onPause() {
        rola2.stop();
        super.onPause();
    }
}