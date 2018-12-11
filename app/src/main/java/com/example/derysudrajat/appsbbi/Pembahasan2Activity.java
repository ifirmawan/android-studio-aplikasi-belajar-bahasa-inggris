package com.example.derysudrajat.appsbbi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pembahasan2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembahasan2);
    }
    public void onBackPressed(){
        Intent intentTentang = new Intent(Pembahasan2Activity.this, MainActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
}
