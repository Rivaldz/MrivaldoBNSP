package com.example.mypayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pengaturan extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPrefsFile" ;
    EditText passLama, passBaru;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        passBaru = findViewById(R.id.editTextPassBaru);
        passLama = findViewById(R.id.editTextPassLama);
        simpan  = findViewById(R.id.buttonSimpanPengaturan);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//        String prefUsername = prefs.getString("username", "No name defined"); //"No name defined" is the default value.
        final String prefPassword = prefs.getString("password", "user"); //"No name defined" is the default value.

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passLama.getText().toString().equalsIgnoreCase(prefPassword)){
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("username", "user");
                    editor.putString("password", passBaru.getText().toString());
                    editor.apply();

                }else{
                    Toast.makeText(getBaseContext(), "Password tidak sama",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}