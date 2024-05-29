package com.org.quiz.admin.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.org.quiz.R;

public class AllQuizListing extends AppCompatActivity {

    private RecyclerView quizzes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_quiz_listing);

        quizzes = findViewById(R.id.rv_admin_quiz);


        (findViewById(R.id.add_fab_quiz)).setOnClickListener(view -> {
            startActivity(new Intent(AllQuizListing.this, AddUpdate.class));
        });
    }
}