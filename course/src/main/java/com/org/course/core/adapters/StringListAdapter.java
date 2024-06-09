package com.org.course.core.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.org.course.ui.NewCourseDetailActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListAdapter extends RecyclerView.Adapter<StringListAdapter.ViewHolder> {
    List<String> list;
    Context context;

    public StringListAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_string_listing,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String model = list.get(position);
        holder.str_cnt.setText(model);
    }

    @Override
    public int getItemCount() {
        return (list != null)? list.size() : 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView str_cnt;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             str_cnt = itemView.findViewById(R.id.str_cnt);
             itemView.setOnClickListener(this);
         }

        @Override
        public void onClick(View view) {
        }
    }
}
