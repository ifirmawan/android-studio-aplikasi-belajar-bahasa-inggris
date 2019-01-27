package  com.lusi.bbi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lusi.bbi.R;
import com.lusi.bbi.Quiz.QuizActivity;
import com.lusi.bbi.R;

public class cobaHighScore extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView tvHighscore;
//    private Spinner spinnerDifficulty;
    TextView tvNamaSaya;
    private String nama;
    private String KEY_NAME = "NAMA";

    private int highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba_high_score);
        tvHighscore =  findViewById(R.id.tvhighscore);
//        spinnerDifficulty = (Spinner) findViewById(R.id.spinner_difficulty);
        tvNamaSaya=findViewById(R.id.tvNamaSaya);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        tvNamaSaya.setText("Hello, " + nama + " !");

//        String[] difficultyLevels = Question.getAllDifficultyLevels();

//        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, difficultyLevels);
//        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerDifficulty.setAdapter(adapterDifficulty);
//
        loadHighscore();

//        Button buttonStartQuiz = (Button) findViewById(R.id.btn_start_quiz);
//        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startQuiz();
//            }
//        });
    }
//    private void startQuiz() {
//        String difficulty = spinnerDifficulty.getSelectedItem().toString();
//        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
//        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
//        startActivityForResult(intent, REQUEST_CODE_QUIZ);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        tvHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        tvHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}
