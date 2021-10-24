package com.example.mypayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.mypayment.javavlass.CustomCursorAdapter;
import com.example.mypayment.javavlass.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetailCashFlow extends AppCompatActivity {
    ListView listView;
    DatabaseHelper databaseHelper;
    LayoutInflater layoutInflater;
    ImageView imageView;
    Button kemabli;

//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cash_flow);
        databaseHelper = new DatabaseHelper(this);
        ArrayList<HashMap<String, String>> userList = databaseHelper.GetDetailFlow();
        imageView = findViewById(R.id.imageView3);

        listView = findViewById(R.id.list_data);
        ListAdapter adapter = new SimpleAdapter(DetailCashFlow.this, userList, R.layout.row_data,
                new String[]{"Nominal","Keterangan","Tanggal"},
                new int[]{R.id.nominal_row_data, R.id.deskripsi_row_data, R.id.tanggal_row_data});
        listView.setAdapter(adapter);

    }

    public void setListView(){
        Cursor cursor = databaseHelper.allData();
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor, 1);
        listView.setAdapter(customCursorAdapter);
    }
}