package com.example.apiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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

import java.util.ArrayList;

public class ViewProjects extends AppCompatActivity {

    //For retrieving data
    private Projects ProjectsMapped = new Projects();
    private RecyclerView ProjectsRecycler;
    private ProjectsAdapter ProjectsAdapter;
    private ArrayList<Projects> AllProjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_projects);

        //Initiates download
        DataAccess DataAccessProjects = new DataAccess();
        String projectsURL = DataAccessProjects.GetProjectsURL();
        DownloadProjects(projectsURL);
        //DisplayProjects();

        /*
        //References to existing views
        setContentView(R.layout.activity_view_projects);
        //ScrollView DataScrollView = findViewById(R.id.DataScrollView);
        //LinearLayout DataScrollLayout = findViewById(R.id.GetDSVLinearLayout);

        //Dynamically added text view
        TextView studentIDViewText = new TextView(this);
        studentIDViewText.setText(R.string.add_project_button);

        //Layout parameters
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        */

        //Assigns text view
        //studentIDViewText.setLayoutParams(params);
        //DataScrollLayout.addView(DataScrollLayout);
    }

    //Displays downloaded project information in scroll view
    public void DisplayProjects(JSONObject JSONResponse)
    {
        ProjectsAdapter = new ProjectsAdapter();
        ProjectsAdapter.AllProjects = AllProjects;
        ProjectsAdapter.context = ViewProjects.this;

        LinearLayoutManager manager = new LinearLayoutManager(this);
        ProjectsRecycler.setHasFixedSize(true);
        ProjectsRecycler.setLayoutManager(manager);
        ProjectsRecycler.setAdapter(ProjectsAdapter);

        /*ScrollView DataScrollView = findViewById(R.id.DataScrollView);

        TextView studentIDViewText = new TextView(this);
        studentIDViewText.setText(ProjectsMapped.GetStudentIDAsStr());
        DataScrollView.addView(studentIDViewText);

        TextView titleViewText = new TextView(this);
        titleViewText.setText(ProjectsMapped.GetTitle());
        DataScrollView.addView(titleViewText);

        TextView descriptionViewText = new TextView(this);
        descriptionViewText.setText(ProjectsMapped.GetDescription());
        DataScrollView.addView(descriptionViewText);

        TextView yearViewText = new TextView(this);
        yearViewText.setText(ProjectsMapped.GetYearAsStr());
        DataScrollView.addView(yearViewText);

        TextView nameFirstViewText = new TextView(this);
        nameFirstViewText.setText(ProjectsMapped.GetNameFirst());
        DataScrollView.addView(nameFirstViewText);

        TextView nameLastViewText = new TextView(this);
        nameLastViewText.setText(ProjectsMapped.GetNameLast());
        DataScrollView.addView(nameLastViewText);*/

        /*
        TextView studentIDViewText = findViewById(R.id.studentIDViewText);
        TextView titleViewText = findViewById(R.id.titleViewText);
        TextView descriptionViewText = findViewById(R.id.descriptionViewText);
        TextView yearViewText = findViewById(R.id.yearViewText);
        TextView nameFirstViewText = findViewById(R.id.nameFirstViewText);
        TextView nameLastViewText = findViewById(R.id.nameLastViewText);

        studentIDViewText.setText(ProjectsMapped.GetStudentIDAsStr());
        titleViewText.setText(ProjectsMapped.GetTitle());
        descriptionViewText.setText(ProjectsMapped.GetDescription());
        yearViewText.setText(ProjectsMapped.GetYearAsStr());
        nameFirstViewText.setText(ProjectsMapped.GetNameFirst());
        nameLastViewText.setText(ProjectsMapped.GetNameLast());
        */
    }

    public void DownloadProjects(String url) {
        if (url != null) {

            //Creates new queue
            RequestQueue queue = Volley.newRequestQueue(ViewProjects.this);

            //Creates GET request for JSON
            JsonArrayRequest projectsJSONArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Toast.makeText(ViewProjects.this, "Get request succeeded!", Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < response.length(); i++)
                    {
                        try
                        {
                            //Gets data
                            JSONObject JSONResponse = response.getJSONObject(i);
                            String StudentID = JSONResponse.getString("StudentID");
                            String Title = JSONResponse.getString("Title");
                            String Description = JSONResponse.getString("Description");
                            String Year = JSONResponse.getString("Year");
                            String First_Name = JSONResponse.getString("First_Name");
                            String Second_Name = JSONResponse.getString("Second_Name");

                            //Maps data
                            Projects CurrentProject = new Projects();
                            CurrentProject.SetStudentIDFromStr(JSONResponse.getString("StudentID"));
                            CurrentProject.SetTitle(JSONResponse.getString("Title"));
                            CurrentProject.SetDescription(JSONResponse.getString("Description"));
                            CurrentProject.SetYearFromStr(JSONResponse.getString("Year"));
                            CurrentProject.SetNameFirst(JSONResponse.getString("First_Name"));
                            CurrentProject.SetNameLast(JSONResponse.getString("Second_Name"));

                            //Adds data to array
                            AllProjects.add(CurrentProject);

                            //Displays stored data
                            DisplayProjects(JSONResponse);

                            /*
                            JSONObject JSONResponse = response.getJSONObject(i);
                            ProjectsMapped.SetStudentIDFromStr(JSONResponse.getString("StudentID"));
                            ProjectsMapped.SetTitle(JSONResponse.getString("Title"));
                            ProjectsMapped.SetDescription(JSONResponse.getString("Description"));
                            ProjectsMapped.SetYearFromStr(JSONResponse.getString("Year"));
                            ProjectsMapped.SetNameFirst(JSONResponse.getString("First_Name"));
                            ProjectsMapped.SetNameLast(JSONResponse.getString("Second_Name"));
                            DisplayProjects(JSONResponse);
                            */
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener()
            {
                //Error attempting GET request
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    error.printStackTrace();
                    Toast.makeText(ViewProjects.this, "GET request failed: " + error.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            //Adds JSON request to queue
            queue.add(projectsJSONArrayRequest);
        }
    }
}