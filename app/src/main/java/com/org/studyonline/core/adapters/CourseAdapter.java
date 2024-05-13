package com.org.studyonline.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.studyonline.R;
import com.org.studyonline.core.models.CourseModel;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    List<CourseModel> courseList;
    Context context;

    public CourseAdapter(List<CourseModel> courseList, Context context) {
        this.courseList = courseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_course,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (courseList != null)? courseList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
         }
     }
}
