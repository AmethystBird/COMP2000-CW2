package com.example.apiapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {
    public ArrayList<Projects> AllProjects;
    public Context context;

    //Acquire layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_projects, parent, false);
        return new ViewHolder(view);
    }

    //Mapping data from retrieved objects to recycle view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Projects ProjectsMapped2 = AllProjects.get(position);

        holder.studentIDViewText.setText(ProjectsMapped2.GetStudentIDAsStr());
        holder.titleViewText.setText(ProjectsMapped2.GetTitle());
        holder.descriptionViewText.setText(ProjectsMapped2.GetDescription());
        holder.yearViewText.setText(ProjectsMapped2.GetYearAsStr());
        holder.nameFirstViewText.setText(ProjectsMapped2.GetNameFirst());
        holder.nameLastViewText.setText(ProjectsMapped2.GetNameLast());
    }

    //Returns AllProjects size
    @Override
    public int getItemCount() {
        return AllProjects.size();
    }

    //Assigns existing views to objects
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentIDViewText, titleViewText, descriptionViewText, yearViewText, nameFirstViewText, nameLastViewText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            studentIDViewText = itemView.findViewById(R.id.studentIDViewText);
            titleViewText = itemView.findViewById(R.id.titleViewText);
            descriptionViewText = itemView.findViewById(R.id.descriptionViewText);
            yearViewText = itemView.findViewById(R.id.yearViewText);
            nameFirstViewText = itemView.findViewById(R.id.nameFirstViewText);
            nameLastViewText = itemView.findViewById(R.id.nameLastViewText);
        }
    }
}
