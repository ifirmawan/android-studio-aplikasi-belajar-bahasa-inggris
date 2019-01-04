package com.example.derysudrajat.appsbbi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.derysudrajat.appsbbi.Quiz.HasilQuiz;

public class PembahasanActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembahasan);
    }

    public void exit(View v)
    {
        TextView tv=  findViewById(R.id.tvHome);
        Intent i = new Intent(PembahasanActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
    public void easybtn(View v)
    {
        TextView tv=  findViewById(R.id.tvHome);
        tv.setText("Exit");
        Intent intentTentang = new Intent(PembahasanActivity.this, Pembahasan2Activity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
    public void hardbtn(View v)
    {
        TextView tv=  findViewById(R.id.tvHome);
        tv.setText("Exit");
        Intent intentTentang = new Intent(PembahasanActivity.this, Pembahasan3Activity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
    public void medbtn(View v)
    {
        TextView tv=  findViewById(R.id.tvHome);
        tv.setText("Exit");
        Intent intentTentang = new Intent(PembahasanActivity.this, Pembahasan4Activity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
    public void onBackPressed() {
        Intent i = new Intent(PembahasanActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
}
