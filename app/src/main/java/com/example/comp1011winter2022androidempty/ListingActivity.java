package com.example.comp1011winter2022androidempty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListingActivity extends BaseMenuActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);


        ArrayList<String> cities = new ArrayList<>();
        cities.add("Toronto");
        cities.add("Barrie");
        cities.add("Montreal");

        int[] images = {R.drawable.first, R.drawable.second, R.drawable.third};


        /*
            An adaptor
                a link b/t the declare listview and its data
                    populating the data
                    what happens when item is selected

            BaseAdaptor
                built-in functionality of adaptors
            if custom implementation desired
                create a custom class BASED on BaseAdaptor


         */
        ListViewAdaptor listViewAdaptor = new ListViewAdaptor(getApplicationContext(), cities, images);
        ListView listView = findViewById(R.id.listView1);
        listView.setAdapter(listViewAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        String.format("Item with id %d selected", i),
                        Toast.LENGTH_LONG).show();

            }
        });



    }
}