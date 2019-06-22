package com.example.mostafa.task_orientedstrategies;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Mostafa on 3/23/2018.
 */

public class PopUp extends AppCompatActivity {

   private RatingBar rate ;
    private Button ok;
    private TextView state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_popup);

        DisplayMetrics d = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(d);

        getWindow().setLayout((int)(d.heightPixels * 0.55) , (int)(d.widthPixels * 0.6));

        rate = (RatingBar)findViewById(R.id.ratingBar);
        ok = (Button)findViewById(R.id.ok);
        state = (TextView) findViewById(R.id.state);

        ok.setClickable(false);
        rate.setNumStars(5);
        // TO CHANGE THE COLOR OF STARS IN RATING BAR
        LayerDrawable stars = (LayerDrawable) rate.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.rgb(255,215,0), PorterDuff.Mode.SRC_ATOP);

          Bundle values = getIntent().getExtras();
          if(values.getInt(KeyWord.starsNum) == 5){
              state.setText("Congratulations YOU EARNED FULL MARK");
              rate.setRating((float) 5);
          }
          else if(values.getInt(KeyWord.starsNum) == 2){
              state.setText("Way To Go, Try Again");
              rate.setRating((float) 2.5);
          }
          else if(values.getInt(KeyWord.starsNum) == 0){
              state.setText("You Lost, Give it More Effort");
          }



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.this.finish();

                Bundle values = getIntent().getExtras();
                if(values.getString(KeyWord.goToSummary) != null)
                    startActivity(new Intent(PopUp.this , Summary.class));

            }
        });

    }
}
