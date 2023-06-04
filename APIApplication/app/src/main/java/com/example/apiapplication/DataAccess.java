package com.example.apiapplication;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class DataAccess {

    //Hardcoded; will make dynamic eventually
    private String projectsURL = "http://web.socem.plymouth.ac.uk/COMP2000/api/students";
    private String projectsImageURL = "http://web.socem.plymouth.ac.uk/COMP2000/api/students/image";

    public String GetProjectsURL()
    {
        return projectsURL;
    }
    public String GetProjectsImageURL()
    {
        return projectsImageURL;
    }
}