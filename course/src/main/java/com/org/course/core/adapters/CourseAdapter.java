package com.org.course.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.org.course.R;
import com.org.course.core.models.CourseModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> implements Filterable {
    List<CourseModel> courseList, filteredList;
    Context context;

    public CourseAdapter(List<CourseModel> courseList, Context context) {
        this.courseList = courseList;
        this.filteredList = courseList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_course_listing,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModel model = filteredList.get(position);
        holder.c_name.setText(model.getName());
        holder.c_author.setText(model.getAuthor());
        holder.c_lang.setText(model.getLanguages().stream().collect(Collectors.joining(",")));
        holder.c_dur.setText(model.getDuration()+" hours");
        holder.c_cate.setText(String.join(",", model.getCategories()));
    }

    @Override
    public int getItemCount() {
        return (filteredList != null)? filteredList.size() : 0;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String filText = charSequence.toString().toLowerCase();
                if (filText.isEmpty()){
                    filteredList = courseList;
                }else {
                    List<CourseModel> models = new ArrayList<>();
                    for (CourseModel model: courseList) {
                        if (model.getName().toLowerCase().contains(filText)||
                                model.getAuthor().toLowerCase().contains(filText)||
                                Arrays.toString(model.getCategories().toArray()).toLowerCase().contains(filText)||
                                Arrays.toString(model.getLanguages().toArray()).toLowerCase().contains(filText)||
                                model.getName().toLowerCase().contains(filText)){
                            models.add(model);
                        }
                        filteredList = models;
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (List<CourseModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView c_name, c_author,c_lang, c_dur, c_cate;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             c_name = itemView.findViewById(R.id.c_name);
             c_author = itemView.findViewById(R.id.c_author);
             c_lang = itemView.findViewById(R.id.c_lang);
             c_dur = itemView.findViewById(R.id.c_dur);
             c_cate = itemView.findViewById(R.id.c_cate);
         }
     }
}
