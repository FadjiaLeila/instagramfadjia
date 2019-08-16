package com.example.instagram_fadjia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG  = "LoginActivity";
private EditText etUsername;
private EditText etPassword;
private Button btnLogin;
private Button btnSignUp;
private TextView tvAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etUsername);
        etPassword= findViewById(R.id.etPassword);
        tvAccount = findViewById(R.id.tvAccount);
        btnLogin= findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSignUpActivity();
            }
        });
    }

    private void goSignUpActivity() {
        Log.d(TAG, "Navigating to SignUpActivity");
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        finish();
    }

    private void login(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG,"Issue with login");
                    e.printStackTrace();
                    return;

                }
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    // do stuff with the user
                } else {
                    // show the signup or login screen
                }
                goMainActivity();
            }
        });

    }
    private void goMainActivity() {
        Log.d(TAG,"Navigating to Main Activity");
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();

    }
}
