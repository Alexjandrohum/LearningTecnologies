package com.example.appreciclercontraint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esta línea de comando es para poder quitar el toolbar de la activity
        getSupportActionBar().hide();
    }

    public void Iniciar(View view){
        Intent intent = new Intent(this,NotasActivity.class);
        startActivity(intent);
    }
}
