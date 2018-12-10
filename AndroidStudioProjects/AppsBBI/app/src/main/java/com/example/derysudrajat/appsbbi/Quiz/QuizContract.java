package com.example.derysudrajat.appsbbi.Quiz;

import android.provider.BaseColumns;

public class QuizContract {
    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_DIFFICULTY = "difficulty";
//        public static final String COLUMN_IMAGE = "image";
//        public static final String COLUMN_EXPLAIN = "penjelasan" ;
        public static final String KEY_IMAGE = "image_data";
    }
}