package com.example.derysudrajat.appsbbi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RiwayatScoreFragment2 extends AppCompatActivity {
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        final ArrayList<Rwayat> rwayats = new ArrayList<>();
        rwayats.add(new Rwayat("22 Januari 2018", "0", "0", "Hard", 30));
        rwayats.add(new Rwayat("22 Januari 2018", "0", "0", "Hard", 30));
        rwayats.add(new Rwayat("22 Januari 2018", "0", "0", "Hard", 30));
        RiwayatAdapter riwayatAdapter =  new RiwayatAdapter(this, rwayats);
        RecyclerView rv= findViewById(R.id.mainRV);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(riwayatAdapter);
    }
    public void onBackPressed() {
        Intent i = new Intent(RiwayatScoreFragment2.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

}