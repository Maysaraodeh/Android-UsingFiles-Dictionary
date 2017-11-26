package com.masotech.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DetailsActivity extends AppCompatActivity {


    private RecyclerView mRecyclerViewWords;
    private WordAdapter mWordAdapter;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManager;
    private ArrayList<Dictionary> mDictionary = new ArrayList<Dictionary>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mRecyclerViewWords = (RecyclerView) findViewById(R.id.rv_words);
        mRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewWords.setLayoutManager(mRecyclerViewLayoutManager);

        loadData();
    }

    private void loadData() {

        File file = getApplicationContext().getFileStreamPath("Dictionary.txt");
        String line;
        if (file.exists()) {

            try {
                InputStreamReader inputStream = new InputStreamReader(openFileInput("Dictionary.txt"));
                BufferedReader reader = new BufferedReader(inputStream);

                while ((line = reader.readLine()) != null){
                    StringTokenizer tokens = new StringTokenizer(line , "," );
                    Dictionary dictionary = new Dictionary(tokens.nextToken() , tokens.nextToken());
                    Log.d("file" , dictionary.getWord());
                    mDictionary.add(dictionary);
                    mWordAdapter = new WordAdapter(mDictionary , this);

                    mRecyclerViewWords.setAdapter(mWordAdapter);
                }

                reader.close();

            }catch (IOException e){

                Toast.makeText(DetailsActivity.this , e.getMessage() , Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(DetailsActivity.this , "file not Exist" , Toast.LENGTH_LONG).show();
        }


    }
}
