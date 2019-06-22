package com.example.mostafa.task_orientedstrategies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class welcome extends AppCompatActivity {

    public static int isAllowed = 0;
    private Button haveFun, showSummary;
    private ImageView logo;
    private Animation ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ani = AnimationUtils.loadAnimation(this , R.anim.btn_ani);
        haveFun = (Button)findViewById(R.id.startBtn);
        showSummary = (Button)findViewById(R.id.showSummary);
        logo = (ImageView)findViewById(R.id.logo);

        showSummary.setAnimation(ani);
        haveFun.setAnimation(ani);

        ani = AnimationUtils.loadAnimation(this, R.anim.logo_ani);
        logo.setAnimation(ani);

        showSummary.setEnabled(false);

        haveFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome.this , Login.class));
            }
        });

    showSummary.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(welcome.this , Summary.class));
        }
    });
    }

    @Override
    protected void onStart() {
        super.onStart();

        isAllowed++;

        if(isAllowed > 1)
            showSummary.setEnabled(true);


    }


}
