package com.example.mypayment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypayment.javavlass.DatePickerFrag;

public class TambahPemasukan extends AppCompatActivity {

    ImageView calender;
    TextView tanggalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pemasukan);

        calender = findViewById(R.id.imageCalender);
        tanggalView = findViewById(R.id.tanggalView);

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilTanggal();
            }
        });


    }
    public void tampilTanggal(){
        DatePickerFrag datePickerFragment = new DatePickerFrag();
        datePickerFragment.show(getSupportFragmentManager(), "data");
        datePickerFragment.setOnDateClickListener(new DatePickerFrag.onDateClickListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String tahun = ""+datePicker.getYear();
                String bulan = ""+(datePicker.getMonth()+1);
                String hari = ""+datePicker.getDayOfMonth();
                String text = hari+" - "+bulan+" - "+tahun;
                tanggalView.setText(text);
            }
        });
    }

    private void saveSQLite(){

    }
}