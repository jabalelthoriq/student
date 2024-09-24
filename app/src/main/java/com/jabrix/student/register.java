package com.jabrix.student;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class register extends AppCompatActivity {
    private static final String KEY_NAME = "KEY_NAME";
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtKonfirmasi;
    private Button btnRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registrasi);
        initViews();
        setupListeners();
    }

    private void initViews() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtKonfirmasi = findViewById(R.id.edt_confir_password);
        btnRegistrasi = findViewById(R.id.btn_registrasi);
    }

    private void setupListeners() {
        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRegistration();
            }
        });
    }

    private void handleRegistration() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String konfirmasi = edtKonfirmasi.getText().toString();

        if (email.matches(EMAIL_PATTERN) && password.equals(konfirmasi)) {
            SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            prefs.edit().putString("password", password).apply();
            Intent i = new Intent(register.this, login2.class);
            i.putExtra(KEY_NAME, email);
            startActivity(i);
        } else {
            Toast.makeText(this, "Invalid email or password mismatch", Toast.LENGTH_SHORT).show();
        }
    }
}