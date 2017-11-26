package com.masotech.dictionary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by maysaraodeh on 26/11/2017.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private ArrayList<Dictionary> mDictionary;
    private Context mContext;

    public WordAdapter(ArrayList<Dictionary> dictionary , Context context){

        mDictionary = dictionary;
       // Log.d("adpater" , dictionary.get(1).getWord());
        mContext = context;

    }



    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        int layoutIdForImages = R.layout.word_item;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean attachImmediately = false;

        View view = inflater.inflate(layoutIdForImages , parent , attachImmediately);
        WordViewHolder wordViewHolder = new WordViewHolder(view);

        return wordViewHolder ;
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, final int position) {

        holder.word.setText(mDictionary.get(position).getWord());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dictionary dictionary = mDictionary.get(position);
                Toast.makeText(mContext , dictionary.getMeaning() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDictionary.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        TextView word;

        public WordViewHolder(View itemView) {
            super(itemView);

            word = (TextView) itemView.findViewById(R.id.word_item);
        }
    }
}
