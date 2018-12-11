package com.example.derysudrajat.appsbbi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.Quiz.Model.User;
import com.example.derysudrajat.appsbbi.Quiz.Network.Auth;
import com.example.derysudrajat.appsbbi.Quiz.Network.STATICUSER;
import com.example.derysudrajat.appsbbi.Quiz.Network.Status;

public class LoginActivity extends Activity {
    ImageView pict1;
    Button btnLogin;
    TextView tvRegister;
    EditText etUname, etPassword;
    CheckBox cbShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPassword = findViewById(R.id.etPassword);
        etUname = findViewById(R.id.etUname);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        cbShow = findViewById(R.id.cbShow);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Auth a = new Auth(getApplicationContext(), new User(etUname.getText().toString(), etPassword.getText().toString()), new Status() {
                    @Override
                    public void onLoginDone(User user) {
                        STATICUSER.USER = user;

                        Toast.makeText(getBaseContext(),"Hello " + user.getNama(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getBaseContext(),MainActivity.class));
                        finish();
                    }
                });
                a.login();
            }
        });
tvRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getBaseContext(),RegisterActivity.class));

    }
});
        cbShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    // show password
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });
    }

}

