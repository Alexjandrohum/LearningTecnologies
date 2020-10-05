package com.example.apptec.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptec.Api.ObtenerRecursos;
import com.example.apptec.Api.WebServiceApi;
import com.example.apptec.Api.WebServiceJWT;
import com.example.apptec.Fragments.LunesFragment;
import com.example.apptec.Modelos.ModeloLogin;
import com.example.apptec.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logeo extends AppCompatActivity {


    EditText mat,pass;
    Button mandar;

    public static int matricula;
    public static int estado;
    public static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo);

        mandar = findViewById(R.id.iniciar);

            mandar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        try{

            mat = (EditText) findViewById(R.id.matricula);
            pass = (EditText) findViewById(R.id.password);

            matricula = Integer.parseInt(mat.getText().toString());




            ModeloLogin mod = new ModeloLogin();
            mod.setMatricula(matricula);
            mod.setContrasena(pass.getText().toString());
            Call<List<String>> call = WebServiceJWT
                    .getInstance()
                    .createService(WebServiceApi.class)
                    .obtenerToken(mod);

            call.enqueue(new Callback<List<String>>() {
                @Override
                public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                    if (response.code() == 200) {
                        //tokenn = response.body().toString();
                        token = response.body().get(0).toString();
                        Log.d("TAG1", "El token es: " + token);

                        ObtenerRecursos objRecurso = new ObtenerRecursos();
                        objRecurso.obtenerTokenn(token);

                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);


                        // obtenerRecursoPerfil();
                        //obtenerRecursoSemana();
                        //obtenerRecursoDia();

                        estado = 200;


                        LunesFragment lunesFragment = new LunesFragment();
                        lunesFragment.ObtenerToken(token);





                    } else if (response.code() == 404) {
                        Log.d("Tag1", "No autorizado");

                        Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                        mat.setText("");
                        pass.setText("");

                        estado = 401;




                    } else {
                        Log.d("Tag1", "No obtenido Token");
                        Toast.makeText(getApplicationContext(),"Hay problemas estamos trabajando en esto",Toast.LENGTH_SHORT).show();

                        mat.setText("");
                        pass.setText("");

                    }





                }

                @Override
                public void onFailure(Call<List<String>> call, Throwable t) {
                    Log.d("Error: ", "" + t);
                    estado = 500;
                    Toast.makeText(getApplicationContext(),"No hay acceso a internet!",Toast.LENGTH_SHORT).show();


                }




            });









        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Ingresa los datos",Toast.LENGTH_SHORT).show();




        }










    }
});




    }























}