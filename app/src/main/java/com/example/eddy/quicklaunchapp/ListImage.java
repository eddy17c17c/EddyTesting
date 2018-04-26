package com.example.eddy.quicklaunchapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListImage extends AppCompatActivity {

    ListView myListView;
    String [] items;
    String [] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        Resources res=getResources();
        myListView=(ListView)findViewById(R.id.myListView);
        items=res.getStringArray(R.array.items);
        prices=res.getStringArray(R.array.prices);
        descriptions=res.getStringArray(R.array.description);

        ItemAdaptor itemAdaptor=new ItemAdaptor(this,items,prices,descriptions);
        myListView.setAdapter(itemAdaptor);

        //merging ListView and String array tgt (the listview using,the layout using,array to merge)
        //myListView.setAdapter(new ArrayAdapter<String>(this,R.layout.my_listview_detail,items));

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showImageActivity=new Intent(getApplicationContext(),DetailActivity.class);
                showImageActivity.putExtra("com.example.eddy.quicklaunchapp.ITEM_INDEX",position);
                startActivity(showImageActivity);
            }
        });

    }
}
