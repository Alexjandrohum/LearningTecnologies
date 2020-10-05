package com.example.listviewandeventslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<String> androidVersionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Conectar nuestro listView (lista) al componente visual.
        // a traves dela id
        lista = findViewById(R.id.listView);

        // 2. Cargar la lista de elementos
        androidVersionList = new ArrayList<>();
        androidVersionList.add("Pie");
        androidVersionList.add("Oreo");
        androidVersionList.add("Nougat");
        androidVersionList.add("Marshmallow");
        androidVersionList.add("Lollipop");
        androidVersionList.add("kitkat");
        androidVersionList.add("...");

        // 3. Adaptador
        ArrayAdapter adaptadorVersionesAndroid = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                androidVersionList
        );

        // 4. Vinculación de listView - Adapter
        lista.setAdapter(adaptadorVersionesAndroid);

        setTitle("Versiones Android");

        // 5. Gestion de evento click en la lista
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String AndroidVersion = androidVersionList.get(position);
        Toast.makeText(getApplicationContext(),AndroidVersion, Toast.LENGTH_SHORT).show();
    }
}
