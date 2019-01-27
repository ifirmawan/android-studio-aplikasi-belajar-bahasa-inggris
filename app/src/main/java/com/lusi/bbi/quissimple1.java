package  com.lusi.bbi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lusi.bbi.R;

public class quissimple1 extends AppCompatActivity {
    MediaPlayer  mpa, mpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quissimple1);
    }
    
    public void  playJawaban (View vi){
        // Play only one sound at a time
        if(mpa != null) mpa.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(vi.getId()) {
            // Suara soal 1 dan 2
            case R.id.ibSuara:
                //Log.i("Test", "Cow Button");
                mpa = MediaPlayer.create(this, R.raw.cooldplay);
                break;
            // The cow button
            case R.id.imgVi7:
                //Log.i("Test", "Cow Button");
                mpa = MediaPlayer.create(this, R.raw.benar);
                break;

            // The duck button
            case R.id.imgVi8:
                //Log.i("Test", "Duck Button");
                mpa = MediaPlayer.create(this, R.raw.salah);
                break;

            // The sheep button
            case R.id.imgVi9:
                //Log.i("Test", "Sheep Button");
                mpa = MediaPlayer.create(this, R.raw.salah);
                break;
            case R.id.imgVi10:
                //Log.i("Test", "Cow Button");
                mpa = MediaPlayer.create(this, R.raw.salah);
                break;

            // The duck button
            case R.id.imgVi11:
                //Log.i("Test", "Duck Button");
                mpa = MediaPlayer.create(this, R.raw.salah);
                break;

            // The sheep button
            case R.id.imgVi12:
                //Log.i("Test", "Sheep Button");
                mpa = MediaPlayer.create(this, R.raw.benar);
                break;
        }
        mpa.seekTo(0);
        mpa.start();
    }
        public void  playJawabanc (View vie){
        // Play only one sound at a time
        if(mpc != null) mpc.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(vie.getId()) {
            // The cow button
            case R.id.ibSuara2:
                mpc = MediaPlayer.create(this, R.raw.cooldplay);
                break;

            case R.id.imgVi10b:
                //Log.i("Test", "Cow Button");
                mpc = MediaPlayer.create(this, R.raw.salah);
                break;

            // The duck button
            case R.id.imgVi11b:
                //Log.i("Test", "Duck Button");
                mpc = MediaPlayer.create(this, R.raw.salah);
                break;

            // The sheep button
            case R.id.imgVi12b:
                //Log.i("Test", "Sheep Button");
                mpc = MediaPlayer.create(this, R.raw.benar);
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
    @Override
    public void onBackPressed(){
        Intent intentTentang = new Intent(quissimple1.this, MainActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
        finish();
    }
}
