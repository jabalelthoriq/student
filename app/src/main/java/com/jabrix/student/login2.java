package com.jabrix.student;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import org.w3c.dom.Text;

public class login2 extends AppCompatActivity {
    private TextView txtButton;
    private String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(MainActivity.KEY_NAME)) {
                email = extras.getString(MainActivity.KEY_NAME);
            } else {
                email = "";
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtButton = findViewById(R.id.txt_register);

        txtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(login2.this, MainActivity.class);
                startActivity(r);
            }
        });
    }
}
