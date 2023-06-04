package com.example.apiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class HomeActivity extends AppCompatActivity {
    private String projectsURL = "web.socem.plymouth.ac.uk/COMP2000/api/students";
    private String projectsImageURL = "web.socem.plymouth.ac.uk/COMP2000/api/students/image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*TextView rawOutputTextView = findViewById(R.id.rawOutputTextView);
        DataAccess DataAccessProjects = new DataAccess();
        DataAccessProjects.DownloadProjects(projectsURL, rawOutputTextView);*/
    }

    public void ViewProjects(View view)
    {
        Intent homeToView = new Intent(this, ViewProjects.class);
        startActivity(homeToView);

        /*
        boolean success = false;
        try
        {
            TextView rawOutputTextView = findViewById(R.id.rawOutputTextView);

            MainActivity.class

            //DataAccess DataAccessProjects = new DataAccess();
            //DataAccessProjects.DownloadProjects(projectsURL, rawOutputTextView);
            success = true;
        }
        catch (Exception e)
        {
            TextView loginView = findViewById(R.id.subtitleTextMain2);
            loginView.setText(e.toString());
        }

        if (success == true) {
            Intent homeToView = new Intent(this, ViewProjects.class);
            startActivity(homeToView);
        }
        */
    }
}