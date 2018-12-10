package com.example.derysudrajat.appsbbi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.Quiz.QuizActivity;

public class MulaiQuizA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai_quiz);
//        if(savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().
//                    add(R.id.QuizContext, new QuizActivity(), QuizActivity.class.getSimpleName()).commit();
//        }
        Intent i = new Intent(MulaiQuizA.this,QuizActivity.class);
        startActivity(i);
    }
    public void nextQuiz (View view){
        Toast toast = Toast.makeText(this, "to Next Quiz", Toast.LENGTH_SHORT);
        toast.show();
    }
}
