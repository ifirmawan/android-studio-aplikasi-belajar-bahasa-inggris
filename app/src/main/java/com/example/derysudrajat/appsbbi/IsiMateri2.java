package com.example.derysudrajat.appsbbi;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IsiMateri2 extends AppCompatActivity {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi2);

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
                mp = MediaPlayer.create(this, R.raw.positiv);
                break;

            // The duck button
            case R.id.imgVi3:
                //Log.i("Test", "Duck Button");
                mp = MediaPlayer.create(this, R.raw.compare);
                break;

            // The sheep button
            case R.id.imgVi5:
                //Log.i("Test", "Sheep Button");
                mp = MediaPlayer.create(this, R.raw.superla);
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
    public void quiskecildua(View v)
    {
        Intent intentTentang = new Intent(IsiMateri2.this, quissimple2.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
    public void onBackPressed() {
        Intent i = new Intent(IsiMateri2.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
