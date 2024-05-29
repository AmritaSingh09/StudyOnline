package com.org.quiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    RecyclerView rv_quiz;
    QuizAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        rv_quiz = findViewById(R.id.rv_quiz);
        List<String> data = new ArrayList<>();
        data.add(1,"Question 1");
        data.add(2, "1 Option 1");
        data.add(3, "1 Option 2");
        data.add(4, "1 Option 3");
        data.add(5, "1 Option 4");
        data.add("1 Option 5");
        data.add("Question 2");
        data.add("2 Option 1");
        data.add("2 Option 2");
        data.add("Question 3");
        data.add("Option 1");
        data.add("Option 2");
        data.add("Question 4");
        data.add("Option 1");



        adapter = new QuizAdapter(QuizActivity.this, data);
        rv_quiz.setAdapter(adapter);

    }
}