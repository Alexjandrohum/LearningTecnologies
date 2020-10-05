package com.example.almacenamientoexternosd;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText, editText_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edtxt_nombre);
        editText_content = (EditText)findViewById(R.id.editText2);
    }

    public void Guardar(View view){
        String nombre =  editText.getText().toString();
        String contenido = editText_content.getText().toString();

        try{

            File tarjetSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjetSD.getPath(),Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetSD.getPath(), nombre);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();

            Toast.makeText(this, "Guardado correctamente.", Toast.LENGTH_SHORT).show();
            editText.setText("");
            editText_content.setText("");

        }catch (Exception e){
            Toast.makeText(this, "No se ha podido guardar el archivo", Toast.LENGTH_SHORT).show();

        }
    }

    public void COnsultar(View view){
        String nombre = editText.getText().toString();

        try{

            File tarjetaSD =  Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerArchivo = new  BufferedReader(abrirArchivo);
            String linea =  leerArchivo.readLine();
            String contenidoCompleto = "";

            while ( linea != null){
                contenidoCompleto = contenidoCompleto + linea+ "\n";
                linea = leerArchivo.readLine();
            }

            leerArchivo.close();
            abrirArchivo.close();
            editText_content.setText(contenidoCompleto);

        }catch(Exception e){
            Toast.makeText(this, "No se pudo leer el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}
