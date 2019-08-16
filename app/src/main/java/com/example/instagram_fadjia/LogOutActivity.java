package com.example.instagram_fadjia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class LogOutActivity extends AppCompatActivity {
    private static final String TAG  = "LogOutActivity";
    private TextView tvLogOut;
    private TextView tvOr;
    private Button btnYes;
    private Button btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        tvLogOut = findViewById(R.id.tvLogOut);
        btnYes = findViewById(R.id.btnYes);
        tvOr = findViewById(R.id.tvOr);
        btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                goToLogInActivity();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    private void goToLogInActivity() {
        Log.d(TAG,"Navigating to Login Activity");
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }

}
