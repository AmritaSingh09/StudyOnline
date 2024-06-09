package com.org.course.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.org.course.R;
import com.org.course.core.adapters.CourseAdapter;
import com.org.course.core.models.CourseModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCourseActivity extends AppCompatActivity {

    RecyclerView all_course_list;

    List<CourseModel> courseModelList;
    EditText search_course;
    CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_course);

        all_course_list = findViewById(R.id.all_course_list);
        search_course = findViewById(R.id.search_course);

        courseModelList = new ArrayList<>();
        //List<String> cate = new ArrayList<>(Arrays.asList(cat))
        List<String> cate = new ArrayList<>(), lang = new ArrayList<>();
        cate.add("ML");
        cate.add("dl");
        cate.add("dsa");
        cate.add("RPA");
        cate.add("SOftware Enginnering");
        cate.add("Dev Ops");
        cate.add("Android Development");
        cate.add("Web Designer");

        lang.add("French");
        lang.add("Spanish");
        lang.add("English");
        lang.add("Japaniese");
        lang.add("Chienese");
        lang.add("Hindi");
        lang.add("Marathi");
        lang.add("Telgu");
        lang.add("Tamil");
        lang.add("Oodiya");

        courseModelList.add(new CourseModel("Machine Learning", "Amrita Kumari", "Short Description is here and will be described later",5.2f,cate.subList(2,3), lang.subList(2,3),"123", true));
        courseModelList.add(new CourseModel("Deep Learning", "Amrita Kumari", "Learn to create Deep Learning models in Python from two Machine Learning, Data Science experts. Code templates included.", 5.2f, cate.subList(0,2), lang.subList(0,2),"1234", true));
        courseModelList.add(new CourseModel("ANN Learning", "Amrita Kumari", "Learn to create Deep Learning models in Python from two Machine Learning, Data Science experts. Code templates included.", 5.2f, cate.subList(1,3), lang.subList(2,7),"1223", true));
        courseModelList.add(new CourseModel("DSA", "Amrita Kumari","Learn to create Deep Learning models in Python from two Machine Learning, Data Science experts. Code templates included.", 5.2f, cate.subList(4,7), lang.subList(2,10),"1423", true));
        courseModelList.add(new CourseModel("Machine Learning In Python and R", "Amrita Kumari", "Learn to create Deep Learning models in Python from two Machine Learning, Data Science experts. Code templates included.", 5.2f, cate, lang,"1273", true));
        courseModelList.add(new CourseModel("Software Engineering with agile using scrum", "Amrita Kumari", "Learn to create Deep Learning models in Python from two Machine Learning, Data Science experts. Code templates included.", 5.2f, cate.subList(2,3), lang.subList(1,7),"1283", true));
        courseModelList.add(new CourseModel("Data Structure and Algorithm", "Amrita Kumari","Learn to create Deep Learning models in Python from two Machine Learning, Data Science experts. Code templates included.", 5.2f, cate, lang.subList(2,3),"1243", true));

        adapter = new CourseAdapter(courseModelList, AllCourseActivity.this);

        all_course_list.setAdapter(adapter);
        search_course.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}