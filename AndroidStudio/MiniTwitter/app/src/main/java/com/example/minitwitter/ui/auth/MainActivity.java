package com.example.minitwitter.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.common.SharedPreferencesManager;
import com.example.minitwitter.retrofit.MiniTwitterClient;
import com.example.minitwitter.retrofit.MiniTwitterService;
import com.example.minitwitter.retrofit.request.RequestLogin;
import com.example.minitwitter.retrofit.response.ResponseAuth;
import com.example.minitwitter.ui.tweet.DashboardActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editcorreo, editPass;
    MiniTwitterService miniTwitterService;
    MiniTwitterClient miniTwitterClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();

        retrofitInit();

        editcorreo = findViewById(R.id.editTextCorreo);
        editPass = findViewById(R.id.editTextPassword);


    }

    public void retrofitInit(){
        miniTwitterClient = MiniTwitterClient.getInstance();
        miniTwitterService = miniTwitterClient.getMiniTwitterService();
    }



    public void onToLogin(View view){
        String date_correo = editcorreo.getText().toString();
        String date_password = editPass.getText().toString();

        if (date_correo.isEmpty()){
            editcorreo.setError("El email es requerido");
        }else if (date_password.isEmpty()){
            editPass.setError("La contraseña es requerida");
        }else{
            RequestLogin requestLogin = new RequestLogin(date_correo, date_password);

            Call<ResponseAuth> call = miniTwitterService.doLogin(requestLogin);
            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if (response.isSuccessful()){
                        //Toast.makeText(getApplicationContext(),"Inicio de sesión correctamente", Toast.LENGTH_LONG).show();

                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_TOKEN, response.body().getToken());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_USERNAME, response.body().getUsername());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_EMAIL, response.body().getEmail());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_PHOTOURL, response.body().getPhotoUrl());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_CREATE, response.body().getCreated());
                        SharedPreferencesManager.setSomeBooleanValue(Constantes.PREF_ACTIVE, response.body().getActive());

                        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(i);

                        //Destruimos la actividad para que no se pueda acceder a ella regresando
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Algo fue mal, recibe sus datos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error en la conexión, intentelo de nuevo", Toast.LENGTH_LONG).show();

                }
            });
        }




    }

    public void Registro(View view){

        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);

    }
}
