package com.example.eddy.quicklaunchapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //shit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attemp to launch another activity
        Button firstActivityBtn=(Button)findViewById(R.id.firstActivityBtn);

        firstActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  startIntent=new Intent(getApplicationContext(),SecondActivity.class);
                //passing information (Key,value)
                startIntent.putExtra("com.example.eddy.quicklaunchapp.SecondActivityExtra","Bye Bye");
                startActivity(startIntent);
            }
        });

        //attemp to launch activity outside our app
        Button googleBtn=(Button)findViewById(R.id.secondActivityBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google="https://www.google.com.hk/search?q=Instrument";
                Uri webaddress=Uri.parse(google);

                Intent gotoGoogle=new Intent(Intent.ACTION_VIEW,webaddress); //asking the device if there is a way to open the address
                if(gotoGoogle.resolveActivity(getPackageManager())!=null){
                    startActivity(gotoGoogle);
                }
            }
        });

        //List and image tutorial
        Button ListImageBtn=(Button)findViewById(R.id.ListImageBtn);
        ListImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoListImage=new Intent(getApplicationContext(),ListImage.class);
                startActivity(gotoListImage);
            }
        });
    }
}
