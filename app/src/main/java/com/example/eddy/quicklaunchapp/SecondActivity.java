package com.example.eddy.quicklaunchapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //if the intent has some extra value
        if(getIntent().hasExtra("com.example.eddy.quicklaunchapp.SecondActivityExtra")){
            TextView tv=(TextView)findViewById(R.id.textView);
            String text=getIntent().getExtras().getString("com.example.eddy.quicklaunchapp.SecondActivityExtra");
            tv.setText(text);
        }

    }
}
