package com.example.mypayment;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
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

    private ArrayList<CourseModal> courseModalArrayList;
    DatabaseHelper databaseHelper;
    private CustomCursorAdapter courseRVAdapter;
    private RecyclerView coursesRV;

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


    }

}