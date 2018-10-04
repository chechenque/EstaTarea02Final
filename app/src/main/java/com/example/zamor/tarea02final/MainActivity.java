package com.example.zamor.tarea02final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lista);

        String[] canciones = new String[3];
        canciones[0] = "Instrumental";
        canciones[1] = "Salsa";
        canciones[2] = "Rock";

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, canciones);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,Reproductor.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent2 = new Intent(MainActivity.this,Reproductor2Activity.class);
                        startActivity(intent2);
                        break;

                    case 2:
                        Intent intent3 = new Intent(MainActivity.this,Reproductor3.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }
}
