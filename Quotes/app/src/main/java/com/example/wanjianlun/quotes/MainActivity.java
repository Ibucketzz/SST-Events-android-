package com.example.wanjianlun.quotes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //decalre variables
    ArrayList<String> myListOfQuotes;
    TextView txtQuotes;
    Button btnSeeMore;
    int indexQuotes;
    String quoteDisplayed;

    ArrayList<Integer>myNumbers;
    int indexNumbers;
    int myNewColorCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myArrayOfQuotes = getResources().getStringArray(R.array.myQuotes);
        myListOfQuotes = new ArrayList<String>(Arrays.asList(myArrayOfQuotes));

        txtQuotes = (TextView) findViewById(R.id.txtQuotes);
        btnSeeMore = (Button) findViewById(R.id.btnSeeMore);

        indexQuotes = 0;
        Collections.shuffle(myListOfQuotes);

        btnSeeMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                displayNewQuote();
            }
        });

        indexNumbers = 0;
        myNumbers = new ArrayList<Integer>();
        for (int i = 0; i <= 255; i = +1) {
            myNumbers.add(i);
        }
        Collections.shuffle(myNumbers);
        }
    void displayNewQuote(){
        quoteDisplayed = myListOfQuotes.get(indexQuotes);
        indexQuotes = indexQuotes + 1;
        txtQuotes.setText(quoteDisplayed);
        if (indexQuotes==myListOfQuotes.size()){
            indexQuotes=0;
            Collections.shuffle(myListOfQuotes);
        }

        myNewColorCode = Color.rgb(
                myNumbers.get(indexNumbers),
                myNumbers.get(indexNumbers +1),
                myNumbers.get(indexNumbers +2));

        indexNumbers ++;

        txtQuotes.setBackgroundColor(myNewColorCode);
        btnSeeMore.setTextColor(myNewColorCode);

        if (indexNumbers +2 == myNumbers.size ()){
            indexNumbers = 0;
            Collections.shuffle(myNumbers);
        }
    }
}
