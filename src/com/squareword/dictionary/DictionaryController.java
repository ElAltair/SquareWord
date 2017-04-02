package com.squareword.dictionary;

import java.util.ArrayList;

public class DictionaryController {
    private Dictionary dictionary;
    private ArrayList<String> dictionaryValues;
    private int dictionaryIndex;
    private String chosenValue;

    public DictionaryController(Dictionary dictionary){
        this.dictionary = dictionary;
        dictionaryValues = new ArrayList<>();
        for(String str: dictionary.values.keySet())
        {
            dictionaryValues.add(str);
        }
        dictionaryIndex = 0;
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

    public void removeValues(ArrayList<String> toRemove){
        for(String str: toRemove)
            if(!dictionaryValues.contains(str))
            dictionaryValues.remove(str);
   }


}
