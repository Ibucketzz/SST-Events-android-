package com.example.wanjianlun.scorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare variables
    int scorePlayer1;
    int scorePlayer2;
    TextView txtPlayer1;
    TextView txtPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        txtPlayer1 = (TextView) findViewById(R.id.txtScorePlayer1);
        txtPlayer2 = (TextView) findViewById(R.id.txtScorePlayer2);

    }

    void countScore(View v) {

        String myTag =v.getTag().toString();

        if(myTag.equals("player1")){

            scorePlayer1 = scorePlayer1 + 1 ;
            txtPlayer1.setText(String.valueOf(scorePlayer1));
        }
        else {

            scorePlayer2 = scorePlayer2 + 1;
            txtPlayer2.setText(String.valueOf(scorePlayer2));


        }

    void resetCounter(View v) {

        scorePlayer1 = 0;
        scorePlayer2 = 0;
        txtPlayer1 = (TextView) findViewById(R.id.txtScorePlayer1);
        txtPlayer2 = (TextView) findViewById(R.id.txtScorePlayer2);


    }

    }
}
