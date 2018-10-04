package com.example.zamor.tarea02final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Reproductor3 extends AppCompatActivity {
    MediaPlayer rola3;
    ImageView atras;
    ImageView iniciar;
    ImageView pausar;
    ImageView siguiente;
    ImageView flecha;
    ImageView repetir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor3);

        rola3 = MediaPlayer.create(this, R.raw.rola3);
        atras = (ImageView) findViewById(R.id.atras);
        iniciar = (ImageView) findViewById(R.id.iniciar);
        pausar = (ImageView) findViewById(R.id.pausar);
        siguiente = (ImageView) findViewById(R.id.siguiente);
        flecha = (ImageView) findViewById(R.id.flecha);
        repetir = (ImageView) findViewById(R.id.repetir);

        if(savedInstanceState == null){
            rola3.start();
        }else{
            int seg = savedInstanceState.getInt("guardado");
            rola3.seekTo(seg);
            rola3.start();
        }

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola3.start();
            }
        });

        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola3.pause();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor3.this, Reproductor2Activity.class);
                rola3.stop();
                startActivity(intent);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor3.this, Reproductor.class);
                rola3.stop();
                startActivity(intent);
            }
        });

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reproductor3.this,MainActivity.class);
                rola3.stop();
                startActivity(intent);
            }
        });

        repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rola3.stop();
                rola3.start();
                rola3.start();
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        int guardado = rola3.getCurrentPosition();
        outState.putInt("guardado",guardado);
        super.onSaveInstanceState(outState);
    }

    public void onPause() {
        rola3.stop();
        super.onPause();
    }
}