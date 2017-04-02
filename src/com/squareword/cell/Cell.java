package com.squareword.cell;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cell {
    private int i;
    private int j;
    private String word;
    private boolean isInstalled;
    private boolean isDefault;
    ArrayList<String> previousValues;

    public Cell(int i, int j, String word, boolean isDefault){
       this.i = i;
       this.j = j;
       this.word = word;
       this.isDefault = isDefault;
       this.isInstalled = this.isDefault;
       previousValues = new ArrayList<>();
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        isInstalled = true;
        this.word = word;
    }

    public boolean isInstalled(){
        return isInstalled;
    }

    public boolean isDefault(){
        return isDefault;
    }

    public ArrayList<String> getPreviousValues(){
        return previousValues;
    }

    public void savePreviousValue(){
        previousValues.add(word);
    }

    public void clear(){
        isInstalled = false;
        word = ".";
    }

    @Override
    public String toString(){
        if("".endsWith(word))
            return ".";
        else
            return word;
    }
}
