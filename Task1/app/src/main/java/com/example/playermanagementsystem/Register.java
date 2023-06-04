package com.example.playermanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    //Email
    EditText emailInput;
    TextView emailPrompt;

    //Full Name
    EditText fullNameInput;
    TextView fullNamePrompt;

    //Username
    EditText usernameInput;
    TextView usernamePrompt;

    //Password
    EditText inputPasswordLabel;
    TextView passwordPrompt2;

    //Password Re-Entry
    EditText passwordRetypeInput;
    TextView retypePasswordPrompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Email
        emailInput = findViewById(R.id.emailInput);
        emailPrompt = findViewById(R.id.emailPrompt);

        //Full Name
        fullNameInput = findViewById(R.id.fullNameInput);
        fullNamePrompt = findViewById(R.id.fullNamePrompt);

        //Username
        usernameInput = findViewById(R.id.usernameInput);
        usernamePrompt = findViewById(R.id.usernamePrompt);

        //Password
        inputPasswordLabel = findViewById(R.id.passwordInput);
        passwordPrompt2 = findViewById(R.id.passwordPrompt2);

        //Password Re-Entry
        passwordRetypeInput = findViewById(R.id.passwordRetypeInput);
        retypePasswordPrompt = findViewById(R.id.retypePasswordPrompt);
    }

    //Button generated activity transitions
    public void ActivityTransition(View view)
    {
        if (view.getId() == R.id.registerButton) //Login button clicked
        {
            boolean inapplicableFields = false;
            if (emailInput.getText().toString().isEmpty()) //If the user has left the username or email TextView blank
            {
                emailPrompt.setText("Username or Email required.");
                inapplicableFields = true;
            }
            else if (!emailPrompt.getText().toString().isEmpty())
            {
                emailPrompt.setText("");
            }
            if (fullNameInput.getText().toString().isEmpty()) //If the user has left the username or email TextView blank
            {
                fullNamePrompt.setText("Full Name required.");
                inapplicableFields = true;
            }
            else if (!fullNamePrompt.getText().toString().isEmpty())
            {
                fullNamePrompt.setText("");
            }
            if (usernameInput.getText().toString().isEmpty()) //If the user has left the username or email TextView blank
            {
                usernamePrompt.setText("Full Name required.");
                inapplicableFields = true;
            }
            else if (!usernamePrompt.getText().toString().isEmpty())
            {
                usernamePrompt.setText("");
            }

            //Fixing this up tomorrow; feeling ill atm
            String password = inputPasswordLabel.getText().toString();
            String passwordReType = passwordRetypeInput.getText().toString();

            //if ((inputPasswordLabel.getText().toString() != passwordRetypeInput.getText().toString()) && (!inputPasswordLabel.getText().toString().isEmpty() && !passwordRetypeInput.getText().toString().isEmpty()))
            //if ((inputPasswordLabel.getText().toString().equals(passwordRetypeInput.getText().toString())) && (!inputPasswordLabel.getText().toString().isEmpty() && !passwordRetypeInput.getText().toString().isEmpty()))
            if (((password.contentEquals(passwordReType)) == false) && (!inputPasswordLabel.getText().toString().isEmpty() && !passwordRetypeInput.getText().toString().isEmpty()))
            {
                passwordPrompt2.setText("Your password attempts do not match.");
                retypePasswordPrompt.setText("Your password attempts do not match.");
                inapplicableFields = true;
            }
            else
            {
                if (inputPasswordLabel.getText().toString().isEmpty()) //If the user has left the password TextView blank
                {
                    passwordPrompt2.setText("Password is required.");
                    inapplicableFields = true;
                }
                else if (!inputPasswordLabel.getText().toString().isEmpty()) //If the user has entered into the password TextView
                {
                    passwordPrompt2.setText("");
                }
                if (passwordRetypeInput.getText().toString().isEmpty()) //If the user has left the password TextView blank
                {
                    retypePasswordPrompt.setText("Password Re-Entry is required.");
                    inapplicableFields = true;
                }
                else if (!passwordRetypeInput.getText().toString().isEmpty()) //If the user has entered (by implication, a matching password) into the password TextView
                {
                    retypePasswordPrompt.setText("");
                }
            }

            if (inapplicableFields == false)
            {
                //ResetActivity();
                finish();
                Intent activityTransition = new Intent(Register.this, Scores.class);
                startActivity(activityTransition);
            }
        }
        else if (view.getId() == R.id.loginOptionButton) //Register option button clicked
        {
            //ResetActivity();
            finish();
            Intent activityTransition = new Intent(Register.this, MainActivity.class);
            startActivity(activityTransition);
        }
    }

    public void ResetActivity()
    {
        //Clearing prompts
        emailInput.setText("");
        emailPrompt.setText("");
        fullNameInput.setText("");
        fullNamePrompt.setText("");
        usernameInput.setText("");
        usernamePrompt.setText("");
        inputPasswordLabel.setText("");
        passwordPrompt2.setText("");
        passwordRetypeInput.setText("");
        retypePasswordPrompt.setText("");
    }
}