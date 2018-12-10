package com.example.derysudrajat.appsbbi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.derysudrajat.appsbbi.Quiz.Network.STATICUSER;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigation = findViewById(R.id.myBottomNavigation_ID);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();
        TextView hello = (TextView) findViewById(R.id.hello);
        TextView namaLengkap = (TextView) findViewById(R.id.namaLengkap);
        hello.setText("HELLO");

        namaLengkap.setText(STATICUSER.USER.getNama());
    }

    private void createNavItems() {
        //CREATE ITEMS
        AHBottomNavigationItem crimeItem = new AHBottomNavigationItem("Materi", R.drawable.outline_book_white_18dp);
        AHBottomNavigationItem dramaItem = new AHBottomNavigationItem("Quiz", R.drawable.outline_format_list_bulleted_white_18dp);
        AHBottomNavigationItem docsItem = new AHBottomNavigationItem("Riwayat", R.drawable.baseline_stars_white_18dp);

        //ADD PROPERTIES
        bottomNavigation.addItem(crimeItem);
        bottomNavigation.addItem(dramaItem);
        bottomNavigation.addItem(docsItem);

        //SET PROPERTIES
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#fefefe"));

        bottomNavigation.setCurrentItem(0);

    }



    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position == 0) {
            MateriFragment materiFragment = new MateriFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, materiFragment).commit();
        } else if (position == 1) {
            QuizFragment quizFragment = new QuizFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, quizFragment).commit();
        } else if (position == 2) {
            ScoreFragment scoreFragment = new ScoreFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, scoreFragment).commit();
        }
    }
}
