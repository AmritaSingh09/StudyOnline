package com.org.studyonline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.org.admin.MainActivity2;
import com.org.calculator.MainCalculator;
import com.org.studyonline.R;
import com.org.studyonline.core.adapters.CourseAdapter;
import com.org.studyonline.core.adapters.MentorAdapter;
import com.org.studyonline.core.models.CourseModel;
import com.org.studyonline.core.models.MentorModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView hamb, not, btn_course_plan;
    private TextView name, course_name, course_duration, left_duration, working_days, price, left_price, course_desc,
            category_all, course_all, study_all, mentor_all ;
    private RecyclerView courses, mentors;
    private RelativeLayout material_note, material_test, material_assignment, material_result;
    private CardView library_card;
    private LinearLayout ct_course, ct_event, ct_calculator, ct_library, ct_quiz, ct_calender,
            course_material, course_mock, course_result, course_attendence,
            nav_home, nav_study, nav_chat, nav_todo, nav_profile;

    private CourseAdapter courseAdapter;
    private MentorAdapter mentorAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        hamb.setOnClickListener(view -> {
            drawerLayout.open();
        });
        not.setOnClickListener(v -> {
            //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, MainActivity2.class));

        });

        category_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        course_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        study_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        mentor_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        nav_home.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        nav_study.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        nav_chat.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        nav_todo.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        nav_profile.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        ct_course.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        ct_event.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        ct_calculator.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainCalculator.class));
        });
        ct_library.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        ct_quiz.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        ct_calender.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        library_card.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        btn_course_plan.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        course_material.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        course_mock.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        course_result.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        course_attendence.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        material_note.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        material_test.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        material_assignment.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
        material_result.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        courseAdapter = new CourseAdapter(getCourseList(), MainActivity.this);
        courses.setAdapter(courseAdapter);

        mentorAdapter = new MentorAdapter(getMentorsList(), MainActivity.this);
        mentors.setAdapter(mentorAdapter);

    }

    private synchronized List<CourseModel> getCourseList() {//todo add just < 5 courses
        List<CourseModel> list = new ArrayList<>();
        list.add(new CourseModel());
        list.add(new CourseModel());
        list.add(new CourseModel());
        list.add(new CourseModel());
        list.add(new CourseModel());
        list.add(new CourseModel());
        list.add(new CourseModel());
        list.add(new CourseModel());

        return list;
    }

    private synchronized List<MentorModel> getMentorsList() {//todo add just < 5 courses
        List<MentorModel> list = new ArrayList<>();
        list.add(new MentorModel());
        list.add(new MentorModel());
        list.add(new MentorModel());
        list.add(new MentorModel());
        list.add(new MentorModel());
        list.add(new MentorModel());
        list.add(new MentorModel());
        list.add(new MentorModel());

        return list;
    }

    private synchronized void initialize() {
        drawerLayout = findViewById(R.id.drawer_layout);

        //top
        hamb = findViewById(R.id.hamb);
        not = findViewById(R.id.not);
        name = findViewById(R.id.h_name);

        //middle
        btn_course_plan = findViewById(R.id.h_view_plan);

        course_name = findViewById(R.id.h_course);
        course_duration = findViewById(R.id.h_duration);
        left_duration = findViewById(R.id.h_left_duration);
        working_days = findViewById(R.id.h_working_days);
        price = findViewById(R.id.h_price);
        left_price = findViewById(R.id.h_left_price);
        course_desc = findViewById(R.id.h_course_desc);

        category_all = findViewById(R.id.h_category_all);
        course_all = findViewById(R.id.h_course_all);
        study_all = findViewById(R.id.h_study_all);
        mentor_all = findViewById(R.id.h_mentor_all);

        material_note = findViewById(R.id.h_material_note);
        material_test = findViewById(R.id.h_material_test);
        material_assignment = findViewById(R.id.h_material_assignment);
        material_result = findViewById(R.id.h_material_result);

        library_card = findViewById(R.id.h_library_card);

        course_material = findViewById(R.id.h_course_material);
        course_mock = findViewById(R.id.h_course_mock);
        course_result = findViewById(R.id.h_course_result);
        course_attendence = findViewById(R.id.h_course_attendence);

        ct_course = findViewById(R.id.h_ct_course);
        ct_event = findViewById(R.id.h_ct_event);
        ct_calculator = findViewById(R.id.h_ct_calc);
        ct_library = findViewById(R.id.h_ct_library);
        ct_quiz = findViewById(R.id.h_ct_quiz);
        ct_calender = findViewById(R.id.h_ct_calender);

        courses = findViewById(R.id.h_course_list);
        mentors = findViewById(R.id.h_mentor_list);

        //bottom-navigation
        nav_home = findViewById(R.id.h_btm_home);
        nav_study = findViewById(R.id.h_btm_study);
        nav_chat = findViewById(R.id.h_btm_chat);
        nav_todo = findViewById(R.id.h_btm_todo);
        nav_profile = findViewById(R.id.h_btm_profile);
    }

}