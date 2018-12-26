package com.example.derysudrajat.appsbbi.Quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.MainActivity;
import com.example.derysudrajat.appsbbi.PembahasanActivity;
import com.example.derysudrajat.appsbbi.R;

public class HasilQuiz extends AppCompatActivity {
//    TextView correct, incorrect, attempted, score, you;
//    int cor = 0, incorr = 0, attempt = 0, scor = 0, yo = 0;
//    int x = 0;
//    private static final int def = 0;

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView tvHighscore, tvPenjelasan, tvHome,tvIncorrect,tvCorrect;

    private int highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz);
        tvHighscore  =  findViewById(R.id.tvhighscore);
        tvIncorrect  =  findViewById(R.id.incorrect);
        tvCorrect  =  findViewById(R.id.correct);
//        tvPenjelasan = findViewById(R.id.tvPenjelasan);
        tvHome = findViewById(R.id.tvHome);
        loadHighscore();
        int score = getIntent().getIntExtra(QuizActivity.EXTRA_SCORE, 0);
        int score_wrong = getIntent().getIntExtra(QuizActivity.EXTRA_WRONG_SCORE, 0);
        tvIncorrect.setText(String.valueOf(score_wrong));
        tvCorrect.setText(String.valueOf(score));
        //Log.d("WEW", String.valueOf(score_wrong));
        updateHighscore(score);

    }


    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        tvHighscore.setText("" + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        tvHighscore.setText("" + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
    public void penjelasan(View v)
    {
        TextView tv=  findViewById(R.id.tvPenjelasan);
        tv.setText("Explaination");
        Intent intentTentang = new Intent(HasilQuiz.this, PembahasanActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }
    public void home(View v)
    {
        TextView tv=  findViewById(R.id.tvHome);
        tv.setText("Exit");
        Intent intentTentang = new Intent(HasilQuiz.this, MainActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        //menggunakan set Flags, untuk menandakan keadaan saat itu, misalkan act
        intentTentang.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentTentang);
        //finish();
    }
    @Override
    public void onBackPressed(){
        Intent intentTentang = new Intent(HasilQuiz.this, MainActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        intentTentang.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentTentang);
       // finish();
    }
}
