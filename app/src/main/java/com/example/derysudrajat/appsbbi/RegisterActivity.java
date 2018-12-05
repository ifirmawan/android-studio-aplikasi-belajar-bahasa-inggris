package com.example.derysudrajat.appsbbi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.Quiz.Model.User;
import com.example.derysudrajat.appsbbi.Quiz.Network.Auth;
import com.example.derysudrajat.appsbbi.Quiz.Network.Status;

public class RegisterActivity extends Activity {
    Button btnSignup;
    EditText etUname,etfullName, etPassword, etPasswordUlang ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUname = findViewById(R.id.etUname);
        etfullName = findViewById(R.id.etfullName);
        etPassword = findViewById(R.id.etPassword);
        etPasswordUlang = findViewById(R.id.etPasswordUlang);
        btnSignup =  findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(etPassword.getText().toString().equals(etPasswordUlang.getText().toString())){
                    Auth a = new Auth(getApplicationContext(), new User(etUname.getText().toString(), etPassword.getText().toString(),etfullName.getText().toString(),0,0), new Status() {
                        @Override
                        public void onLoginDone(User user) {
                            Toast.makeText(getBaseContext(),  user.getNama() + " berhasil terdaftar.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getBaseContext(),LoginActivity.class));
                            finish();
                        }
                    });
                    a.register();

                }
else{
                    Toast.makeText(getBaseContext(),"Password harus sama.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void goLogin(View view){
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

}
