package com.example.wanjianlun.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    //declare variables
    TextView txtWordToBeGuessed;
    String wordToBeGuessed;
    String wordDisplayString;
    char[]wordDisplayCharArray;
    ArrayList<String>myListofWords;
    EditText edtInput;
    TextView txtLettersTried;
    String lettersTried;
    final String MESSAGE_WITH_LETTERS_TRIED = "Letters tried:";
    TextView txtTriesLeft;
    String triesLeft;
    final String WINNING_MESSAGE="You won!";
    final String LOSING_MESSAGE="You lost!";
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation scaleAndRotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        myListofWords = new ArrayList<String>();
        txtWordToBeGuessed = (TextView) findViewById(R.id.txtWordToBeGuessed);
        edtInput= (EditText) findViewById(R.id.edtInput);
        txtLettersTried = (TextView) findViewById(R.id.txtLettersTried);
        txtTriesLeft = (TextView) findViewById(R.id.txtTriesLeft);

        //traverse database file and populate array list
        InputStream myInputStream = null;
        Scanner in = null;
        String aWord="";

        try{
            myInputStream = getAssets().open("database_file.txt");
            in=new Scanner(myInputStream);
            while(in.hasNext()){
                aWord = in.next();
                myListofWords.add(aWord);

            }
        } catch (IOException e) {
            Toast.makeText(MainActivity.this,
                    e.getClass().getSimpleName() + ": " + e.getMessage(),
                    LENGTH_SHORT).show();
    }
    finally {
            //close Scanner
            if(in != null){
                in.close();
            }
            //close InputStream
            try {
                if(myInputStream != null) {
                    myInputStream.close();
                }
            } catch (IOException e) {
                Toast.makeText(MainActivity.this,
                        e.getClass().getSimpleName() + ": " + e.getMessage(),
                        Toast,LENGTH_SHORT).show();
            }
        }

    }
    void initializeGame() {
    //1.WORD
    //shuffle array list and get first element, then remove it
    Collections.shuffle(myListofWords);
    wordToBeGuessed = myListofWords.get(0);
    myListofWords.remove(0);

    //initialize char array
        char[] wordDisplayedCharArray = wordToBeGuessed.toCharArray();

    //add underscores
    for(int i = 1; i<wordDisplayedCharArray.length - 1;i++){
        wordDisplayCharArray[i]='_';
    }
    //reveal all occurrences of first character
        revealLetterInword(wordDisplayedCharArray[0]);

        //reveal all occurrences of last character
        revealLetterInword(wordDisplayedCharArray[wordDisplayedCharArray.length -1]);

        //initialize a string from this char array (for search purposes)
        wordDisplayString = String.valueOf(wordDisplayedCharArray);

        //display word
        displayWordOnScreen();
}
