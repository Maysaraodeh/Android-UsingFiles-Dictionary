package com.masotech.dictionary;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mWord;
    private EditText mMeaning;
    private Button mSave , mDetails;


    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/dictionary";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWord = (EditText) findViewById(R.id.word);
        mMeaning = (EditText) findViewById(R.id.meaning);
        mSave = (Button) findViewById(R.id.save);
        mDetails = (Button) findViewById(R.id.btn_details);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();

            }
        });

        mDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , DetailsActivity.class));
            }
        });






    }


    public void saveData(){

        try {
                FileOutputStream fileOutputStream = openFileOutput("Dictionary.txt", MODE_APPEND);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

                outputStreamWriter.write(mWord.getText().toString() + "," + mMeaning.getText().toString() + "\n");

                outputStreamWriter.flush();
                outputStreamWriter.close();
                mWord.setText("");
                mMeaning.setText("");
                Toast.makeText(MainActivity.this , "Saved" , Toast.LENGTH_SHORT).show();

        }catch (IOException e){
            Toast.makeText(MainActivity.this , e.getMessage() , Toast.LENGTH_LONG).show();
        }
    }



}
