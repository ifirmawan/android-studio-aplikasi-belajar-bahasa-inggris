package com.example.derysudrajat.appsbbi.Quiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.Quiz.Network.STATICUSER;
import com.example.derysudrajat.appsbbi.Quiz.Network.ServerProcessClass;
import com.example.derysudrajat.appsbbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HasilQuizBaru extends AppCompatActivity {

    //public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String KEY_HIGHSCORE = "keyHighscore";
    private final  String URL_SEND_HIGHSCORE = "http://bbi.rendyandriyanto.com/highscore.php";
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz_baru);
        //if (getIntent().hasExtra("user_id")){
            //Toast.makeText(HasilQuizBaru.this,getIntent().getStringExtra("user_id"),Toast.LENGTH_LONG).show();
        //}
        LoadHighScoreFromServer();
    }

    public void LoadHighScoreFromServer(){

        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(HasilQuizBaru.this,"Loading score","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

                //Toast.makeText(HasilQuizBaru.this,string1,Toast.LENGTH_LONG).show();
                convertJsonStringToArray(string1);
            }

            @Override
            protected String doInBackground(Void... params) {

                ServerProcessClass serverProcessClass = new ServerProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();
                //SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


                HashMapParams.put("user_id", String.valueOf(STATICUSER.USER.getUserID()));


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
        try {
            jArray = jsonObject.getJSONArray("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                try {
                    listdata.add(jArray.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        if(listdata.size() > 0){
            ListView lv = (ListView) findViewById(R.id.highscore_list_view);
            // Buat daftar dari larik element bertipe String
            final List<String> fruits_list = new ArrayList<String>(Arrays.<String>asList(String.valueOf(listdata)));
            // Buat sebuah Adapter Larik
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, fruits_list);
            // Menambahkan header pada list
            LayoutInflater inflater = getLayoutInflater();
            ViewGroup header = (ViewGroup)inflater.inflate(R.layout.listview_header,lv,false);
            lv.addHeaderView(header);

            // DataBind ListView with items from ArrayAdapter
            lv.setAdapter(arrayAdapter);
        }

    }
}
