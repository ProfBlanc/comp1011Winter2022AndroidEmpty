package com.example.comp1011winter2022androidempty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends BaseMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }

    public void onImageViewClick(View v){

       int id = v.getId();
        Toast.makeText(getApplicationContext(),
                "Success! Clicked on "  +id,
                Toast.LENGTH_LONG).show();

        ImageView mainImage = findViewById(R.id.imageView_main);

        //mainImage.setImageResource(R.drawable.second);

        switch(id){

            case R.id.imageView_first:
                mainImage.setImageResource(R.drawable.first);
                break;
            case R.id.imageView_second:
                mainImage.setImageResource(R.drawable.second);
                break;
            case R.id.imageView_third:
                mainImage.setImageResource(R.drawable.third);
                break;

        }

    }
}