package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

    }

    public void showToast(View view) {
        Intent intent= new Intent(MainActivity.this, HelloActivity.class);
        intent.putExtra("count", String.valueOf(mCount));
        startActivity(intent);
    }

    public void countUp(View view) {
       if(mShowCount.getText().toString().equals("0"))
           mCount = 0;
       mCount++;
       mShowCount.setText(String.valueOf(mCount));
    }

}