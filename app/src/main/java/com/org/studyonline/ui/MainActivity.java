package com.org.studyonline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.org.admin.MainActivity2;
import com.org.studyonline.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView hamb, not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hamb = findViewById(R.id.hamb);
        drawerLayout = findViewById(R.id.drawer_layout);

        hamb.setOnClickListener(view -> {
            drawerLayout.open();
        });

        not = findViewById(R.id.not);
        not.setOnClickListener(v -> {
            //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, MainActivity2.class));

        });




    }

}