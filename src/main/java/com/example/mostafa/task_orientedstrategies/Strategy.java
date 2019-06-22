package com.example.mostafa.task_orientedstrategies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Mostafa on 3/23/2018.
 */

public class Strategy extends AppCompatActivity implements View.OnClickListener {
    private TextView barText, desc, levelText, exampleText, qus1, qus2;
    private Button submit, back;
    private RadioGroup groupQ1, groupQ2;
    private RadioButton ans1, ans2, ans3, ans4, ans11, ans22, ans33, ans44;
    private static int[] string = {R.array.level_1, R.array.level_2, R.array.level_3
            , R.array.level_4, R.array.level_5, R.array.level_6, R.array.level_7
            , R.array.level_8, R.array.level_9};
    private static int levels;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle level = getIntent().getExtras();
        setContentView(R.layout.first_stra);

        barText = (TextView) findViewById(R.id.textBar);
        desc = (TextView) findViewById(R.id.desc);
        levelText = (TextView) findViewById(R.id.levelText);
        exampleText = (TextView) findViewById(R.id.exampleText);
        qus1 = (TextView) findViewById(R.id.qus_1);
        qus2 = (TextView) findViewById(R.id.qus_1);

        submit = (Button) findViewById(R.id.submit_btn);
        back = (Button) findViewById(R.id.back);

        ans1 = (RadioButton) findViewById(R.id.r1);
        ans2 = (RadioButton) findViewById(R.id.r2);
        ans3 = (RadioButton) findViewById(R.id.r3);
        ans4 = (RadioButton) findViewById(R.id.r4);

        ans11 = (RadioButton) findViewById(R.id.r11);
        ans22 = (RadioButton) findViewById(R.id.r22);
        ans33 = (RadioButton) findViewById(R.id.r33);
        ans44 = (RadioButton) findViewById(R.id.r44);

        groupQ1 = (RadioGroup) findViewById(R.id.q_1_ans_1_group);
        groupQ2 = (RadioGroup) findViewById(R.id.q_2_ans_1_group);

        String[] strings = null;

        levels = level.getInt(KeyWord.level);
        switch (level.getInt(KeyWord.level)) {
            case 1:
                strings = this.getResources().getStringArray(R.array.level_1);
                setContentText(strings);
                break;

            case 2:
                strings = this.getResources().getStringArray(R.array.level_2);
                setContentText(strings);
                break;

            case 3:
                strings = this.getResources().getStringArray(R.array.level_3);
                setContentText(strings);
                break;

            case 4:
                strings = this.getResources().getStringArray(R.array.level_4);
                setContentText(strings);
                break;

            case 5:
                strings = this.getResources().getStringArray(R.array.level_5);
                setContentText(strings);
                break;

            case 6:
                strings = this.getResources().getStringArray(R.array.level_6);
                setContentText(strings);
                break;

            case 7:
                strings = this.getResources().getStringArray(R.array.level_7);
                setContentText(strings);
                levels = 7;
                break;

            case 8:
                strings = this.getResources().getStringArray(R.array.level_8);
                setContentText(strings);
                break;

            case 9:
                strings = this.getResources().getStringArray(R.array.level_9);
                setContentText(strings);
                break;
        }
        Log.d("Strategy", "" + levels);
        submit.setOnClickListener(this);

