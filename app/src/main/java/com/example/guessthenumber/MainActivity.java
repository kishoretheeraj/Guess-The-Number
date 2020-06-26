package com.example.guessthenumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    EditText number;
    TextView result;
    Button button;
    Random r;
    String message;
    int randomnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.editText);
        result = findViewById(R.id.textView3);
        button = findViewById(R.id.btn);
        generatenumber();

    }

    public void Guess(View view) {

        if(number.getText().toString().equals("")) {
            FancyToast.makeText(getApplicationContext(), "Enter a Number", FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();

        }
        else {
            Log.i("Info", Integer.toString(randomnumber));
            Log.i("Enter Number", result.getText().toString());

            int guessvalue = Integer.parseInt(number.getText().toString());

            if (guessvalue > randomnumber) {
                message = "Lower";
                result.setText(message);
                FancyToast.makeText(getApplicationContext(), "Try again! Lower", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
            } else if (guessvalue < randomnumber) {
                message = "Higher";
                result.setText(message);
                FancyToast.makeText(getApplicationContext(), "Try again! Higher", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
            } else {
                message = "Yes! The Number is ";
                generatenumber();
                result.setText(message+(guessvalue));
                FancyToast.makeText(getApplicationContext(), "Success", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

            }


        }

    }
    private void generatenumber() {
        Random random=new Random();
        randomnumber=random.nextInt(50-0)+0;


    }
}

