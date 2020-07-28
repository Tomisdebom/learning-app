package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

import com.example.eigenaar.softwarelearningapp.R;

public class lessons extends AppCompatActivity {


    TableRow tr1, tr2, tr3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);


        tr1 = findViewById(R.id.TableRow1);
        tr2 = findViewById(R.id.TableRow2);
        tr3 = findViewById(R.id.TableRow3);


         tr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopic1();
            }
        });
        tr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopic2();
            }
        });
        tr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopic3();
            }
        });



    }

    public void openTopic1() {
        Intent intent = new Intent(this, lesson1.class);
        startActivity(intent);
    }

    public void openTopic2() {
        Intent intent = new Intent(this, lesson2.class);
        startActivity(intent);
    }

    public void openTopic3() {
        Intent intent = new Intent(this, lesson3.class);
        startActivity(intent);
    }


}