        back.setOnClickListener(this);
    }


    void setContentText(String[] strings) {
        barText.setText(strings[0]);
        levelText.setText(strings[1]);
        desc.setText(strings[2]);
        exampleText.setText(strings[3]);
        qus1.setText(strings[4]);
        ans1.setText(strings[5]);
        ans2.setText(strings[6]);
        ans3.setText(strings[7]);
        ans4.setText(strings[8]);
        qus2.setText(strings[9]);
        ans11.setText(strings[10]);
        ans22.setText(strings[11]);
        ans33.setText(strings[12]);
        ans44.setText(strings[13]);
    }


    @Override
    public void onClick(View v) {


        Bundle level = this.getIntent().getExtras();
        if (submit.getText().equals("NEXT") && (levels >= 1 && levels < 9)) {
            Log.d("Strategy", "" + levels);
            this.setContentText(this.getResources().getStringArray(string[levels]));
            Log.d("Strategy", "gg" + levels);
            levels++;
            groupQ2.clearCheck();
            groupQ1.clearCheck();
            submit.setText("SUBMIT ANSWER");
        } else {
            String[] strings = null;
            Intent i = new Intent(Strategy.this, PopUp.class);
            Log.d("Strategy", "" + levels);
            switch (levels) {
                case 1:
                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);
                        if (ans2.isChecked() && ans11.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            setStateText("Score: 5/5");
                            KeyWord.scores[levels - 1] = 5f;
                        } else if ((!ans2.isChecked() && ans11.isChecked()) || (ans2.isChecked() && !ans11.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            setStateText("Score: 2.5/5");
                            KeyWord.scores[levels - 1] = 2.5f;
                        } else if (!(ans2.isChecked() && ans11.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);

                        }
                        startActivity(i);
                    }
                    break;
                case 2:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);
                        if (ans2.isChecked() && ans22.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans2.isChecked() && ans22.isChecked()) || (ans2.isChecked() && !ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans2.isChecked() && ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }

                        startActivity(i);
                    }
                    break;

                case 3:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);

                        if (ans2.isChecked() && ans11.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans2.isChecked() && ans11.isChecked()) || (ans2.isChecked() && !ans11.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans2.isChecked() && ans11.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        startActivity(i);
                    }
                    break;

                case 4:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);

                        if (ans3.isChecked() && ans22.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans3.isChecked() && ans22.isChecked()) || (ans3.isChecked() && !ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans3.isChecked() && ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        startActivity(i);
                    }
                    break;

                case 5:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);

                        if (ans3.isChecked() && ans22.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans3.isChecked() && ans22.isChecked()) || (ans3.isChecked() && !ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans3.isChecked() && ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        startActivity(i);
                    }
                    break;

                case 6:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);

                        if (ans1.isChecked() && ans22.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans1.isChecked() && ans22.isChecked()) || (ans1.isChecked() && !ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans1.isChecked() && ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        startActivity(i);
                    }
                    break;

                case 7:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);

                        if (ans1.isChecked() && ans22.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans1.isChecked() && ans22.isChecked()) || (ans1.isChecked() && !ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans1.isChecked() && ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        startActivity(i);
                    }
                    break;

                case 8:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);
                        if (ans2.isChecked() && ans11.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans2.isChecked() && ans11.isChecked()) || (ans2.isChecked() && !ans11.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            Strategy.this.startActivity(i);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans2.isChecked() && ans11.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        startActivity(i);
                    }
                    break;

                case 9:

                    if (groupQ1.getCheckedRadioButtonId() != -1 && groupQ2.getCheckedRadioButtonId() != -1) {
                        submit.setEnabled(true);
                        if (ans2.isChecked() && ans22.isChecked()) {
                            i.putExtra(KeyWord.starsNum, 5);
                            Strategy.this.submit.setText("NEXT");
                            KeyWord.scores[levels - 1] = 5f;
                            setStateText("Score: 5/5");
                        } else if ((!ans2.isChecked() && ans22.isChecked()) || (ans2.isChecked() && !ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 2);
                            KeyWord.scores[levels - 1] = 2.5f;
                            setStateText("Score: 2.5/5");
                        } else if (!(ans2.isChecked() && ans22.isChecked())) {
                            i.putExtra(KeyWord.starsNum, 0);
                        }
                        i.putExtra(KeyWord.goToSummary, "level9");
                        startActivity(i);
                    }
                    break;
            }
        }

        if (levels > 0 && v.getId() == R.id.back) {
            --levels;
            Strategy.this.setContentText(Strategy.this.getResources().getStringArray(string[levels]));
        }

    }


    public void setStateText(String score) {
        if (score.equals("Score: 2.5/5")) {
            ListActivity.getItems().get(levels - 1).setScore("Score: 2.5/5");
            ListActivity.setAdapter(ListActivity.getItems());
            ListActivity.getList().setAdapter(ListActivity.getAdapter());
            KeyWord.scores[levels - 1] = 2.5f;
        } else if (score.equals("Score: 5/5")) {
            ListActivity.getItems().get(levels - 1).setScore("Score: 5/5");
            ListActivity.setAdapter(ListActivity.getItems());
            ListActivity.getList().setAdapter(ListActivity.getAdapter());
            KeyWord.scores[levels - 1] = 5f;
        }

    }

}