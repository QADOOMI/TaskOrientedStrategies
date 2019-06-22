package com.example.mostafa.task_orientedstrategies;

import android.content.Intent;
import android.database.Cursor;
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

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button login , createAcc;
    private EditText email , pass;
    private DatabaseHelper myData;
    private Cursor loginData;
    public static String savedPass , savedUsername;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        login = (Button)findViewById(R.id.login);
        email = (EditText)findViewById(R.id.email_text);
        pass = (EditText)findViewById(R.id.pass_text);
        createAcc = (Button)findViewById(R.id.create_acc);

        login.setOnClickListener(this);
        createAcc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login){
            myData = new DatabaseHelper(getApplicationContext());
            loginData = myData.login(email.getText().toString().trim(), pass.getText().toString().trim());

            if(loginData.moveToNext()){
                savedUsername = email.getText().toString().trim();
                savedPass = pass.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFUL", Toast.LENGTH_LONG);
                startActivity(new Intent(getApplicationContext() ,ListActivity.class));
            }
            else{
                email.setText(" ".trim());
                pass.setText(" ".trim());
                Toast.makeText(getApplicationContext(), "YOUR PERSONAL INFORMATION NOT EXISTS OR NOT CORRECT \n TRY AGAIN", Toast.LENGTH_LONG);
            }


                Toast.makeText(getApplicationContext(), DatabaseHelper.message, Toast.LENGTH_LONG);

        }
        else if(v.getId() == R.id.create_acc){
           startActivity(new Intent(this , CreateAccount.class));
        }
    }


}
