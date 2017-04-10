package com.squareword.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryController {
    private Dictionary dictionary;
    private ArrayList<String> dictionaryValues;
    private int dictionaryIndex;
    private String chosenValue;
    private int size;

    public DictionaryController(Dictionary dictionary){
        this.dictionary = dictionary;
        dictionaryValues = new ArrayList<>();
        for(String str: dictionary.values.keySet())
        {
            dictionaryValues.add(str);
        }
        dictionaryIndex = 0;
        this.size = dictionary.size();
    }

    public void update(){
        dictionaryValues = new ArrayList<>();
        for(String str: dictionary.values.keySet())
        {
            dictionaryValues.add(str);
        }
        dictionaryIndex = 0;
        this.size = dictionary.size();
    }

    public int getSize(){
        return size;
    }

    public String nextValue(){
        if(dictionaryIndex < dictionaryValues.size()) {
            chosenValue = dictionaryValues.get(dictionaryIndex);
            dictionaryIndex++;
            return chosenValue;
        }
        else
            return null;
    }

    public String getValue(int dictIndex){
        if(dictIndex >= dictionaryValues.size() || dictIndex < 0)
            throw new ArrayIndexOutOfBoundsException("Wrong dict index");
        else
            return dictionaryValues.get(dictIndex);

    }

    public void removeValues(List<String> toRemove){
        for(String str: toRemove)
            if(!dictionaryValues.contains(str))
            dictionaryValues.remove(str);
   }


}
