package com.example.derysudrajat.appsbbi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RiwayatQuizActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riwayat_quiz);
        RecyclerView recyclerView = findViewById(R.id.mainRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<Rwayat> rwayats = new ArrayList<>();
        rwayats.add(new Rwayat("1","9","Hard",1));
        rwayats.add(new Rwayat("9","1","Hard",9));
        rwayats.add(new Rwayat("6","4","Hard",6));
        RiwayatAdapter riwayatAdapter =  new RiwayatAdapter(this, rwayats);
        recyclerView.setAdapter(riwayatAdapter);
    }
}
