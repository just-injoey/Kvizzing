package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView question;
    Button yes, no;

    private String[] questionsArr = {"Java was developed in 1856?",
            "Java is Portable language?", "Java is a compiler based language?",
            "Java has Pointers?"};
    private boolean[] answerArr = {false, true, true, false};
    private int score = 0;
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question.setText(questionsArr[0]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the array is not going out of bounds
                if (index <= questionsArr.length - 1) {
                    // If you have given correct answer
                    if(answerArr[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index <= questionsArr.length - 1) {
                        question.setText(questionsArr[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questionsArr.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }


        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the array is not going out of bounds
                if (index <= questionsArr.length - 1) {
                    // If you have given correct answer
                    if(!answerArr[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index <= questionsArr.length - 1) {
                        question.setText(questionsArr[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questionsArr.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();

                }
            }
        });

//        if(index<=questionsArr.length-1){
//            yes.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(answerArr[index] == true){
//                        score++;
//                    }
//                    if(index<=questionsArr.length-1) {
//                        question.setText(questionsArr[++index]);
//                    }
//                }
//            });
//            no.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(answerArr[index] == false){
//                        score++;
//                    }
//                    if(index<=questionsArr.length-1) {
//                        question.setText(questionsArr[++index]);
//                    }
//                }
//            });
//        }
//        else{
//            Toast.makeText(this, "Score: "+score, Toast.LENGTH_SHORT).show();
//        }
    }
}