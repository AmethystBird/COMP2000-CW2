package com.example.playermanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inputUsernameOrEmailLabel;
    TextView emailOrUsernamePrompt;
    TextView inputPasswordLabel;
    TextView passwordPrompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsernameOrEmailLabel = findViewById(R.id.inputUsernameOrEmailLabel);
        emailOrUsernamePrompt = findViewById(R.id.emailOrUsernamePrompt);
        inputPasswordLabel = findViewById(R.id.inputPasswordLabel);
        passwordPrompt = findViewById(R.id.passwordPrompt);
    }

    //Button generated activity transitions
    public void ActivityTransition(View view)
    {
        if (view.getId() == R.id.loginButton) //Login button clicked
        {
            boolean missingFields = false;
            if (inputUsernameOrEmailLabel.getText().toString().isEmpty()) //If the user has left the username or email TextView blank
            {
                emailOrUsernamePrompt.setText("Username or Email required.");
                missingFields = true;
            }
            else if (!emailOrUsernamePrompt.getText().toString().isEmpty())
            {
                emailOrUsernamePrompt.setText("");
            }
            if (inputPasswordLabel.getText().toString().isEmpty()) //If the user has left the password TextView blank
            {
                passwordPrompt.setText("Password is required.");
                missingFields = true;
            }
            else if (!passwordPrompt.getText().toString().isEmpty())
            {
                passwordPrompt.setText("");
            }

            if (missingFields == false) //If they have no missing fields
            {
                //ResetActivity();
                Intent activityTransition = new Intent(MainActivity.this, Scores.class);
                startActivity(activityTransition);
                //finish();
                //onRestart();
            }
        }
        else if (view.getId() == R.id.registerOptionButton) //Register option button clicked
        {
            //ResetActivity();
            Intent activityTransition = new Intent(MainActivity.this, Register.class);
            startActivity(activityTransition);
            //finish();
            //onRestart();
        }
    }
    
    public void ResetActivity()
    {
        //Clearing prompts
        inputUsernameOrEmailLabel.setText("");
        emailOrUsernamePrompt.setText("");
        inputPasswordLabel.setText("");
        passwordPrompt.setText("");
    }
}

/*
Button testButton = findViewById(R.id.loginButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                System.out.println("Button Clicked");
                testButton.setBackgroundColor(3);
            }
                    });
 */