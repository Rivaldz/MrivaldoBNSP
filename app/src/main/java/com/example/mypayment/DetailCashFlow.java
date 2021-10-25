package com.example.mypayment;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.mypayment.javavlass.CourseModal;
import com.example.mypayment.javavlass.CustomCursorAdapter;
import com.example.mypayment.javavlass.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetailCashFlow extends AppCompatActivity {
    ListView listView;
    LayoutInflater layoutInflater;
    ImageView imageView;
    Button kemabli;
    protected int status ;

    private ArrayList<CourseModal> courseModalArrayList;
    DatabaseHelper databaseHelper;
    private CustomCursorAdapter courseRVAdapter;
    private RecyclerView coursesRV;

//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cash_flow);

        courseModalArrayList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(DetailCashFlow.this);

        courseModalArrayList = databaseHelper.readCourses();

        courseRVAdapter = new CustomCursorAdapter(courseModalArrayList, DetailCashFlow.this);
        coursesRV = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DetailCashFlow.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        coursesRV.setAdapter(courseRVAdapter);

//        databaseHelper = new DatabaseHelper(this);
//        ArrayList<HashMap<String, String>> userList = databaseHelper.GetDetailFlow();
////        imageView = findViewById(R.id.imageView3);
//        ImageView imageArrow = findViewById(R.id.imageView_row_data);

//        Drawable mDrawable = ContextCompat.getDrawable(DetailCashFlow.this,R.drawable.ic_baseline_arrow_back_24);
//        mDrawable.setColorFilter(new
//                PorterDuffColorFilter(0xff2196F3, PorterDuff.Mode.SRC_IN));

//        listView = findViewById(R.id.list_data);
//        ListAdapter adapter = new SimpleAdapter(DetailCashFlow.this, userList, R.layout.row_data,
//                new String[]{"Nominal","Keterangan","Tanggal","Status"},
//                new int[]{R.id.nominal_row_data, R.id.deskripsi_row_data, R.id.tanggal_row_data, status});

//        if (status == 0){
//            imageArrow.setImageResource(R.drawable.ic_baseline_arrow_back_24);
//        }else{
//            imageArrow.setImageResource(R.drawable.ic_baseline_arrow_back_25);
//        }
//        listView.setAdapter(adapter);
//
//        System.out.println("ini status " + status);

    }

//    public void setListView(){
//        Cursor cursor = databaseHelper.allData();
//        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor, 1);
//        listView.setAdapter(customCursorAdapter);
//    }
}