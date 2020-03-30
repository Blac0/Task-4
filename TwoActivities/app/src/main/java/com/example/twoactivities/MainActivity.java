package com.example.twoactivities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE= "com.example.android.twoactivities.extra.MESSAGE";
    private EditText et;
    public static final int TEXT_REQUEST = 1;
    private TextView rt;
    private TextView rts;
    public static final String MYTAG = "Sorc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MYTAG, "-------");
        Log.d(MYTAG, "onCreate");

        et= findViewById(R.id.et_main);
        rt= findViewById(R.id.msg);
        rts= findViewById(R.id.msr);

        if(savedInstanceState!=null){
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if(isVisible)
            {
                rts.setVisibility(View.VISIBLE);
                rt.setText(savedInstanceState.getString("reply_text"));
                rt.setVisibility(View.VISIBLE);
            }
        }


    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MYTAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(MYTAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MYTAG, "onResume");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MYTAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MYTAG, "onStop");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(rts.getVisibility()==View.VISIBLE)
        {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text" , rt.getText().toString());

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MYTAG, "onDestroy");
    }

    public void launchSecondActivity(View view) {
        String message= et.getText().toString();
        Intent intent= new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message);

        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== TEXT_REQUEST)
        {
            if(resultCode== RESULT_OK)
            {
                rts.setVisibility(View.VISIBLE);
                String reply= data.getStringExtra(SecondActivity.EXTRA_REPLY);
                if(reply.length()!=0)
                    rt.setText(reply);
                else
                    rt.setText("No Reply");
                rt.setVisibility(View.VISIBLE);

            }
        }
    }
}
