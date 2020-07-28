package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

import com.example.eigenaar.softwarelearningapp.R;

public class question1 extends AppCompatActivity {

    TableRow tr1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        tr1 = findViewById(R.id.TableRow1);

        tr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCorrect();
            }
        });



    }

    public void openCorrect() {
        Intent intent = new Intent(this, Correct.class);
        startActivity(intent);
    }
}
