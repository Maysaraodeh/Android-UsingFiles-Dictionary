package com.masotech.dictionary;

import java.util.StringTokenizer;

/**
 * Created by maysaraodeh on 25/11/2017.
 */

public class Dictionary {

    private String word;
    private String meaning;

    public Dictionary(){}
    public Dictionary(String word , String meaning){
        this.word = word;
        this.meaning = meaning;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }
}
