package com.example.comp1011winter2022androidempty;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BaseMenuActivity extends AppCompatActivity {


    /*
        declare the menu

        handle menu item clicks

     */
    @Override
    public boolean onCreateOptionsMenu(Menu m){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, m);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        Intent intent;
        switch (menuItem.getItemId()){

            case R.id.menu_home:
                Toast.makeText(getApplicationContext(),
                        "Welcome home!",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_main:
                intent = new Intent(this, MainActivity.class);

                startActivity(intent);

                break;

            case R.id.menu_calculator:
                intent = new Intent(this, CalculatorActivity.class);
                intent.putExtra("custom_value", "You came from the menu");
                startActivity(intent);

                break;

            case R.id.menu_gallery:
                intent = new Intent(this, GalleryActivity.class);
                startActivity(intent);

                break;
            case R.id.menu_storage:
                intent = new Intent(this, StorageActivity.class);
                startActivity(intent);

                break;

            case R.id.menu_camera:
                intent = new Intent(this, CameraActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_listing:
                intent = new Intent(this, ListingActivity.class);
                startActivity(intent);
                break;

        }

        return true;
    }
}
