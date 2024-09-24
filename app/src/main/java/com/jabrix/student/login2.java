package com.jabrix.student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class login2 extends AppCompatActivity {
    private static final String KEY_NAME = "KEY_NAME";

    private TextView registerTv;
    private Button loginBtn;
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login2);
        initViews();
        setupListeners();
        handleIntentExtras();
    }

    private void initViews() {
        registerTv = findViewById(R.id.txt_register);
        loginBtn = findViewById(R.id.btn_login);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
    }

    private void setupListeners() {
        registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(login2.this, register.class);
                startActivity(r);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void handleIntentExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(KEY_NAME)) {
                String email = extras.getString(KEY_NAME);
                edtEmail.setText(email);
            }
        }
    }

    public void login() {
        String enteredPassword = edtPassword.getText().toString();

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String storedPassword = prefs.getString("password", "");

        if (enteredPassword.equals(storedPassword)) {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(login2.this, MainActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
        }
    }
}