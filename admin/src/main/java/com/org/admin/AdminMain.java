package com.org.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.org.admin.ui.add.Event;

public class AdminMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_main);

        Toast.makeText(this, "Hello From Admin", Toast.LENGTH_SHORT).show();

        (findViewById(R.id.add_h_ct_event)).setOnClickListener(view ->{
            startActivity(new Intent(AdminMain.this, Event.class));
        });

    }
}