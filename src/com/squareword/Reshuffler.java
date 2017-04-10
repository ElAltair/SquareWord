package com.squareword;

import com.squareword.dictionary.DictionaryController;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reshuffler {
    private DictionaryController dictController;
    private List<String> reshuffled;

    public Reshuffler(DictionaryController dictController) {
        this.dictController = dictController;
        reshuffled = new ArrayList<>();
    }

    public List<String> shuffle(){
        if(reshuffled.isEmpty()){
            String toShuffle = "";
            String temp = "";
            while( (temp = dictController.nextValue()) != null){
                toShuffle += temp;
            }
            return permutation(toShuffle);
        }
        else return reshuffled;
    }

    public List<String> shuffle(String pattern){
        Pattern toFilter = Pattern.compile(pattern);
       return shuffle().stream().filter(s -> s.matches(pattern)).collect(Collectors.toList());
    }

    private ArrayList<String> permutation(String s) {
        // The result
        ArrayList<String> res = new ArrayList<String>();
        // If input string's length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = merge(permutation(rest), last);
        }
        return res;
    }

    /**
     * @param list a result of permutation, e.g. {"ab", "ba"}
     * @param c    the last character
     * @return     a merged new list, e.g. {"cab", "acb" ... }
     */
    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        // Loop through all the string in the list
        for (String s : list) {
            // For each string, insert the last character to all possible postions
            // and add them to the new list
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
}
