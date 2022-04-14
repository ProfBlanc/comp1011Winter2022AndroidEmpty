package com.example.comp1011winter2022androidempty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StorageActivity extends BaseMenuActivity {

    //declare a name of the file that your app will read file
    String appFilename = "myappdata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    public void onClickReadContent(View v){

        try{
            readFileContents();
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void onClickSaveContent(View v){

        EditText content = findViewById(R.id.editTextTextMultiLineWriteContent);
        try{
            writeFileContent(content.getText().toString());
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


    private void readFileContents() throws IOException{

        //locate the multiline android element to write to
        EditText target = findViewById(R.id.editTextTextMultiLineReadContent);
        //open up the app file

        FileInputStream fis = openFileInput(appFilename);

        Scanner scanner = new Scanner(fis);

        StringBuilder sb = new StringBuilder();

        while(scanner.hasNext()){
            sb.append(scanner.nextLine() + '\n');
        }

        //write data to the android element
        target.setText(sb.toString());
    }

    private void writeFileContent(String content) throws IOException{

        //getApplicationContext openFileOutput method
                //append mode

       FileOutputStream fos = getApplicationContext().openFileOutput(appFilename, Context.MODE_APPEND);
       fos.write(content.getBytes());

    }

}