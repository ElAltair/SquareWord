package com.squareword.dictionary;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dictionary {
    protected Map<String, String> values;
    private int size;

    public Dictionary(){
        values = new LinkedHashMap<String, String>();
        size = 0;
    }

    private void calculateSize(){
        this.size = values.size();
    }

    public Dictionary(String dictionary){
        values = new LinkedHashMap<String, String>();
        add(dictionary);
        size++;
    }

    public Dictionary addValue(String toAdd){
        values.put(toAdd, toAdd);
        size++;
        return this;
    }

    public int size(){
        return size;
    }

    public void add(String toAdd){
        for(String str: toAdd.split(",")) {
            addValue(str);
            size++;
        }
    }

    public String getDictString(){
        String toReturn = "";
        for(String str: values.keySet()){
            toReturn+= str;
        }
        return toReturn;
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
        toReturn.calculateSize();
        return toReturn;
    }
}
