package com.org.course.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.course.R;

import java.util.List;

public class ContentListAdapter extends RecyclerView.Adapter<ContentListAdapter.ViewHolder> {
    List<String> list;
    Context context;

    public ContentListAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_course_list,parent, false));
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
