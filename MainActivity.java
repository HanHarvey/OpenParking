package com.example.worktable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView Info;
    private Button Login;
    private int counter = 3;

    private void validate(String userName, String password){
        if((userName.equals("Admin"))&& (password.equals("123456"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else{
            counter--;
            Info.setText("Number of attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.button_login);

        Info.setText("Number of attempts remaining: 5");
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }
}
