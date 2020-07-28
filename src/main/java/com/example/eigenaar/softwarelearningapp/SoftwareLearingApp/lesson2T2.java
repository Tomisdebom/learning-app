package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eigenaar.softwarelearningapp.R;

public class lesson2T2 extends AppCompatActivity {


    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_t2);

        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestion2();

            }
        });
    }
    public void openQuestion2() {
        Intent intent = new Intent(this, question2.class);
        startActivity(intent);
    }
}
