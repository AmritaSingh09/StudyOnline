package com.org.studyonline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.org.admin.AdminMain;
import com.org.calculator.MainCalculator;
import com.org.course.ui.CourseActivityMain;
import com.org.studyonline.R;
import com.org.studyonline.core.adapters.CourseAdapter;
import com.org.studyonline.core.adapters.MentorAdapter;
import com.org.studyonline.core.adapters.SliderHome1;
import com.org.studyonline.core.models.CourseModel;
import com.org.studyonline.core.models.MentorModel;
import com.org.studyonline.ui.Calander.SimpleCalanderView;
import com.org.studyonline.ui.home.AboutUs;
import com.org.studyonline.ui.home.CustomerSupport;
import com.org.studyonline.ui.home.Doubts;
import com.org.studyonline.ui.home.Notifications;
import com.org.studyonline.ui.home.Profile;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView nav_view;
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

    private ViewPager top_slider;
    private LinearLayout top_dot_slider;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        hamb.setOnClickListener(view -> {
            drawerLayout.open();
        });


        loadSlider();

        not.setOnClickListener(v -> {
            //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, Notifications.class));
        });
//drawer navigation
        nav_view.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_about_us){
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_customer_support) {
                startActivity(new Intent(MainActivity.this, CustomerSupport.class));
            } else if (menuItem.getItemId() == R.id.nav_settings) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_personal_reminders) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_logout) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_doubts) {
                startActivity(new Intent(MainActivity.this, Doubts.class));
            } else if (menuItem.getItemId() == R.id.nav_study_material) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_quiz) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_library) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_results) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_attendance) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_events) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_course) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_profile) {
                startActivity(new Intent(MainActivity.this, Profile.class));
            } else if (menuItem.getItemId() == R.id.nav_calendar) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            } else if (menuItem.getItemId() == R.id.nav_notification) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
            return true;
        });
//Detail page listing
        category_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        course_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        study_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        mentor_all.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
//bottom navigation
        nav_home.setOnClickListener(v -> {
            //todo refresh the page
        });
        nav_study.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CourseActivityMain.class));
        });
        nav_chat.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        nav_todo.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SimpleCalanderView.class));
        });
        nav_profile.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Profile.class));
        });
//categories
        ct_course.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CourseActivityMain.class));
        });
        ct_event.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        ct_calculator.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainCalculator.class));
        });
        ct_library.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        ct_quiz.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        ct_calender.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
//addional listing
        library_card.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });

        btn_course_plan.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });

        course_material.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        course_mock.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        course_result.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        course_attendence.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });

        material_note.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        material_test.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        material_assignment.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });
        material_result.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AdminMain.class));
        });

        courseAdapter = new CourseAdapter(getCourseList(), MainActivity.this);
        courses.setAdapter(courseAdapter);

        mentorAdapter = new MentorAdapter(getMentorsList(), MainActivity.this);
        mentors.setAdapter(mentorAdapter);

    }

    private void loadSlider() {
        Integer[] images = {R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner2,
                R.drawable.banner1};

        SliderHome1 top_slider_adapter = new SliderHome1(this,images);
        top_slider.setClipToPadding(false);
        top_slider.setPadding(50,0,150,0);
        top_slider.setAdapter(top_slider_adapter);

        dotscount = top_slider_adapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            top_dot_slider.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        top_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        nav_view = findViewById(R.id.nav_view);

        //top
        hamb = findViewById(R.id.hamb);
        not = findViewById(R.id.not);
        name = findViewById(R.id.h_name);

        //middle
        btn_course_plan = findViewById(R.id.h_view_plan);

        top_slider =findViewById(R.id.top_slider);
        top_dot_slider = findViewById(R.id.top_dot_slider);

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

    @Override
    protected void onResume() {
        super.onResume();
        drawerLayout.close();
    }
}