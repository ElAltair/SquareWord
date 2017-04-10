package com.squareword;

public class StringHelper {
    public static boolean compare(String source, String target){
        for(char c :source.toCharArray()){
           for(char d : target.toCharArray())
               if(c == d)
                   return true;
        }
        return false;
    }

}
