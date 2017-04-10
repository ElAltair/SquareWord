package com.squareword.row;

import com.squareword.Reshuffler;
import com.squareword.SquareWordRow;
import com.squareword.dictionary.Dictionary;
import com.squareword.dictionary.DictionaryController;

import java.util.*;

public class RowGenerator {
    private Reshuffler reshuffler;
    private Map<Integer, String> combinations;

    public RowGenerator(Dictionary dict){
        reshuffler = new Reshuffler(new DictionaryController(dict));
        combinations = new HashMap<>();
    }

    public String generate(Row source){
        List<String>  shuffled;
        if(source.isDefault())
            shuffled = reshuffler.shuffle(source.value());
        else
            shuffled = reshuffler.shuffle();

        return shuffled.get(new Random(System.nanoTime()).nextInt(shuffled.size()));
    }

    public void generateCalculations(SquareWordRow field, Row row){
        reshuffler.shuffle().forEach(i->{
            Row previousRow = field.getRow(row.getIndex());
            field.setRow(row.getIndex(),row);
            field.calculateConflicts();
            combinations.put(field.calculateConflicts(),row.value());
            field.setRow(row.getIndex(),previousRow);
        });
    }

    public String getMinimum(){
        return combinations.get(Collections.min(combinations.keySet()));
    }

    public String getMinimum(Row pattern){
        return combinations.get(Collections.min(combinations.keySet()));
    }
}
