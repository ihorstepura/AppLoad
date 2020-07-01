package com.example.ihorstepura.appload;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private String res;
    private int i = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int n = intent.getIntExtra("number", 0);
        entruck(n, "slot_a", "slot_c", "slot_b");
    }

    private void entruck(int n, String fromTruck, String toTruck, String additionalPlace) {
        if (n == 0) return;
        entruck(n - 1, fromTruck, additionalPlace, toTruck);
        res = "#" + n + " " + fromTruck + " -> " + toTruck;
        method();
        entruck(n - 1, additionalPlace, toTruck, fromTruck);
    }

    @SuppressLint("SetTextI18n")
    private void method() {
        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        LayoutInflater layoutInflater = getLayoutInflater();
        LinearLayout itemLinearLayout = (LinearLayout) layoutInflater
                .inflate(R.layout.list_item, null, false);
        TextView textView = itemLinearLayout.findViewById(R.id.textView);
        textView.setText(res);
        TextView textView2 = itemLinearLayout.findViewById(R.id.textView2);
        textView2.setText("Действие: " + i);
        i++;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.
                LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(itemLinearLayout, params);
    }
}
