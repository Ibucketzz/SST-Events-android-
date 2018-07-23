package com.example.wanjianlun.sceneryshowcase;

import android.graphics.Color;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable[];
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //decalre variables
    Drawable myListOfPictures;
    TextView txtIntro;
    Button btnMore;
    int indexIntro;
    String PictureDisplayed;

    ArrayList<Integer> myNumbers;
    int indexNumbers;
    int myNewColorCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable[] myArrayOfPictures = getResources().getDrawable(R.drawable.nice_scene);
        myListOfPictures = new ArrayList<String>(Arrays.asList(myArrayOfPictures));

        txtIntro = (TextView) findViewById(R.id.txtIntro);
        btnMore = (Button) findViewById(R.id.btnMore);

        indexIntro = 0;
        Collections.shuffle(nice_scene);

        btnMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                displayNewPicture();
            }

            private void displayNewPicture() {
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
        int indexPictures;
        PictureDisplayed = myListOfPictures.get(indexPictures);
        indexPictures = indexPictures + 1;
        txtIntro.setText(PictureDisplayed);
        if (indexPictures==myListOfPictures.size()){
            indexPictures=0;
            Collections.shuffle(myListOfPictures);
        }

        myNewColorCode = Color.rgb(
                myNumbers.get(indexNumbers),
                myNumbers.get(indexNumbers +1),
                myNumbers.get(indexNumbers +2));

        indexNumbers ++;

        txtIntro.setBackgroundColor(myNewColorCode);
        btnMore.setTextColor(myNewColorCode);

        if (indexNumbers +2 == myNumbers.size ()){
            indexNumbers = 0;
            Collections.shuffle(myNumbers);
        }
    }
}
