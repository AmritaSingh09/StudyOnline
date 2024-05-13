package com.org.studyonline.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.studyonline.R;
import com.org.studyonline.core.models.CourseModel;
import com.org.studyonline.core.models.MentorModel;

import java.util.List;

public class MentorAdapter extends RecyclerView.Adapter<MentorAdapter.ViewHolder>{
    List<MentorModel> mentorList;
    Context context;

    public MentorAdapter(List<MentorModel> mentorList, Context context) {
        this.mentorList = mentorList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_mentor,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (mentorList != null) ? mentorList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
         }
     }
}
