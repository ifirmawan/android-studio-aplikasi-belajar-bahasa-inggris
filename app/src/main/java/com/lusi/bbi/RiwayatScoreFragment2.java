package  com.lusi.bbi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lusi.bbi.Quiz.Model.ScoreModel;
import com.lusi.bbi.Quiz.Network.STATICUSER;
import com.lusi.bbi.Quiz.Network.ServerProcessClass;
import com.lusi.bbi.Quiz.ScoreAdapter;
import com.lusi.bbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RiwayatScoreFragment2 extends AppCompatActivity {

    //public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String KEY_HIGHSCORE = "keyHighscore";
    private final  String URL_SEND_HIGHSCORE = "http://bbi.rendyandriyanto.com/highscore.php";
    ArrayList<ScoreModel> dataModels;
    ListView listView;
    private static ScoreAdapter adapter;
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz_baru);
        //if (getIntent().hasExtra("user_id")){ //2. menerima intent put extra
        //Toast.makeText(HasilQuizBaru.this,getIntent().getStringExtra("user_id"),Toast.LENGTH_LONG).show();
        //}

        LoadHighScoreFromServer();
    }

    public void LoadHighScoreFromServer(){

        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(RiwayatScoreFragment2.this,"Loading score","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

//                Toast.makeText(HasilQuizBaru.this,string1,Toast.LENGTH_LONG).show();
                convertJsonStringToArray(string1);
            }

            @Override
            protected String doInBackground(Void... params) {

                ServerProcessClass serverProcessClass = new ServerProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();
                //SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


                HashMapParams.put("user_id", String.valueOf(STATICUSER.USER.getUserID()));
                HashMapParams.put("level","medium");

                String FinalData = serverProcessClass.ServerHttpRequest(URL_SEND_HIGHSCORE, HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();

    }

    public void convertJsonStringToArray(String jsonString){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<String> listdata = new ArrayList<>();
        JSONArray jArray = null;
        listView=findViewById(R.id.list);
        dataModels= new ArrayList<>();

        try {
            jArray = jsonObject.getJSONArray("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                try {
                    String row = jArray.getString(i);
                    JSONObject rowObject = new JSONObject(row);
                    //Toast.makeText(HasilQuizBaru.this,rowObject.getString("username"),Toast.LENGTH_SHORT).show();
                    //listdata.add(jArray.getString(i));

                    dataModels.add(new ScoreModel(rowObject.getString("username"),  String.valueOf(rowObject.getInt("highscore")),rowObject.getString("highscore")));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        adapter= new ScoreAdapter(dataModels,getApplicationContext());
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(RiwayatScoreFragment2.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
