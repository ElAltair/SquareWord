package com.squareword;

import com.squareword.cell.Cell;
import com.squareword.dictionary.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
public class SquareWord {
    private ArrayList<ArrayList<Cell>> field;
    private int size;
    private Dictionary dictionary;

    public SquareWord(Dictionary dictionary){
        field = new ArrayList<>();
        this.dictionary = dictionary;
    }

    public void parseField(String field){
        String[] rows = field.split("\n");

        AtomicInteger rowIndex = new AtomicInteger();
        Arrays.stream(rows).forEach((row)->{
            ArrayList<Cell> currentRow = new ArrayList<>();
            int column = 0;
            for(char c : row.toCharArray()) {
                if(dictionary.get(String.valueOf(c)) != null){
                    currentRow.add(new Cell(rowIndex.get(),column,String.valueOf(c),true));
                }
                else
                    currentRow.add(new Cell(rowIndex.get(),column,"",false));

                column++;
            }
            rowIndex.incrementAndGet();
            this.field.add(currentRow);
            size++;
        });

    }

    public void print(){
        field.forEach((row)->{
            row.forEach((elem)->{
                System.out.print(elem);
            });
            System.out.println();
        });
    }


    public int getSize(){
        return size;
    }

    public Cell getCell(int i, int j) throws IndexOutOfBoundsException {
        if(i <0 || i >= size || (j < 0 || j>= size))
            throw new IndexOutOfBoundsException("Out of Word boundaries");
        return field.get(i).get(j);
    }

}
