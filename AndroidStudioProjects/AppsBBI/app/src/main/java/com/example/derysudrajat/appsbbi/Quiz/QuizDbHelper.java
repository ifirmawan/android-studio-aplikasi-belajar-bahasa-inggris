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
    private static final int DATABASE_VERSION = 7;

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
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q10b);


        Question q11 = new Question("Why do you prefer London to Madrid? I think London is a lot ___ to live.",
                "A. Nice", "B. Nicer", "C. Nicest","D. The Nicest", 2, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q11);
        Question q12 = new Question("This ice cream is so ___. It's the best in town.",
                "A. Good", "B. Better", "C. The Best", "D.  Best",1, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C",3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q12);
        Question q13 = new Question("Which sentence has no mistakes?",
                "A. Yesterday was more hotter than today.", "B. I am more intelligent then my brother.", "C. My mother isn't as taller as my father.", "D. Ankara is more crowded than Amasya.",4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C",1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q13);
        Question q14 = new Question("She loves the man",
                "A. Kapan dia pergi?", "B. Dia bersamamu", "C. Dia mencintai pria itu","D. Dia menanyakan kabarmu", 3, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q14);
        Question q15 = new Question("Today I read",
                "A. Hari ini saya membaca", "B. Hari ini saya menulis", "C. Hari ini saya bermain", "D. Hari ini saya bekerja",1, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C",1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q15);
        Question q16 = new Question("My color is pink",
                "A. Warna saya merah", "B. Warna saya biru", "C. Warna saya merah muda","D. Warna saya hijau", 3, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q16);
        Question q17 = new Question("I cook rice",
                "A. Saya memasak kentang", "B. Saya memasak nasi", "C. Saya memasak talas","D. Saya memasak mie", 2, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q17);
        Question q18 = new Question("I have a question",
                "A. Saya punya sebuah balon", "B. Saya punya sebuah permen", "C. Saya punya sebuah pernyataan","D. Saya punya sebuah pertanyaan", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q18);
        Question q19 = new Question("Generasi anda memakai topi",
                " A. Your generation wears pants", "B Your generation wears cat", "C.  Your generation wears shoes","D. Your generation wears hat", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q19);
        Question q20 = new Question("Dia menyukai kopi",
                "A. She likes pants", "B. She likes shoes", "C. She likes tea","D. She likes coffe", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q20);
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
        Question q26 = new Question("My color is pink",
                "A. Warna saya merah", "B. Warna saya biru", "C. Warna saya merah muda","D. Warna saya hijau", 3, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q26);
        Question q27 = new Question("I cook rice",
                "A. Saya memasak kentang", "B. Saya memasak nasi", "C. Saya memasak talas","D. Saya memasak mie", 2, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q27);
        Question q28 = new Question("I have a question",
                "A. Saya punya sebuah balon", "B. Saya punya sebuah permen", "C. Saya punya sebuah pernyataan","D. Saya punya sebuah pertanyaan", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q28);
        Question q29 = new Question("Generasi anda memakai topi",
                " A. Your generation wears pants", "B Your generation wears cat", "C.  Your generation wears shoes","D. Your generation wears hat", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q29);
        Question q30 = new Question("Dia menyukai kopi",
                "A. She likes pants", "B. She likes shoes", "C. She likes tea","D. She likes coffe", 4, Question.DIFFICULTY_MEDIUM);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q30);


        Question q31 = new Question("When little riding hood arrived, the wolf in disguise told her to come in. little riding hood did not realize that it was the wolf.  Then the wolf ate a little riding hood and her grandmother. After eating them, the wolf fell asleep beside the river. Suddenly, a woodcutter came; he saw a large wolf’s belly and knew what had been done by the wolf. Then he saved them by releasing them out from the belly of the wolf and filled the wolf’s stomach with a big stone. Then he threw the wolf into the river.\n" +
                "\n" +
                "1. What is the story about",
                "A. A kind wolf who wants to help little riding hood", "B. A little riding hood meet wolf ", "C. Grandma asked wolf to take little riding hood ", "D. A bad wolf who wants to eat little riding hood and grandma ",4, Question.DIFFICULTY_HARD);
//                "A", "B", "C",1, Question.DIFFICULTY_HARD);
        addQuestion(q31);
        Question q32 = new Question("Why she eat?",
                "A.Because she hungry", "B. Because she trusty", "C. Because she was daft ", "D. Because she was blind",1, Question.DIFFICULTY_HARD);
//                "A", "B", "C",2, Question.DIFFICULTY_HARD);
        addQuestion(q32);
        Question q33 = new Question("Who did save lot of a money?",
                "A. Because  ", "B. The stranger", "C. The woodcutter","D. The little riding hood’s father ", 3, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_HARD);
        addQuestion(q33);
        Question q34 = new Question("What is the moral you love?",
                "A. Don’t believe in stranger", "B. Don’t be greedy", "C. Don’t sleep in the river", "D. Don’t go to Grandma’s house",1, Question.DIFFICULTY_HARD);
//                "A", "B", "C",1, Question.DIFFICULTY_HARD);
        addQuestion(q34);
        Question q35 = new Question("The fact that he was put in prison for something that he had not done made his wife ",
                "A. cry", "B. Cried", "C. to cry", "D. to be crying",1, Question.DIFFICULTY_HARD);
//                "A", "B", "C",2, Question.DIFFICULTY_HARD);
        addQuestion(q35);
        Question q36 = new Question("Student : Would you mind ______ me your book, Sir?",
                "A. Lend", "B. to Lend", "C. Lending","D. Lent", 3, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q36);
        Question q37 = new Question("Teacher : Well, students, for your assignment you must write a poem.\n" +
                "Student : …\n",
                "A. What?", "B. Excuse me", "C. Pardon me, sir?","D. I'm very sorry, Sir", 3, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q37);
        Question q38 = new Question("Where does the teacher sit ?",
                "A. In front of the classroom", "B. Behind the board", "C. Under the map","D. Behind the table", 4, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q38);
        Question q39 = new Question(" Lina …… the match in Olympic Games. She is so sad.",
                "A. won", "B. lost", "C. jumped","D. happy", 2, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q39);
        Question q40 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q40);
        Question q41 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q41);
        Question q42 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q42);
        Question q43 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q43);
        Question q44 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q44);
        Question q45 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q45);
        Question q46 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q46);
        Question q47 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q47);
        Question q48 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q48);
        Question q49 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q49);
        Question q50 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q50);
        Question q51 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q51);
        Question q52 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q52);
        Question q53 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q53);
        Question q54 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q54);
        Question q55 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q55);
        Question q56 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q56);
        Question q57 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q57);
        Question q58 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q58);
        Question q59 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
        addQuestion(q59);
        Question q60 = new Question("My mother is a nurse. She works in Harapan Bunda Hospital. She ….. the",
                "A. helps", "B. thinks", "C. find","D. ignores", 1, Question.DIFFICULTY_HARD);
//                "A", "B", "C", 3, Question.DIFFICULTY_EASY);
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