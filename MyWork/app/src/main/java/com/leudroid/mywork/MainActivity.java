package com.leudroid.mywork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.modules));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Intent picassoIntent = new Intent(MainActivity.this,PicassoImageLoading.class);
                        startActivity(picassoIntent);
                        break;
                    case 1 :
                        Intent picassoCacheIntent = new Intent(MainActivity.this,ImageCaching.class);
                        startActivity(picassoCacheIntent);
                        break;
                    case 2 :
                        Intent recyclerIntent = new Intent(MainActivity.this,RecyclerActivity.class);
                        startActivity(recyclerIntent);
                        break;
                }
            }
        });


    }
}