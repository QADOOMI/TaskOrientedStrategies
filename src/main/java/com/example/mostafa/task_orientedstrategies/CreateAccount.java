package com.example.mostafa.task_orientedstrategies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mostafa.task_orientedstrategies.database.DatabaseHelper;

/**
 * Created by Mostafa on 4/21/2018.
 */

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

private Button createAcc;
private EditText email , pass , firstName , lastName , conPass;
private DatabaseHelper myData;
public static String name;
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_activity);

    createAcc = (Button)findViewById(R.id.create_acc_btn);
        email = (EditText)findViewById(R.id.email_input);
        pass = (EditText)findViewById(R.id.pass_input);
    firstName = (EditText)findViewById(R.id.first_name);
    lastName = (EditText)findViewById(R.id.last_name);
    conPass = (EditText)findViewById(R.id.con_pass);

createAcc.setOnClickListener(this);
        }

@Override
public void onClick(View v) {
    if (v.getId() == R.id.create_acc_btn
            && initUser().getPassword().trim().
            equals(conPass.getText().toString().trim())) {
        myData = new DatabaseHelper(getApplicationContext());

        if (myData.insert(initUser())) {
            name = String.valueOf(firstName.getText());
            Intent selector = new Intent(this, Login.class);
            selector.addCategory(Intent.CATEGORY_HOME);
            selector.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(selector);
            this.finish();
            Toast.makeText(getApplicationContext(), DatabaseHelper.message, Toast.LENGTH_LONG);
        } else
            Toast.makeText(getApplicationContext(), DatabaseHelper.message, Toast.LENGTH_LONG);
    }
}

    private User initUser(){
          return new User(String.valueOf(firstName.getText()) , String.valueOf(lastName.getText()),
                  String.valueOf(email.getText()) , String.valueOf(pass.getText()));
    }

        }
