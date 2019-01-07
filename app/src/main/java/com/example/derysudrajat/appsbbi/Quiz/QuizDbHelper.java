package com.example.derysudrajat.appsbbi.Quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.derysudrajat.appsbbi.Quiz.QuizContract.QuestionsTable;

import java.util.ArrayList;

import static com.example.derysudrajat.appsbbi.Quiz.QuizContract.QuestionsTable.TABLE_NAME;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kuislusi.db";
    private static final int DATABASE_VERSION = 8;

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
                TABLE_NAME + " ( " +
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private String newValue;
//    String sql = "UPDATE "+TABLE_NAME +" SET " + COLUMN_QUESTION+ " = '"+newValue+"' WHERE "+COLUMN_QUESTION+ " = "+rowId;

    private void fillQuestionsTable() {
        Question q1 = new Question("In your opinion, what is the ___ search engine of all?  Is it the ___ popular one as well? ",
                "A. Faster / more", "B. Fastest / most", "C. Fastest / more", "D. Faster / most ", 2, Question.DIFFICULTY_EASY, "ini adalah benar");
//                "A", "B", "C", 1, Question.DIFFICULTY_EASY);
        addQuestion(q1);
        Question q2 = new Question("Are national cars ___ than imported ones?\" \"No, but I think they're just as ___.",
                "A. Cheap / good", "B. Cheapest / better", "C. Cheaper / good","D. The cheapest / best", 3, Question.DIFFICULTY_EASY, "iniadalah");
//                "A", "B", "C", 2, Question.DIFFICULTY_EASY);
        addQuestion(q2);
        Question q3 = new Question("My laptop is kind of big. Your is much ___ .",
                "A. Small", "B. Smallest", "C. Smaller","D. As small", 3, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q3);
        Question q4 = new Question("At the left, you can see Simon. ___ is my brother. ",
                "A. That", "B. He", "C. It", "D. Him", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 2, Question.DIFFICULTY_EASY);
        addQuestion(q4);
        Question q5 = new Question("Look outside. ___ is my car parked there.",
                "A. This", "B. That", "C. Those","D. Their", 1, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q5);
        Question q6 = new Question("Our friend, ___ we invited for the party, arrived early.",
                "A. Whose", "B. That", "C. Whom","D. Them", 3, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q6);
        Question q7 = new Question("Why don't you go by car?  It's more convenient ___ taking the bus.",
                "A. That", "B. Then", "C. The","D. Than", 4, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q7);
        Question q8 = new Question("Karen loves rock.  She thinks it's __ other kinds of music.",
                "A. More exciting", "B. More exciting than", "C. The most exciting","D. Exciting than", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q8);
        Question q9 = new Question("Adam is the boy ___ loves playing soccer.",
                "A. Who", "B. Which", "C. Whose","D. Where", 1, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q9);
        Question q10 = new Question("Ms. Charlotte reminded ____ to order tickets as soon as possible.",
                "A. His", "B. Herself", "C. Her","D. She", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q10);
        Question q10a = new Question("Ms. Charlotte reminded ____ to order tickets as soon as possible.",
                "A. His", "B. Herself", "C. Her","D. She", 2, Question.DIFFICULTY_EASY);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q10a);
        Question q10b = new Question("Ms. Charlotte reminded ____ to order tickets as soon as possible.",
                "A. His", "B. Herself", "C. Her","D. She", 2, Question.DIFFICULTY_EASY);

        addQuestion(q10b);


        Question q11 = new Question("Choose the right pronoun to correctly finish this sentence:\n" +
                "_________ need to follow me closely.",
                "A. You", "B. He", "C. She","D. It", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q11);

        Question q12 = new Question("Lewis, Luke and Thomas were cross because ________ had waited ages for the bus.",
                "A. Them", "B. He", "C. They", "D.  It",3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q12);

        Question q13 = new Question("Palvinder watched the children carefully as _________ crossed the road.?",
                "A. Them", "B. Him", "C. They", "D. Us",3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q13);

        Question q14 = new Question("Hold the bag please while I put the shopping in ________ .",
                "A. Him", "B. It", "C. She","D. I", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q14);

        Question q15 = new Question("Melanie and I are going soon so you can come with _________ .",
                "A. We", "B. Them", "C. They", "D. Us",4, Question.DIFFICULTY_MEDIUM);
        addQuestion(q15);

        Question q16 = new Question("Thank you for collecting ________ .",
                "A. Me", "B. He", "C. She","D. They", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q16);

        Question q17 = new Question("I wonder why Geoff rushed off. Did you upset _______ ?",
                "A. He", "B. Him", "C. We","D. They", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q17);

        Question q18 = new Question("_______ hope those flowers are for me.",
                "A. We", "B. Them", "C. I","D. Him", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q18);

        Question q19 = new Question("Open the door. It's ______ .",
                " A. I", "B They", "C.  Me","D. She", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q19);

        Question q20 = new Question("Sarah wanted Lisa to follow ________.",
                "A. She", "B. They", "C. I","D. Her", 4, Question.DIFFICULTY_MEDIUM);
        addQuestion(q20);

        Question q21 = new Question(" She is senior _______ me by five years.",
                "A. Than", "B. Of", "C. to","D. As", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q21);

        Question q22 = new Question(" My job is superior _______ yours.",
                "A. Than", "B. Of", "C. to","D. As", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q22);

        Question q23 = new Question(" James is _______ his brother",
                "A. Tallest of", "B. Taller Than", "C. Taller Then","D. Taller", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q23);

        Question q24 = new Question("She sings ______ as her sister",
                " A. as best", "B. as well ", "C. Better","D. Good", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q24);

        Question q25 = new Question(" I earn as ______ money as you do.",
                "A. Much", "B. More", "C. Much More","D. More Much", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q25);

        Question q26 = new Question("My color is pink",
                "A. Warna saya merah", "B. Warna saya biru", "C. Warna saya merah muda","D. Warna saya hijau", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q26);

        Question q27 = new Question("I cook rice",
                "A. Saya memasak kentang", "B. Saya memasak nasi", "C. Saya memasak talas","D. Saya memasak mie", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q27);

        Question q28 = new Question("I have a question",
                "A. Saya punya sebuah balon", "B. Saya punya sebuah permen", "C. Saya punya sebuah pernyataan","D. Saya punya sebuah pertanyaan", 4, Question.DIFFICULTY_MEDIUM);
        addQuestion(q28);

        Question q29 = new Question("Generasi anda memakai topi",
                " A. Your generation wears pants", "B Your generation wears cat", "C.  Your generation wears shoes","D. Your generation wears hat", 4, Question.DIFFICULTY_MEDIUM);
        addQuestion(q29);

        Question q30 = new Question("Dia menyukai kopi",
                "A. She likes pants", "B. She likes shoes", "C. She likes tea","D. She likes coffe", 4, Question.DIFFICULTY_MEDIUM);
        addQuestion(q30);

        Question q31 = new Question("What does ‘it’ refer to?\n" +
                "They've just closed the post office and turned it into a coffee shop",
                "A. They", "B. Post Office", "C. Coffe  Shop ", "D. They",2, Question.DIFFICULTY_HARD);
        addQuestion(q31);

        Question q32 = new Question("What does ‘they’ refer to?\n" +
                "I asked at several shops for strawberries and the owners all told me they are out of season.",
                "A. Shops", "B. Strawberries", "C. Owner", "D. Me",2, Question.DIFFICULTY_HARD);
        addQuestion(q32);

        Question q33 = new Question("Could you dry the dishes and put _____ away?",
                "A. Them  ", "B. Their", "C. They","D. Those ", 1, Question.DIFFICULTY_HARD);
        addQuestion(q33);

        Question q34 = new Question("Time to go to school, Sue. Have you got your keys?' I can't find _____",
                "A. Them  ", "B. Their", "C. They","D. Those ",2, Question.DIFFICULTY_HARD);
        addQuestion(q34);

        Question q35 = new Question("The children are coming out of school in a minute. I need to go and pick _____ up.",
                "A. She", "B. It", "C. Her", "D. Them",3, Question.DIFFICULTY_HARD);
        addQuestion(q35);

        Question q36 = new Question("My jumper doesn't fit anymore. I think I've shrunk __________.",
                "A. He", "B. She", "C. It","D. I", 4, Question.DIFFICULTY_HARD);
        addQuestion(q36);

        Question q37 = new Question("Ali and Marcus would like to invite ________ to the party too.",
                "A. You", "B. I", "C. They","D. She", 1, Question.DIFFICULTY_HARD);
        addQuestion(q37);

        Question q38 = new Question("I was stopped by a woman who wanted to ask ________ the way to the post office.",
                "A. It", "B. We", "C. Me","D. She", 3, Question.DIFFICULTY_HARD);
        addQuestion(q38);

        Question q39 = new Question(" ______ thought the holiday would be ideal for us.",
                "A. Him", "B. Her", "C. We","D. Me", 3, Question.DIFFICULTY_HARD);
        addQuestion(q39);

        Question q40 = new Question("My jumper doesn't fit anymore. I think I've shrunk __________.",
                "A. He", "B. She", "C. It","D. I", 3, Question.DIFFICULTY_HARD);
        addQuestion(q40);

        Question q41 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q41);

        Question q42 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q42);

        Question q43 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q43);

        Question q44 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q44);

        Question q45 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q45);

        Question q46 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q46);

        Question q47 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q47);

        Question q48 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q48);

        Question q49 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q49);

        Question q50 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q50);

        Question q51 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q51);

        Question q52 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q52);

        Question q53 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q53);

        Question q54 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q54);

        Question q55 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q55);

        Question q56 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q56);

        Question q57 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q57);

        Question q58 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q58);

        Question q59 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q59);

        Question q60 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
        addQuestion(q60);
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
        db.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("In your opinion, what is the ___ search engine of all?  Is it the ___ popular one as well? ", "A", "B", "C","D", 1, Question.DIFFICULTY_EASY);
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
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question("In your opinion, what is the ___ search engine of all?  Is it the ___ popular one as well? ", "A", "B", "C", "D", 1, Question.DIFFICULTY_EASY);
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