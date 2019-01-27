package  com.lusi.bbi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lusi.bbi.R;

public class quissimple2 extends AppCompatActivity {
    private MediaPlayer  mpa, mpb, mpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quissimple2);
    }
    public void playJawaban1(View v) {
        // Play only one sound at a time
        if(mpa != null) mpa.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(v.getId()){

            // The cow button
            case R.id.imgVi6:
                //Log.i("Test", "Cow Button");
                mpa = MediaPlayer.create(this, R.raw.soal1);
                break;

            // The duck button
            case R.id.imgVi7:
                //Log.i("Test", "Duck Button");
                mpa = MediaPlayer.create(this, R.raw.benar);
                break;

            // The sheep button
            case R.id.imgVi8:
                //Log.i("Test", "Sheep Button");
                mpa = MediaPlayer.create(this, R.raw.salah);
                break;

            case R.id.imgVi9:
                //Log.i("Test", "Sheep Button");
                mpa = MediaPlayer.create(this, R.raw.salah);
                break;
        }
        mpa.seekTo(0);
        mpa.start();
    }
    public void playJawaban2(View v) {
        // Play only one sound at a time
        if(mpb != null) mpb.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(v.getId()){

            // The cow button
            case R.id.imgVi66:
                //Log.i("Test", "Cow Button");
                mpb = MediaPlayer.create(this, R.raw.soal2);
                break;

            // The duck button
            case R.id.imgVi10:
                //Log.i("Test", "Duck Button");
                mpb = MediaPlayer.create(this, R.raw.salah);
                break;

            // The sheep button
            case R.id.imgVi11:
                //Log.i("Test", "Sheep Button");
                mpb = MediaPlayer.create(this, R.raw.salah);
                break;

            case R.id.imgVi12:
                //Log.i("Test", "Sheep Button");
                mpb = MediaPlayer.create(this, R.raw.benar);
                break;
        }
        mpb.seekTo(0);
        mpb.start();
    }
    public void playJawaban3(View v) {
        // Play only one sound at a time
        if(mpc != null) mpc.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(v.getId()){

            // The cow button
            case R.id.imgVi66a:
                //Log.i("Test", "Cow Button");
                mpc = MediaPlayer.create(this, R.raw.soal3);
                break;

            // The duck button
            case R.id.imgVi10c:
                //Log.i("Test", "Duck Button");
                mpc = MediaPlayer.create(this, R.raw.salah);
                break;

            // The sheep button
            case R.id.imgVi11c:
                //Log.i("Test", "Sheep Button");
                mpc = MediaPlayer.create(this, R.raw.benar);
                break;

            case R.id.imgVi12c:
                //Log.i("Test", "Sheep Button");
                mpc = MediaPlayer.create(this, R.raw.salah);
                break;
        }
        mpc.seekTo(0);
        mpc.start();
    }
    public void onPause() {
        super.onPause();
        // Release the MediaPlayer if going into background if it isn't null
        if(mpc != null) mpc.release();
    }
    public void stop(){

    }
    public void onBackPressed(){
        Intent intentTentang = new Intent(quissimple2.this, MainActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
        finish();
    }
}
