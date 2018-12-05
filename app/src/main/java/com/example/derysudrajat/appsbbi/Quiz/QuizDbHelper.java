package com.example.derysudrajat.appsbbi.Quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.derysudrajat.appsbbi.Quiz.QuizContract.QuestionsTable;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kuislusi.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


//    public void queryData(String sql){
//        SQLiteDatabase database = getWritableDatabase();
//        database.execSQL(sql);
//    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT," +
                QuestionsTable.KEY_IMAGE + " BLOB" +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT"+
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("Man",
                "A. Laki-laki", "B. Wanita", "C. Anak Laki-laki", "D. Anak Perempuan", 1, Question.DIFFICULTY_EASY, "ini adalah benar");
//                "A", "B", "C", 1, Question.DIFFICULTY_EASY);
        addQuestion(q1);
        Question q7 = new Question("Anak Perempuan",
                "A. Boy", "B. Girl", "C. Woman","D. Man", 2, Question.DIFFICULTY_EASY, "iniadalah");
//                "A", "B", "C", 2, Question.DIFFICULTY_EASY);
        addQuestion(q7);
        Question q8 = new Question("Woman",
                "A. Pria", "B. Anak Perempuan", "C. Perempuan","D. Anak Laki-laki", 3, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q8);
        Question q9 = new Question("Anak Laki-laki",
                "A. Girl", "B. Boy", "C. Woman", "D. Man", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 2, Question.DIFFICULTY_EASY);
        addQuestion(q9);
        Question q10 = new Question("Membaca",
                "A. Write", "B. Eat", "C. Read","D. Walk", 3, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q10);
        Question q16 = new Question("Eat",
                "A. Berjalan", "B. Makan", "C. Membaca","D. Berlari", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q16);
        Question q17 = new Question("Sebuah koran",
                "A. A Newspaper", "B. A Taxi", "C. A Ticket","D. A Pen", 1, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q17);
        Question q18 = new Question("Drink",
                "A. Berlari", "B. Belajar", "C. Makan","D. Minum", 4, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q18);
        Question q19 = new Question("Duck",
                "A. Semut", "B. Gajah", "C. Singa","D. Bebek", 4, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q19);
        Question q20 = new Question("Elephant",
                "A. Semut", "B. Gajah", "C. Singa","D. Bebek", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q20);


        Question q2 = new Question("She writes",
                "A. Dia makan", "B. Dia menulis", "C. Dia minum","D. Dia berenang", 2, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q2);
        Question q3 = new Question("We go to a party",
                "A. Kami pergi ke pesta", "B. Kami pergi ke bioskop", "C.  Kami pergi ke taman", "D.  Kami pergi ke mall",1, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C",3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q3);
        Question q11 = new Question("Day after day",
                "A.Hari demi hari", "B. Hari senin", "C. Hari dalam minggu", "D. Hari ulang tahun",1, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C",1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q11);
        Question q12 = new Question("She loves the man",
                "A. Kapan dia pergi?", "B. Dia bersamamu", "C. Dia mencintai pria itu","D. Dia menanyakan kabarmu", 3, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q12);
        Question q13 = new Question("Today I read",
                "A. Hari ini saya membaca", "B. Hari ini saya menulis", "C. Hari ini saya bermain", "D. Hari ini saya bekerja",1, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C",1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q13);
        Question q21 = new Question("My color is pink",
                "A. Warna saya merah", "B. Warna saya biru", "C. Warna saya merah muda","D. Warna saya hijau", 3, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q21);
        Question q22 = new Question("I cook rice",
                "A. Saya memasak kentang", "B. Saya memasak nasi", "C. Saya memasak talas","D. Saya memasak mie", 2, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q22);
        Question q23 = new Question("I have a question",
                "A. Saya punya sebuah balon", "B. Saya punya sebuah permen", "C. Saya punya sebuah pernyataan","D. Saya punya sebuah pertanyaan", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q23);
        Question q24 = new Question("Generasi anda memakai topi",
                " A. Your generation wears pants", "B Your generation wears cat", "C.  Your generation wears shoes","D. Your generation wears hat", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q24);
        Question q25 = new Question("Dia menyukai kopi",
                "A. She likes pants", "B. She likes shoes", "C. She likes tea","D. She likes coffe", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q25);


        Question q4 = new Question("When little riding hood arrived, the wolf in disguise told her to come in. little riding hood did not realize that it was the wolf.  Then the wolf ate a little riding hood and her grandmother. After eating them, the wolf fell asleep beside the river. Suddenly, a woodcutter came; he saw a large wolf’s belly and knew what had been done by the wolf. Then he saved them by releasing them out from the belly of the wolf and filled the wolf’s stomach with a big stone. Then he threw the wolf into the river.\n" +
                "\n" +
                "1. What is the story about",
                "A. A kind wolf who wants to help little riding hood", "B. A little riding hood meet wolf ", "C. Grandma asked wolf to take little riding hood ", "D. A bad wolf who wants to eat little riding hood and grandma ",4, Question.DIFFICULTY_HARD);
//                "A", "B", "C",1, Question.DIFFICULTY_HARD);
        addQuestion(q4);
        Question q5 = new Question("Why she eat?",
                "A.Because she hungry", "B. Because she trusty", "C. Because she was daft ", "D. Because she was blind",1, Question.DIFFICULTY_HARD);
//                "A", "B", "C",2, Question.DIFFICULTY_HARD);
        addQuestion(q5);
        Question q6 = new Question("Who did save lot of a money?",
                "A. Because  ", "B. The stranger", "C. The woodcutter","D. The little riding hood’s father ", 3, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_HARD);
        addQuestion(q6);
        Question q14 = new Question("What is the moral you love?",
                "A. Don’t believe in stranger", "B. Don’t be greedy", "C. Don’t sleep in the river", "D. Don’t go to Grandma’s house",1, Question.DIFFICULTY_HARD);
//                "A", "B", "C",1, Question.DIFFICULTY_HARD);
        addQuestion(q14);
        Question q15 = new Question("The fact that he was put in prison for something that he had not done made his wife ",
                "A. cry", "B. Cried", "C. to cry", "D. to be crying",1, Question.DIFFICULTY_HARD);
//                "A", "B", "C",2, Question.DIFFICULTY_HARD);
        addQuestion(q15);
        Question q26 = new Question("Student : Would you mind ______ me your book, Sir?",
                "A. Lend", "B. to Lend", "C. Lending","D. Lent", 3, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q26);
        Question q27 = new Question("Teacher : Well, students, for your assignment you must write a poem.\n" +
                "Student : …\n",
                "A. What?", "B. Excuse me", "C. Pardon me, sir?","D. I'm very sorry, Sir", 3, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q27);
        Question q28 = new Question("Where does the teacher sit ?",
                "A. In front of the classroom", "B. Behind the board", "C. Under the map","D. Behind the table", 4, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q28);
        Question q29 = new Question(" Lina …… the match in Olympic Games. She is so sad.",
                "A. won", "B. lost", "C. jumped","D. happy", 2, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q29);
        Question q30 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q30);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
//        cv.put(QuestionsTable.KEY_IMAGE, question.get);
//        cv.put(QuestionsTable.KEY_IMAGE, question.getImage());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getPenjelasan());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("Man", "A", "B", "C","D", 1, Question.DIFFICULTY_EASY);
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
//                question.setImage(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_IMAGE)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
//                question.setPenjelasan(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("Man", "A", "B", "C", "D", 1, Question.DIFFICULTY_EASY);
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
//                question.setIamge(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_IMAGE)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
//                question.setPenjelasan(c.getColumnName(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}