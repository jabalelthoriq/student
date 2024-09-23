package com.jabrix.student;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;


public class register extends AppCompatActivity {
    public static final String KEY_NAME = "KEY_NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registrasi);
        Bundle extras = getIntent().getExtras();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText edtTanggal, edtFullname, edtUsername, edtKonfirmasi, edtEmail, edtNim, edtPassword, edtAlamat, edtNohp;
        Spinner spinGender;
        Button btnRegistrasi;
        int tahun, bulan, tanggal;

        btnRegistrasi = findViewById(R.id.btn_registrasi);
        edtFullname = findViewById(R.id.edt_fullname);
        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        edtNim = findViewById(R.id.edt_nim);
        edtPassword = findViewById(R.id.edt_password);
        edtKonfirmasi = findViewById(R.id.edt_confir_password);
        edtAlamat = findViewById(R.id.edt_alamat);
        edtNohp = findViewById(R.id.edt_nohp);
        edtTanggal = findViewById(R.id.edt_date);


        edtTanggal.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(register.this, (view, year1, monthOfYear, dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                edtTanggal.setText(selectedDate);
            }, year, month, day);
            datePicker.show();
        });

        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = edtFullname.getText().toString();
                String username = edtUsername.getText().toString();
                String email = edtEmail.getText().toString();
                String nim = edtNim.getText().toString();
                String password = edtPassword.getText().toString();
                String konfirmasi = edtKonfirmasi.getText().toString();
                String tanggal = edtTanggal.getText().toString();
                String alamat = edtAlamat.getText().toString();
                String nohp = edtNohp.getText().toString();

                Toast.makeText(register.this, "Nama: " + fullname + ", email: " + email + ",username: " + username + ",nim: " + nim + ",password: " + password + ",konfimasi_password:" + konfirmasi + ",tanggal: " + tanggal + ",alamat: " + alamat + ",nohp: " + nohp + "", Toast.LENGTH_LONG).show();
                try {
                    if (email != "" && KEY_NAME != null) {
                        Intent i = new Intent(register.this, login2.class);
                        i.putExtra(KEY_NAME, email);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
