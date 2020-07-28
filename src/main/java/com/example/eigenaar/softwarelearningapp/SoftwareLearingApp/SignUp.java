package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eigenaar.softwarelearningapp.R;

public class SignUp extends AppCompatActivity {

    Button signUpBtn;
    EditText name, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        name = findViewById(R.id.fullName);
        password = findViewById(R.id.newPassword);
        email = findViewById(R.id.newEmail);

        signUpBtn = findViewById(R.id.signUpButton);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                new register().createUser(email.getText().toString(), name.getText().toString(), password.getText().toString());
                openChapterSelect();
            }

        });
    }

    public void openChapterSelect() {
        Intent intent = new Intent(this, ChapterSelect.class);
        startActivity(intent);
    }
}
