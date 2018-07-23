package com.example.wanjianlun.discountcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    int discountPercentage;
    final int INITAL_DISCOUNT_PERCENTAGE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountPercentage = INITAL_DISCOUNT_PERCENTAGE;

        EditText edtCost = (EditText) findViewById(R.id.edtCost);
        edtCost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                displayResult();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
    public void displayResult(){
        double costNumber = 0;
        EditText edtCost= (EditText) findViewById(R.id.edtCost);
        String costText = edtCost.getText().toString();
        if (!costText.isEmpty()){
            costNumber= Double.parseDouble(costText);
        }
        double result = costNumber * discountPercentage/100;
        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        String messageResult = String.format(Locale.getDefault(), "$ %.2f", result);
        txtResult.setText(messageResult);
    }

    Button btnReset = (Button) findViewById(R.id.btnReset);
    btnReset.setOnClickListener(new View.OnClickListener()  {
            @Override
public void onClick(View view)  {
        //reset item cost
        EditText edtCost = (EditText) findViewById(R.id.edtCost);
        edtCost.setText(mull);
        edtCost.dispatchDisplayHint(View.VISISBLE);

        //reset Result
        }
            }


