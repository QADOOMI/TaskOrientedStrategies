package com.example.mostafa.task_orientedstrategies;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Mostafa on 4/9/2018.
 */

public class Summary extends AppCompatActivity{
    private final TextView allScores[] = new TextView[11];
    private Button home;
    private RatingBar totalStars;
    private float totalScore;
    float starsRate = 0f;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        allScores[9] = (TextView)findViewById(R.id.total_state_score);
        allScores[10] = (TextView)findViewById(R.id.total_score);
        allScores[0] = (TextView)findViewById(R.id.str_1_score);
        allScores[1] = (TextView)findViewById(R.id.str_2_score);
        allScores[2] = (TextView)findViewById(R.id.str_3_score);
        allScores[3] = (TextView)findViewById(R.id.str_4_score);
        allScores[4] = (TextView)findViewById(R.id.str_5_score);
        allScores[5] = (TextView)findViewById(R.id.str_6_score);
        allScores[6] = (TextView)findViewById(R.id.str_7_score);
        allScores[7] = (TextView)findViewById(R.id.str_8_score);
        allScores[8] = (TextView)findViewById(R.id.str_9_score);
        home = (Button)findViewById(R.id.home);
        totalStars = (RatingBar)findViewById(R.id.total_rate);

        LayerDrawable stars = (LayerDrawable)totalStars.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.rgb(255,215,0), PorterDuff.Mode.SRC_ATOP);

        for (int i = 0; i < KeyWord.scores.length; i++) {
            totalScore += KeyWord.scores[i];
            allScores[i].setText("Strategey #" + (i + 1) + " : " + KeyWord.scores[i] + "/5");
    }


        if(totalScore >= 22.5 && totalScore <= 32.5){
            allScores[9].setText("Congratulations " + CreateAccount.name + " passed");
            allScores[10].setText("Total Score : " + totalScore + "/45");
            starsRate = 2.5f;
        }
        else if(totalScore > 32.5 && totalScore <= 40){
            allScores[9].setText("Congratulations " + CreateAccount.name + " passed");
            allScores[10].setText("Total Score : " + totalScore + "/45");
            starsRate = 3.5f;
        }
        else if(totalScore > 40 && totalScore <= 45){
            allScores[9].setText("Congratulations " + CreateAccount.name + " passed");
            allScores[10].setText("Total Score : " + totalScore + "/45");
            starsRate = 5f;
        }
        else if(totalScore < 22.5 && totalScore >= 0){
            allScores[9].setText("Give it more effort" + CreateAccount.name);
            allScores[10].setText("Total Score : " + totalScore + "/45");
        }

                totalStars.setRating((float)starsRate);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selector = new Intent(Summary.this, ListActivity.class);
                selector.addCategory(Intent.CATEGORY_HOME);
                selector.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(selector);
            }
        });

    }
    /*
    public void check(double a,double b,float c){

        if(totalScore >=a&& totalScore <= b){
            allScores[9].setText("Congratulations " + CreateAccount.name + " passed");
            allScores[10].setText("Total Score : " + totalScore + "/45");
            starsRate = c;
        }
    }
    */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        for(int i = 0 ; i < KeyWord.scores.length ; i++)
            savedInstanceState.putString("mark"+i , (String) allScores[i].getText());

        savedInstanceState.putFloat("numOfStars" , totalStars.getRating());
        savedInstanceState.putString("wholeState" , (String)allScores[9].getText());
        savedInstanceState.putString("wholeScore" , (String)allScores[10].getText());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        for(int i = 0 ; i < KeyWord.scores.length ; i++) {
            allScores[i].setText(savedInstanceState.getString("mark"+i));
        }

        allScores[9].setText(savedInstanceState.getString("wholeState"));
        allScores[10].setText(savedInstanceState.getString("wholeScore"));
        totalStars.setRating((float)savedInstanceState.getFloat("numOfStars"));

    }

}
