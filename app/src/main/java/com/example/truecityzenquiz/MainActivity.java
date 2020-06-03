package com.example.truecityzenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton prevButon;
    private TextView question;
    private int currentQustion=0;
    private Qustions[] quetionsBack=new Qustions[]{
            new Qustions(R.string.question_amendments, false), //correct: 27
            new Qustions(R.string.question_constitution, true),
            new Qustions(R.string.question_declaration, true),
            new Qustions(R.string.question_independence_rights, true),
            new Qustions(R.string.question_religion, true),
            new Qustions(R.string.question_government, false),
            new Qustions(R.string.question_government_feds, false),
            new Qustions(R.string.question_government_senators, true),
            //and add more!
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseButton=findViewById(R.id.false_button);
        trueButton=findViewById(R.id.true_button);
        nextButton=findViewById(R.id.next_button);
        prevButon=findViewById(R.id.prev_button);
        question=findViewById(R.id.answer_text);
        /*
        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
          case   R.id.false_button:
           checkAnswer(false);
            break;
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next_button:
                if(currentQustion < (quetionsBack.length-1)){
                    currentQustion=(currentQustion+1)%quetionsBack.length;
                    updateQustion();
                    break;
                }
                else{
                    Toast.makeText(MainActivity.this,"Last Question" , Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.prev_button:
                if (currentQustion > 0){
                currentQustion=(currentQustion-1)%quetionsBack.length;
                    updateQustion();
            }
                else{
                    Toast.makeText(MainActivity.this,"first Question" , Toast.LENGTH_SHORT).show();
                }



        }
    }
    public void updateQustion(){
        Log.d("Current","OnClick"+currentQustion);
        question.setText(quetionsBack[currentQustion].getAnserId());
    }
    private void checkAnswer(Boolean userAnswer){
        boolean answerIsTrue=quetionsBack[currentQustion].isAnserTrue();
        int toastMessageId;
        if(answerIsTrue==userAnswer){
            toastMessageId=R.string.correct_answer;
        }
        else{
            toastMessageId=R.string.wrong_answer;
        }
        Toast.makeText(MainActivity.this,toastMessageId , Toast.LENGTH_SHORT).show();
    }
}
