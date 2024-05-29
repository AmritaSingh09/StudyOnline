package com.org.course.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.org.course.R;

public class CourseActivityMain extends AppCompatActivity {

    private ImageView hamb;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        Bundle metadata = new Bundle();
        metadata.putString("redirect", "Value Received is : nothing for some page");
        //top
        hamb = findViewById(R.id.hamb);
        hamb.setOnClickListener(view -> {
            drawerLayout.open();
        });

        (findViewById(R.id.c_ct_course)).setOnClickListener(vi -> {
            startActivity(new Intent(CourseActivityMain.this, AllCourseActivity.class), metadata);
        });

    }
}