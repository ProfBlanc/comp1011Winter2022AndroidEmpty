package com.example.comp1011winter2022androidempty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CameraActivity extends BaseMenuActivity {

    Button open_camera;
    Button select_photo;
    ImageView mainImage;

    public static final int to_locate = 100; // to re-located our comp1011Winter2022 app
    public static final int to_retrieve = 900; // agreement/reference between our app and external app (gallery or camera)

    public static final String save_location = Environment
            .getExternalStorageDirectory()
            .getAbsolutePath() + "/ourSavedImage.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        open_camera = findViewById(R.id.buttonTakePhoto);
        select_photo = findViewById(R.id.buttonSelectFromGallery);

        mainImage = findViewById(R.id.imageViewMainCameraExample);

        Toast.makeText(getApplicationContext(), save_location, Toast.LENGTH_LONG).show();
        try {
            if (Files.exists(Paths.get(save_location))) {
                mainImage.setImageBitmap(
                        BitmapFactory.decodeFile(save_location)
                );
            }
            else{
                Toast.makeText(getApplicationContext(), "Image not found!", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){

            Log.e("imageView_error","Could not find the image from file");


        }
    }

    public void onClickOpenGallery(View v){

        //create new intent

        //special intent. not part of app, but opening anther app / action (camera)

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Please select image"), to_retrieve);



    }
    public void onClickOpenCamera(View v){


    }


}