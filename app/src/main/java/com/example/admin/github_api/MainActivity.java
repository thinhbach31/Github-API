package com.example.admin.github_api;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JSONReader.onLoadDataFinishedListener {

    private static final String URL_GITHUB_API = "https://api.github.com/users/google/repos";
    private RecyclerView mRecyclerView;
    private GitAdapter mAdapter;
    private Button mButtonShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_JsonRecycler);
        mButtonShow = findViewById(R.id.buttonShow);
        mButtonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONReader(MainActivity.this).execute(URL_GITHUB_API);
            }
        });
    }

    @Override
    public void onLoadData(ArrayList<Data> data) {
        mAdapter = new GitAdapter(data, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
