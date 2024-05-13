package com.org.calculator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.org.calculator.fragments.FragmentConversions;
import com.org.calculator.fragments.FragmentMoney;
import com.org.calculator.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainCalculator extends AppCompatActivity {
    LinearLayout ctor_pip, ctor_cal, ctor_cat, ctor_money, ctor_more;
    private ImageView ctor_pip1, ctor_cal1, ctor_cal2, ctor_cat1, ctor_cat2, ctor_money1, ctor_money2, ctor_more1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        initialize();

        getSupportFragmentManager().beginTransaction().add(R.id.layout,new MainFragment()).commit();
        ctor_cal1.setVisibility(View.GONE);
        ctor_cal2.setVisibility(View.VISIBLE);
        ctor_pip.setOnClickListener(this::onClick);
        ctor_cal.setOnClickListener(this::onClick);
        ctor_cat.setOnClickListener(this::onClick);
        ctor_money.setOnClickListener(this::onClick);
        ctor_more.setOnClickListener(this::onClick);


    }

    public void onClick(View v){
        int id = v.getId();
        if (id == R.id.ctor_pip) {
            ctor_pip.setVisibility(View.VISIBLE);
            ctor_more.setVisibility(View.VISIBLE);

            ctor_cal2.setVisibility(View.VISIBLE);
            ctor_cal1.setVisibility(View.GONE);
            ctor_cat2.setVisibility(View.GONE);
            ctor_money2.setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction().replace(R.id.layout, new MainFragment(),"pip").commit();
            //todo: picture in picture mode

        } else
            if (id == R.id.ctor_cal) {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout, new MainFragment(),"cal").commit();
            ctor_pip.setVisibility(View.VISIBLE);
            ctor_more.setVisibility(View.VISIBLE);

            ctor_cal1.setVisibility(View.GONE);
            ctor_cal2.setVisibility(View.VISIBLE);
            ctor_cat1.setVisibility(View.VISIBLE);
            ctor_cat2.setVisibility(View.GONE);
            ctor_money1.setVisibility(View.VISIBLE);
            ctor_money2.setVisibility(View.GONE);

        } else
            if (id == R.id.ctor_cat) {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout, new FragmentConversions(),"cat").commit();
            ctor_pip.setVisibility(View.INVISIBLE);
            ctor_more.setVisibility(View.INVISIBLE);

            ctor_cal1.setVisibility(View.VISIBLE);
            ctor_cal2.setVisibility(View.GONE);
            ctor_cat1.setVisibility(View.GONE);
            ctor_cat2.setVisibility(View.VISIBLE);
            ctor_money2.setVisibility(View.GONE);
            ctor_money1.setVisibility(View.VISIBLE);

        } else
            if (id == R.id.ctor_money) {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout, new FragmentMoney(),"money").commit();
            ctor_pip.setVisibility(View.INVISIBLE);
            ctor_more.setVisibility(View.INVISIBLE);

            ctor_cal2.setVisibility(View.GONE);
            ctor_cal1.setVisibility(View.VISIBLE);
            ctor_cat2.setVisibility(View.GONE);
            ctor_cat1.setVisibility(View.VISIBLE);
            ctor_money2.setVisibility(View.VISIBLE);
            ctor_money1.setVisibility(View.GONE);

        } else
            if (id == R.id.ctor_more) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.layout, new MainFragment()).commit();


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*ctor_cal2.setVisibility(View.VISIBLE);
        ctor_cat2.setVisibility(View.GONE);
        ctor_money2.setVisibility(View.GONE);
        ctor_cal1.setVisibility(View.GONE);
        Toast.makeText(this, "Cu:"+ (getVisibleFragment() == null?"null":getVisibleFragment()), Toast.LENGTH_SHORT).show();*/
    }

    public String getVisibleFragment(){

        return getSupportFragmentManager().findFragmentById(R.id.layout).getClass().getSimpleName();

    }

    private void initialize() {
        ctor_pip = findViewById(R.id.ctor_pip);
        ctor_pip1 = findViewById(R.id.ctor_pip1);

        ctor_cal = findViewById(R.id.ctor_cal);
        ctor_cal1 = findViewById(R.id.ctor_cal1);
        ctor_cal2 = findViewById(R.id.ctor_cal2);

        ctor_cat = findViewById(R.id.ctor_cat);
        ctor_cat1 = findViewById(R.id.ctor_cat1);
        ctor_cat2 = findViewById(R.id.ctor_cat2);

        ctor_money = findViewById(R.id.ctor_money);
        ctor_money1 = findViewById(R.id.ctor_money1);
        ctor_money2 = findViewById(R.id.ctor_money2);

        ctor_more = findViewById(R.id.ctor_more);
        ctor_more1 = findViewById(R.id.ctor_more1);


        ctor_cal2.setVisibility(View.GONE);
        ctor_cat2.setVisibility(View.GONE);
        ctor_money2.setVisibility(View.GONE);
    }

}