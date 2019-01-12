package com.example.derysudrajat.appsbbi.Quiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.MainActivity;
import com.example.derysudrajat.appsbbi.PembahasanActivity;
import com.example.derysudrajat.appsbbi.Quiz.Network.STATICUSER;
import com.example.derysudrajat.appsbbi.Quiz.Network.ServerProcessClass;
import com.example.derysudrajat.appsbbi.R;

import java.util.HashMap;

public class HasilQuiz extends AppCompatActivity {
//    TextView correct, incorrect, attempted, score, you;
//    int cor = 0, incorr = 0, attempt = 0, scor = 0, yo = 0;
//    int x = 0;
//    private static final int def = 0;

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView tvHighscore, tvPenjelasan, hello, tvnama, tvHome,tvIncorrect,tvCorrect;

    private int highscore;
    private int jml_soal;
    private int questionCountTotal;
    private final  String URL_SEND_HIGHSCORE = "http://bbi.rendyandriyanto.com/send_highscore.php";
    ProgressDialog progressDialog ;

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
        hello = findViewById(R.id.hello);
        TextView namaLengkap =  findViewById(R.id.tvnama);
        hello.setText("Hello,  ");
        namaLengkap.setText(STATICUSER.USER.getNama());
        int score = getIntent().getIntExtra(QuizActivity.EXTRA_SCORE, 0);
        int score_wrong = getIntent().getIntExtra(QuizActivity.EXTRA_WRONG_SCORE, 0);
        tvIncorrect.setText(String.valueOf(score_wrong));
        tvCorrect.setText(String.valueOf(score));
        //Log.d("WEW", String.valueOf(score_wrong));
        updateHighscore(score);

        Button btnUpload =  findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendHighscoreToServer();
            }
        });

        if (getIntent().hasExtra("jml_soal")){ //2. menerima intent put extra
        Toast.makeText(HasilQuiz.this,getIntent().getStringExtra("jml_soal"),Toast.LENGTH_LONG).show();
        }
    }

    public void SendHighscoreToServer(){

        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(HasilQuiz.this,"Highscore is Uploading","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

                //Toast.makeText(HasilQuiz.this,string1,Toast.LENGTH_LONG).show();
                Intent i = new Intent(HasilQuiz.this,HasilQuizBaru.class); //QuizActiy
                //i.putExtra("jml_soal",String.valueOf(.....)); //1. mengirim intent
                startActivity(i);

            }

            @Override
            protected String doInBackground(Void... params) {

                ServerProcessClass serverProcessClass = new ServerProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();
                SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                highscore = prefs.getInt(KEY_HIGHSCORE, 0);

                HashMapParams.put("user_id", String.valueOf(STATICUSER.USER.getUserID()));
                HashMapParams.put("highscore", String.valueOf(highscore));
//              HashMapParams.put("jml_soal", String.valueOf(questionCountTotal));
//                        3.
//                if(jml_soal == 10){
//                HashMapParams.put("level", "easy");
//                }else if (jml_soal == 20) {
//                HashMapParams.put("level", "medium");
//                }else if (jml_soal == 30) {
//                    HashMapParams.put("level", "hard");
//                };

                String FinalData = serverProcessClass.ServerHttpRequest(URL_SEND_HIGHSCORE, HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();

    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        tvHighscore.setText("" + highscore );
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        tvHighscore.setText("" + highscore );

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
