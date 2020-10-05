package com.example.webview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);

        //SharedPreferences preferences = getSharedPreferences("dato", Context.MODE_PRIVATE);

        //editText.setText(preferences.getString("key", ""));
    }

    public void ir(View view){
     Intent intent = new Intent(this, ActivityWeb.class);
     intent.putExtra("url", editText.getText().toString());
     startActivity(intent);

        /*SharedPreferences preferences =  getSharedPreferences("dato", Context.MODE_PRIVATE);
        SharedPreferences.Editor ObjEditor = preferences.edit();
        ObjEditor.putString("key",editText.getText().toString());
        ObjEditor.commit();
        finish();*/
    }
}
