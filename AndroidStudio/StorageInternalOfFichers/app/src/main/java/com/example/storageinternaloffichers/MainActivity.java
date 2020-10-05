package com.example.storageinternaloffichers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText3);
        String archivos [] = fileList();

        if (ArchivoExiste(archivos, "Bitacora.txt")){
            try{
                InputStreamReader archivo = new InputStreamReader(openFileInput("Bitacora.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String BitacoraCompleta = "";

                while (linea != null){
                    BitacoraCompleta = BitacoraCompleta + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                editText.setText(BitacoraCompleta);

            }catch (IOException e){

            }
        }
    }

    private boolean ArchivoExiste(String archivos [], String NombreArchivo){
        for (int i = 0; i < archivos.length; i++)
            if (NombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }

    public void Guardar(View view){
        try{

            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("Bitacora.txt", Activity.MODE_PRIVATE));
            archivo.write(editText.getText().toString());
            archivo.flush();
            archivo.close();


        }catch (IOException e){

        }

        Toast.makeText(this,"Bitacora guardada correctamente",Toast.LENGTH_LONG).show();
        finish();
    }
}
