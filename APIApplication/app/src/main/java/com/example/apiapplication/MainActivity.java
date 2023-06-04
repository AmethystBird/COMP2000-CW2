package com.example.apiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {
        TextView usernameView = findViewById(R.id.usernameText);
        TextView passwordView = findViewById(R.id.passwordText);

        try {
            if (usernameView.getText().toString().isEmpty() || passwordView.getText().toString().isEmpty()) //Username & password both correct
            {
                TextView signInError = findViewById(R.id.signInErrorText);
                signInError.setVisibility(View.VISIBLE);
                signInError.setText(R.string.sign_in_error_blank);
            } else if (!usernameView.getText().toString().isEmpty() && !passwordView.getText().toString().isEmpty()) {
                //Move to home page
                Intent mainToHome = new Intent(this, HomeActivity.class);
                startActivity(mainToHome);
            }
        } catch (Exception e) {
            TextView loginView = findViewById(R.id.subtitleTextMain);
            loginView.setText(e.toString());
        }
    }
}