package com.org.studyonline.ui.Calander;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.org.studyonline.R;

public class SimpleCalanderView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_calander_view);

        CalenderView simpleCalendar = (CalenderView) findViewById(R.id.square_day);

        simpleCalendar.setUserCurrentMonthYear(6, 2024);

        simpleCalendar.setCallBack(view ->
                Toast.makeText(SimpleCalanderView.this, "Clicked Item is: "+view, Toast.LENGTH_SHORT).show());
    }
}