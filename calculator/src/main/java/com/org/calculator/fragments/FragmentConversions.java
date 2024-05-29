package com.org.calculator.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.org.calculator.R;

public class FragmentConversions extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_conversions, container, false);

        //length, data, area, mass, number system, speed, temp, time, volume  ==> same layout
        ((LinearLayout) root.findViewById(R.id.cal_len)).setOnClickListener(view -> {

        });

        ((LinearLayout) root.findViewById(R.id.cal_weight)).setOnClickListener(view -> {

        });

        ((LinearLayout) root.findViewById(R.id.cal_temp)).setOnClickListener(view -> {

        });

        ((LinearLayout) root.findViewById(R.id.cal_time)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_area)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_vol)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_speed)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_age)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_bmi)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_num)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_date)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_data)).setOnClickListener(view -> {

        });
        ((LinearLayout) root.findViewById(R.id.cal_discount)).setOnClickListener(view -> {

        });




        return root;
    }
}