package com.example.derysudrajat.appsbbi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
        TextView tv3 = findViewById(R.id.nameTxt7);
        TextView tv4 = findViewById(R.id.nameTxt8);
        TextView tv5 = findViewById(R.id.nameTxt9);

        tv.setText(getString(R.string.mate1a));
        tv1.setText(getString(R.string.mate1b));
        tv2.setText(getString(R.string.mate1c));
        tv3.setText(getString(R.string.mate1e));
        tv4.setText(getString(R.string.mate1f));
        tv5.setText(getString(R.string.mate1g));


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
                mp = MediaPlayer.create(this, R.raw.tester);
                break;

            // The duck button
            case R.id.imgVi3:
                //Log.i("Test", "Duck Button");
                mp = MediaPlayer.create(this, R.raw.tester);
                break;

            // The sheep button
            case R.id.imgVi4:
                //Log.i("Test", "Sheep Button");
                mp = MediaPlayer.create(this, R.raw.tester);
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
}
