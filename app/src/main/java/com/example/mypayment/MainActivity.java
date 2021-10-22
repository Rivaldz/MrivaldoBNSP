package com.example.mypayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPrefsFile" ;
    EditText username, password;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username    = findViewById(R.id.usernameID);
        password    = findViewById(R.id.passwordId);
        loginButton = findViewById(R.id.button);

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("username", "user");
        editor.putString("password", "user");
        editor.apply();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameSt = username.getText().toString();
                String passwordSt = password.getText().toString();

                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String prefUsername = prefs.getString("username", "No name defined"); //"No name defined" is the default value.
                String prefPassword = prefs.getString("password", "No name defined"); //"No name defined" is the default value.

                if (usernameSt.equalsIgnoreCase(prefUsername) && passwordSt.equalsIgnoreCase(prefPassword)){
                   startActivity(new Intent(MainActivity.this,Beranda.class));
                }else{
                    Toast.makeText(getBaseContext(),"Username atau Password Salah",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}