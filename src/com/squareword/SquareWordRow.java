package com.squareword;

import com.squareword.dictionary.Dictionary;
import com.squareword.row.Row;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareWordRow {
    private List<Row> field;
    private int size;
    private int fullConflictCount;
    private List<Integer> conflicts;
    private Dictionary dictionary;

    public SquareWordRow(Dictionary dictionary) {
        field = new ArrayList<>();
        this.dictionary = dictionary;
        conflicts = new ArrayList<>();
    }

    public void parseField(String field) {
        String[] rows = field.split("\n");

        AtomicInteger rowIndex = new AtomicInteger();
        Arrays.stream(rows).forEach((row) -> {
            if (StringHelper.compare(row, dictionary.getDictString()))
                this.field.add(new Row(row, true));
            else
                this.field.add(new Row(row, false));

            size++;
        });

    }

    public void print() {
        field.forEach(System.out::println);
    }

    public List<Row> rowList() {
        return field;
    }


    public int getSize() {
        return size;
    }

    public Row getRow(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Get row: Out of Word boundaries");
        return field.get(i);
    }

    public List<String> getColumn(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Get column: Out of Word boundaries");
        return IntStream.range(0, size).mapToObj(j -> field.get(j).getElement(i)).collect(Collectors.toList());
    }

    public void setRow(int i, Row newRow) {
        if (getRow(i) != null)
            this.field.set(i, newRow);
    }

    public int calculateConflicts() {
        int conflictCount = 0;
        Set<String> column = new HashSet<>();
        List<String> columnList  = new ArrayList<>();
        for(int i = 0; i < size; ++i){
            columnList = getColumn(i);
            columnList.forEach(column::add);
            conflictCount += getColumn(i).size() - column.size();
            column.clear();
            columnList.clear();
        }
        return conflictCount;
    }

    public int getConfilictCount() {
        return fullConflictCount;
    }

}
