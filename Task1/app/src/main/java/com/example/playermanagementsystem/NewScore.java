package com.example.playermanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_score);
    }

    //Button generated activity transitions
    public void ActivityTransition(View view)
    {
        //Not implemented yet
    }

    public void NewScoreInput(View view)
    {
        EditText scoreEditText = findViewById(R.id.inputNewScore);

        if (!scoreEditText.getText().toString().isEmpty())
        {

        }
    }
}