package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eigenaar.softwarelearningapp.R;

public class Correct extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correct);
        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapterSelect();
            }
        });

    }
    public void openChapterSelect() {
        Intent intent = new Intent(this, ChapterSelect.class);
        startActivity(intent);
    }
}
