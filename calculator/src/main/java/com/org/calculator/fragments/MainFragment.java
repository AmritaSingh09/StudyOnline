package com.org.calculator.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.org.calculator.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private RecyclerView history;
    private TextView current, result, clr, clr_curr, per, div, mul, sub, add, dot, roo, equal,
            num9, num8, num7, num6, num5, num4, num3, num2, num1, num0;
    private double temp_result = 0.0, curr_num;
    private double fin_result = 0.0;
    char last_char='0';

    StringBuffer s, curr_no;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_main, container, false);
        initilizeViews(root);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        clr.setOnClickListener(this);
        clr_curr.setOnClickListener(this);
        per.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        sub.setOnClickListener(this);
        add.setOnClickListener(this);
        dot.setOnClickListener(this);
        roo.setOnClickListener(this);
        equal.setOnClickListener(this);
        temp_result=0;
        s.append("0");
        current.setText(s);
        result.setText("="+s);

        return root;
    }

    private synchronized void initilizeViews(View root) {

        history = root.findViewById(R.id.cal_his);
        current = root.findViewById(R.id.cal_curr);
        result = root.findViewById(R.id.cal_res);

        clr = root.findViewById(R.id.clr);
        clr_curr = root.findViewById(R.id.clr_curr);
        per = root.findViewById(R.id.per);
        div = root.findViewById(R.id.div);
        mul = root.findViewById(R.id.mul);
        sub = root.findViewById(R.id.sub);
        add = root.findViewById(R.id.add);
        dot = root.findViewById(R.id.dot);
        roo = root.findViewById(R.id.root);
        equal = root.findViewById(R.id.equal);

        num9 = root.findViewById(R.id.num9);
        num8 = root.findViewById(R.id.num8);
        num7 = root.findViewById(R.id.num7);
        num6 = root.findViewById(R.id.num6);
        num5 = root.findViewById(R.id.num5);
        num4 = root.findViewById(R.id.num4);
        num3 = root.findViewById(R.id.num3);
        num2 = root.findViewById(R.id.num2);
        num1 = root.findViewById(R.id.num1);
        num0 = root.findViewById(R.id.num0);

        s = new StringBuffer();

    }

    @Override
    public void onClick(View view) {
        last_char = s.charAt(s.length()-1);
        int val = ((TextView) view).getText().toString().charAt(0);

        switch (val) {
            case 'C' :
                clearAll();
                break;
            case 'X':
                clearlast();
                break;
            case '%':

                break;
            case '/' :
                s.append("/");
                break;
            case '*' :
                s.append("*");
                break;
            case '-' :
                s.append("-");
                break;
            case '+' :
                s.append("+");
                break;
            case '=' :

                break;
            case '.' :

                break;
            case '√' :

                break;
            case '0' :

                break;

            default:
                s.append(((TextView) view).getText().toString());
                curr_no.append(((TextView) view).getText().toString());
                break;
        }
        calculate(s,curr_no, ((TextView) view).getText().toString().charAt(0));
    }

    private void clearlast() {
        s.deleteCharAt(s.length()-1);
    }

    private void clearAll() {
        s = new StringBuffer();
        s.append("0");
    }

    private void calculate(StringBuffer s, StringBuffer currNo, char ch) {
        //switch ()
        //current.setText(s);
        //result.setText("="+s);
    }
}