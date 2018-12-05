package com.example.derysudrajat.appsbbi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IsiMateri3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi1);
//        ImageView iv = findViewById(R.id.imgVi1);
        ImageButton iv1 = findViewById(R.id.imgVi2);
        ImageButton iv2 = findViewById(R.id.imgVi3);
        ImageButton iv3 = findViewById(R.id.imgVi4);
        TextView tv = findViewById(R.id.nameTxt4);
        TextView tv1 = findViewById(R.id.nameTxt5);
        TextView tv2 = findViewById(R.id.nameTxt6);
//        Glide.with(this).load(R.drawable.tech).into(iv);
        Glide.with(this).load(R.drawable.tech).into(iv1);
        Glide.with(this).load(R.drawable.tech).into(iv2);
        Glide.with(this).load(R.drawable.tech).into(iv3);
        tv.setText(getString(R.string.mate3a));
        tv1.setText(getString(R.string.mate3b));
        tv2.setText(getString(R.string.mate3c));

    }
    public void onFragmentInteraction(String title) {
        getSupportActionBar().setTitle(title);
    }
}