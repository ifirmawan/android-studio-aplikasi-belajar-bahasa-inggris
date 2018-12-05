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
import com.example.derysudrajat.appsbbi.Quiz.Model.User;
import com.example.derysudrajat.appsbbi.Quiz.Network.Auth;
import com.example.derysudrajat.appsbbi.Quiz.Network.STATICUSER;
import com.example.derysudrajat.appsbbi.Quiz.Network.Status;
import com.example.derysudrajat.appsbbi.R;

public class HasilQuiz extends AppCompatActivity {
//    TextView correct, incorrect, attempted, score, you;
//    int cor = 0, incorr = 0, attempt = 0, scor = 0, yo = 0;
//    int x = 0;
//    private static final int def = 0;

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView tvHighscore, tvPenjelasan, tvHome;

    private int highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz);
        tvHighscore  =  findViewById(R.id.tvhighscore);
//        tvPenjelasan = findViewById(R.id.tvPenjelasan);
        tvHome = findViewById(R.id.tvHome);
        loadHighscore();
        int score = getIntent().getIntExtra(QuizActivity.EXTRA_SCORE, 0);
        updateHighscore(score);

        //baru
//        Intent intent = getIntent();
//        cor = intent.getIntExtra("correct", 0);
//        attempt = intent.getIntExtra("attemp", 0);
//        incorr = attempt - cor;
//        scor = 10 * cor;
//        correct =  findViewById(R.id.correct);
//        incorrect = findViewById(R.id.incorrect);
//        attempted = findViewById(R.id.attempted);
//        score = findViewById(R.id.score);
//        you = findViewById(R.id.you);
//
//        attempted.setText("  " + attempt);
//        correct.setText("  " + cor);
//        incorrect.setText("  " + incorr);
//      score.setText("Score  :    " + scor);
//        float x1 = (cor * 100) / attempt;
//        if (x1 < 4)
//            you.setText("You Need Improvement");
//        else if (x1 < 7)
//            you.setText("You are an average Quizzer");
//        else if (x1 < 9)
//            you.setText("You are an above average Quizzer ");
//        else
//            you.setText("You are a brilliant  Quizzer ");

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
        startActivity(intentTentang);
    }
    @Override
    public void onBackPressed(){
        Intent intentTentang = new Intent(HasilQuiz.this, MainActivity.class); //membuat nama intentTentang yang ditujukan ke Class TentangActivity
        startActivity(intentTentang);
    }

    public void sendHighscore(View view){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        Auth a = new Auth(getApplicationContext(), new User("maman", "lala","maman",highscore,1), new Status() {
            @Override
            public void onLoginDone(User user) {
                STATICUSER.USER = user;
                Log.d("SEND", String.valueOf(STATICUSER.USER));
            }
        });
        a.submitHighscore();
    }
}
