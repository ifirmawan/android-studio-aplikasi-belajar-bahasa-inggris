package com.example.derysudrajat.appsbbi;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView hello = findViewById(R.id.hello);
        TextView namaLengkap =  findViewById(R.id.namaLengkap);
        hello.setText("Hello,");
        namaLengkap.setText(STATICUSER.USER.getNama());
    }

    private void createNavItems() {
        //CREATE ITEMS
        AHBottomNavigationItem crimeItem = new AHBottomNavigationItem("Materi", R.drawable.outline_book_white_18dp);
        AHBottomNavigationItem dramaItem = new AHBottomNavigationItem("Quiz", R.drawable.outline_format_list_bulleted_white_18dp);
        AHBottomNavigationItem docsItem = new AHBottomNavigationItem("Riwayat", R.drawable.baseline_stars_white_18dp);
//        AHBottomNavigationItem pdfitem = new AHBottomNavigationItem("Ranking", R.drawable.podium);

        //ADD PROPERTIES
        bottomNavigation.addItem(crimeItem);
        bottomNavigation.addItem(dramaItem);
        bottomNavigation.addItem(docsItem);
//        bottomNavigation.addItem(pdfitem);

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
// else if (position == 3) {
//            PodiumFragment podiumFragment = new PodiumFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, podiumFragment).commit();
//        }
    }

    public void onBackPressed() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
//                  finish();
                    MainActivity.super.onBackPressed();


                }
            })
            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.cancel();
                }
            });
    AlertDialog alertDialog = builder.create();
    alertDialog.show();
    }
}
