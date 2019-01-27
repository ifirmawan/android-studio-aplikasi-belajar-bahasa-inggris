package  com.lusi.bbi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lusi.bbi.Quiz.Model.Penjelasan;
import com.lusi.bbi.Quiz.Network.ServerProcessClass;
import com.lusi.bbi.Quiz.penjelasanAdpater;
import com.lusi.bbi.R;
import com.lusi.bbi.Quiz.penjelasanAdpater;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pembahasan2Activity extends AppCompatActivity {

    private final  String URL_SEND_PENJELASAN = "http://bbi.rendyandriyanto.com/penjelasan.php";
    ArrayList<Penjelasan> dataModels;
    ListView listView;
    String level;
    private static penjelasanAdpater adapter;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembahasan2);
//        level = getExtraData("");
        if (getIntent().hasExtra("level")){ //2. menerima intent put extra
            level = getIntent().getStringExtra("level");
//        Toast.makeText(Pembahasan2Activity.this,getIntent().getStringExtra("level"),Toast.LENGTH_LONG).show();
        }
//        Toast.makeText(getApplicationContext(),String.valueOf(STATICUSER.USER.getId_level()),Toast.LENGTH_SHORT).show();
        LoadPenjelasanFromServer();
    }
    public void LoadPenjelasanFromServer(){
        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(Pembahasan2Activity.this,"Loading Explanation","Please Wait",false,false);
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
                HashMapParams.put("level","easy");


//                HashMapParams.put("level", String.valueOf(STATICUSER.USER.getLevel()));
//                Toast.makeText(Pembahasan2Activity.this.Toast.LENGTH_LONG).show();
//                Toast.makeText(HasilQuizBaru.this,rowObject.getString("id_level"),Toast.LENGTH_SHORT).show();

                String FinalData = serverProcessClass.ServerHttpRequest(URL_SEND_PENJELASAN, HashMapParams);

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
//                    Toast.makeText(Pembahasan2Activity.this,rowObject.getString("soal"),Toast.LENGTH_SHORT).show();
                    listdata.add(jArray.getString(i));

                    dataModels.add(new Penjelasan(rowObject.getString("soal"),  String.valueOf(rowObject.getString("jawab")),rowObject.getString("uraian")));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        adapter= new penjelasanAdpater(dataModels,getApplicationContext());
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Pembahasan2Activity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
