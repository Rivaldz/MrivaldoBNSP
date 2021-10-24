package com.example.mypayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class Beranda extends AppCompatActivity implements View.OnClickListener{

    ImageButton pemasukan, pengeluaran, cashFLow, pengaturan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        pemasukan = findViewById(R.id.imageButtonPemasukan);
        pengeluaran = findViewById(R.id.imageButtonPengeluran);
        cashFLow = findViewById(R.id.imageButtonCashFlow);
        pengaturan = findViewById(R.id.imageButtonSetting);

        pemasukan.setOnClickListener(this);
        pengeluaran.setOnClickListener(this);
        cashFLow.setOnClickListener(this);
        pengaturan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButtonPemasukan:
                Toast.makeText(getApplicationContext(),"Pemaasukan",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Beranda.this, TambahPemasukan.class));
                break;

            case R.id.imageButtonPengeluran:
                Toast.makeText(getApplicationContext(),"Pengeluaran",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Beranda.this, TambahPengeluaran.class));
                break;

            case R.id.imageButtonCashFlow:
                Toast.makeText(getApplicationContext(),"Detail Cash Flow",Toast.LENGTH_SHORT).show();

                break;
            case R.id.imageButtonSetting:
                Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}