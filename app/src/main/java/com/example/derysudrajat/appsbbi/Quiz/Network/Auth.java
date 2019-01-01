package com.example.derysudrajat.appsbbi.Quiz.Network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.derysudrajat.appsbbi.Quiz.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Auth {
    private Context context;

    private User user;
    private Status statusListener;
    private final String BASE_URL = "http://192.168.43.80/bbi";
    private final String URL_LOGIN = BASE_URL+"/login.php";
    private final  String URL_REGISTER = BASE_URL+"/register.php";

    private String errorMessage;
    public User getUser() {
        return user;
    }

    public Auth(Context context, User user, Status status) {
        this.context = context;
        this.user = user;
        this.statusListener = status;
    }

    public void login(){

        StringRequest s = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("COBALOGIN",response);
                User u = new ResponseParser(response).getParsedResponse();
                if (u!=null){
                statusListener.onLoginDone(u);}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("COBALOGIN",error.getMessage());
                errorMessage = error.getMessage();


            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", user.getUsername());
                params.put("password",user.getPassword());

                return params;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(s);
    }

    public void register(){
        StringRequest s = new StringRequest(Request.Method.POST, URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("COBALOGIN",response);
                User u = new ResponseParser(response).getParsedResponse();
                if (u!=null){
                    statusListener.onLoginDone(u);}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("COBALOGIN",error.getMessage());
                errorMessage = error.getMessage();


            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", user.getUsername());
                params.put("password",user.getPassword());
                params.put("nama",user.getNama());
                return params;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(s);

    }
    class ResponseParser{
        private String response;
        public ResponseParser(String re){
            this.response = re;
        }
        public User getParsedResponse(){
            try {
                JSONObject jsonObject = new JSONObject(response);
                User user = new User();
                user.setNama(jsonObject.getString("nama"));
                user.setUsername(jsonObject.getString("username"));
                user.setUserID(jsonObject.getString("id"));
                return  user;
            }catch(JSONException jso){
                Log.e("COBALOGIN",jso.getMessage());
            return null;
            }

        }
    }
}