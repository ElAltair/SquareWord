package com.squareword.dictionary;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dictionary {
    protected Map<String, String> values;

    public Dictionary(){
        values = new LinkedHashMap<String, String>();
    }

    public Dictionary(String dictionary){
        values = new LinkedHashMap<String, String>();
        add(dictionary);
    }

    public Dictionary addValue(String toAdd){
        values.put(toAdd, toAdd);
        return this;
    }

    public void add(String toAdd){
        for(String str: toAdd.split(","))
            addValue(str);
    }

    public String get(String toGet){
        return values.get(toGet);
    }

    public void removeValue(String toRemove){
        values.remove(toRemove);
    }

    public Dictionary copy(){
        Dictionary toReturn = new Dictionary();
        for (String key : values.keySet()) {
            toReturn.addValue(key);
        }
        return toReturn;
    }
}
