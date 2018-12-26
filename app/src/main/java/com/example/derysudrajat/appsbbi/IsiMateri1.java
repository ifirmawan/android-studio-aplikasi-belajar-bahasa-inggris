package com.example.derysudrajat.appsbbi;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.derysudrajat.appsbbi.Quiz.QuizActivity;

//import android.widget.Button;


public class IsiMateri1 extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi1);

        TextView tv = findViewById(R.id.nameTxt4);
        TextView tv1 = findViewById(R.id.nameTxt5);
        TextView tv2 = findViewById(R.id.nameTxt6);
        tv.setText(getString(R.string.mate1a));
        tv1.setText(getString(R.string.mate1b));
        tv2.setText(getString(R.string.mate1c));
    }
    public void onFragmentInteraction(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void playMusic(View v) {
        // Play only one sound at a time
        if(mp != null) mp.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(v.getId()){

            // The cow button
            case R.id.imgVi2:
                //Log.i("Test", "Cow Button");
                mp = MediaPlayer.create(this, R.raw.bab1a);
                break;

            // The duck button
            case R.id.imgVi3:
                //Log.i("Test", "Duck Button");
                mp = MediaPlayer.create(this, R.raw.bab1b);
                break;

            // The sheep button
            case R.id.imgVi4:
                //Log.i("Test", "Sheep Button");
                mp = MediaPlayer.create(this, R.raw.bab1c);
                break;

        }
        mp.seekTo(0);
        mp.start();
    }


    @Override
    public void onPause() {
        super.onPause();
        // Release the MediaPlayer if going into background if it isn't null
        if(mp != null) mp.release();
    }
    public void quiskecilsattu(View v)
    {
        Intent intentTentang = new Intent(IsiMateri1.this, quissimple1.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
    public void onBackPressed() {
        Intent i = new Intent(IsiMateri1.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

}
