package com.gavhane.b.vivek.a10truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView tv_question;
    Button b_true, b_false;

    Questions xyzQuestions;               //variable declaration of Question class
    int questionsLength;

    ArrayList<Item> questionsList;      // to fetch all questions and answers in here

    int currentQuestion = 0;
    boolean winner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_question = (TextView) findViewById(R.id.tv_question);
        b_true = (Button) findViewById(R.id.b_true);
        b_false = (Button) findViewById(R.id.b_false);

        xyzQuestions = new Questions();
        questionsLength = xyzQuestions.mQuestions.length;

        questionsList = new ArrayList<>();

        //save all the questions in the list
        for(int i =0; i < questionsLength ;i++){
            questionsList.add(new Item(xyzQuestions.getQuestion(i), xyzQuestions.getAnswer(i)));
        }

        //shuffle the questions
        Collections.shuffle(questionsList);

        //start the game
        setQuestion(currentQuestion);

        b_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkQuestion(currentQuestion)) {            // if (statement)   : here if statement returns true means answer is true and game will continue
                    //correct - the game continues
                    currentQuestion++;
                    if (currentQuestion < questionsLength) {
                        setQuestion(currentQuestion);
                    } else {
                        //wrong - the game ends
                        winner = true;
                        endGame();
                    }
                } else {
                //wrong - the game ends
                    endGame();
                }
            }
        });

        b_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkQuestion(currentQuestion)) {
                    //correct - the game continues
                    currentQuestion++;
                    if (currentQuestion < questionsLength) {
                        setQuestion(currentQuestion);
                    } else {
                        //wrong - the game ends
                        winner = true;
                        endGame();
                    }
                } else {
                    //wrong - the game ends
                    endGame();
                }
            }
        });
    }

    private void setQuestion(int number){
        tv_question.setText(questionsList.get(number).getQuestion());
    }

    //check if the answer is right
    private boolean checkQuestion(int number){
        String answer = questionsList.get(number).getAnswer();          //get method is from ArrayList   and   getAnswer is from Questions class
        return answer.equals("true");
    }

    //game over
    private void endGame(){
        if (winner){
            Toast.makeText(this, "Game over! You win!", Toast.LENGTH_SHORT).show();
            finish();       //This will end the application
        } else {
            Toast.makeText(this,"Game over! You lose!", Toast.LENGTH_SHORT).show();
            finish();          //This will end the application
        }
    }
}
