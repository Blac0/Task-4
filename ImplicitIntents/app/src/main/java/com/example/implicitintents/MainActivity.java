package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mwet, mlet, mset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mwet = findViewById(R.id.website_edittext);
        mlet = findViewById(R.id.location_edittext);
        mset = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mwet.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW , webpage);
        if(intent.resolveActivity(getPackageManager())!= null)
        {
            startActivity(intent);
        }
        else
            Log.d("ImplicitIntents", "can't handle this ");
    }

    public void openLocation(View view) {
        String loc = mlet.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW , addressUri);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else
            Log.d("ImplicitIntents", "cant't handle this intent");
    }

    public void shareText(View view) {
        String txt = mset.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();

    }
}
