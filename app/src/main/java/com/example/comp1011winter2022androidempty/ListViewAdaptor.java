package com.example.comp1011winter2022androidempty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdaptor extends BaseAdapter {


    private ArrayList<String> cities;
    private int[] images;
    Context context;
    LayoutInflater inflater;

    public ListViewAdaptor(Context context, ArrayList<String> cities, int[] images) {
        this.cities = cities;
        this.images = images;
        this.context = context;
        inflater  = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int i) {
        return String.format(cities.get(i) + "--" + images[i]);
    }

    @Override
    public long getItemId(int i) {
        return images[i];
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.individual_list_item_layout, null);
        ImageView targetImage = view.findViewById(R.id.list_item_photo);
        TextView targetText = view.findViewById(R.id.list_item_text);

        targetText.setText(cities.get(i));
        targetImage.setImageResource(images[i]);

        return view;
    }
}
