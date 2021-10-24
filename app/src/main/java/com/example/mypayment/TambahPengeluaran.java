package com.example.mypayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypayment.R;
import com.example.mypayment.javavlass.DatabaseHelper;
import com.example.mypayment.javavlass.DatePickerFrag;

public class TambahPengeluaran extends AppCompatActivity {

    private static final String MY_PREFS_NAME = "MyPrefsFile" ;
    ImageView calender;
    TextView tanggalView;
    EditText nominal, keterangan;
    Button button;

    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengeluaran);

        dbhelper = new DatabaseHelper(this);

        calender = findViewById(R.id.imageCalenderPengeluaran);
        tanggalView = findViewById(R.id.pengeluaranTanggal);
        nominal = findViewById(R.id.editTextNominalPengeluaran);
        keterangan = findViewById(R.id.keteranganEditTextPengeluaran);
        button = findViewById(R.id.buttonPengeluran);

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilTanggal();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSQLite();
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
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String prefUsername = prefs.getString("username", "No name defined"); //"No name defined" is the default value.

        String user = prefUsername;
        String statusSt = "pengeluaran";
        String nominalSt = nominal.getText().toString();
        String keteranganSt = keterangan.getText().toString();
        String tanggal = tanggalView.getText().toString();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.clm_user, user);
        values.put(DatabaseHelper.clm_status, statusSt);
        values.put(DatabaseHelper.clm_nominal, nominalSt);
        values.put(DatabaseHelper.clm_keterangan, keteranganSt);
        values.put(DatabaseHelper.clm_tanggal, tanggal);

        if (tanggal.equals("") || nominalSt.equals("") || keteranganSt.equals("")) {
            Toast.makeText(TambahPengeluaran.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else {
            dbhelper.insertData(values);
            Toast.makeText(TambahPengeluaran.this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}