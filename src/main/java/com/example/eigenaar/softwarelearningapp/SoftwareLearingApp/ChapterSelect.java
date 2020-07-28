package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TableRow;

import com.example.eigenaar.softwarelearningapp.R;

public class ChapterSelect extends AppCompatActivity {

    TableRow tr1, tr2, tr3, tr4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list);

        tr1 = findViewById(R.id.TableRow1);
        tr2 = findViewById(R.id.TableRow2);
        tr3 = findViewById(R.id.TableRow3);
        tr4 = findViewById(R.id.TableRow4);

        tr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLessons();
            }
        });
        tr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLessons();
            }
        });
        tr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLessons();
            }
        });
        tr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLessons();
            }
        });




    }

    public void openLessons() {
        Intent intent = new Intent(this, lessons.class);
        startActivity(intent);
    }


}
