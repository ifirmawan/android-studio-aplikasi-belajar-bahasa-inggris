package com.example.derysudrajat.appsbbi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
        etUname.setError("Username must be filled in");
        etPassword.setError("Password must be filled in");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (etUname.getText().toString().equals(etPassword.getText().toString())) {
                    Auth a = new Auth(getApplicationContext(), new User(etUname.getText().toString(), etPassword.getText().toString()), new Status() {
                        @Override
                        public void onLoginDone(User user) {
                            STATICUSER.USER = user;
                            Toast.makeText(getBaseContext(), "Hello " + user.getNama(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getBaseContext(), MainActivity.class));
                            finish();
                        }
                    });
                    a.login();
//                } else {
//                    Toast.makeText(getBaseContext(), "Username or Password is Wrong", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));

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

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
//                  finish();
                        LoginActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}

