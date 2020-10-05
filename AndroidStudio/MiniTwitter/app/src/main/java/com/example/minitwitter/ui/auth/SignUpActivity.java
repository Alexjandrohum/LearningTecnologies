package com.example.minitwitter.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.common.SharedPreferencesManager;
import com.example.minitwitter.retrofit.MiniTwitterClient;
import com.example.minitwitter.retrofit.MiniTwitterService;
import com.example.minitwitter.retrofit.request.ResquestSignUp;
import com.example.minitwitter.retrofit.response.ResponseAuth;
import com.example.minitwitter.ui.tweet.DashboardActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    TextView txtIniciar;
    EditText editTextUser, editTextContra, editTextEmail;
    MiniTwitterClient miniTwitterClient;
    MiniTwitterService miniTwitterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        txtIniciar = findViewById(R.id.textViewIniciar);

        editTextUser = findViewById(R.id.editTextUser);
        editTextContra = findViewById(R.id.editTextContra);
        editTextEmail = findViewById(R.id.editTextEmail);

        retrofitInit();
    }




    private void retrofitInit() {
        miniTwitterClient = MiniTwitterClient.getInstance();
        miniTwitterService = miniTwitterClient.getMiniTwitterService();


    }





    public void onInicio(View view){
        Intent intent_inicio = new Intent(this, MainActivity.class);
        startActivity(intent_inicio);
    }


    public void onRegistro(View view){
        String user = editTextUser.getText().toString();
        String contra = editTextContra.getText().toString();
        String email = editTextEmail.getText().toString();

        if (user.isEmpty()){
            editTextUser.setError("El nombre de usuario es requerido");
        }else if (email.isEmpty()){
            editTextEmail.setError("El email es requerido");
        }else if(contra.isEmpty()){
            editTextContra.setError("La contraseña es requerida");
        }else{
            String code = "UDEMYANDROID";
            ResquestSignUp resquestSignUp = new ResquestSignUp(user, email, contra, code);
            Call<ResponseAuth> call = miniTwitterService.doSignUp(resquestSignUp);

            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if (response.isSuccessful()){

                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_TOKEN, response.body().getToken());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_USERNAME, response.body().getUsername());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_EMAIL, response.body().getEmail());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_PHOTOURL, response.body().getPhotoUrl());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_CREATE, response.body().getCreated());
                        SharedPreferencesManager.setSomeBooleanValue(Constantes.PREF_ACTIVE, response.body().getActive());

                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(SignUpActivity.this, "Verifique sus datos.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error en la ocnexión", Toast.LENGTH_LONG).show();

                }
            });
        }


    }
}
