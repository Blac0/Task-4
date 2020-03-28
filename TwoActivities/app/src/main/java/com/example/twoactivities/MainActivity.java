package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE= "com.example.android.twoactivities.extra.MESSAGE";
    private EditText et;
    public static final int TEXT_REQUEST = 1;
    private TextView rt;
    private TextView rts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et= findViewById(R.id.et_main);
        rt= findViewById(R.id.msg);
        rts= findViewById(R.id.msr);
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
