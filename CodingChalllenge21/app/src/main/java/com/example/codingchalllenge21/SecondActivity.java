package com.example.codingchalllenge21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.text1);
        Intent intent = getIntent();
        int text = intent.getIntExtra("text", 0);
        tv.setText(getResources().getString(text));
    }
}
