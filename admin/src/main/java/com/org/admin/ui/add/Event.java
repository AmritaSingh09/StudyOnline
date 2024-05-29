package com.org.admin.ui.add;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.org.admin.R;
import com.org.admin.core.models.EventModel;

import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity {

    RecyclerView rv_add_event;
    FloatingActionButton fb_add_event;

    List<EventModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event);

        rv_add_event = findViewById(R.id.rv_add_event);
        fb_add_event = findViewById(R.id.fb_add_event);

        modelList = new ArrayList<>();
        modelList.add(new EventModel("item1"));
        modelList.add(new EventModel("item2"));
        modelList.add(new EventModel("item3"));
        modelList.add(new EventModel("item4"));
        modelList.add(new EventModel("item15"));
        modelList.add(new EventModel("item6"));
        modelList.add(new EventModel("item7"));
        modelList.add(new EventModel("item8"));
        modelList.add(new EventModel("item9"));
        modelList.add(new EventModel("item10"));




    }
}