package com.squareword.row;

public class Row {

    private String row;
    private boolean isDefault;
    private int index;

    public Row(int index, String row, boolean isDefault){
        this.row = row;
        this.isDefault = isDefault;
        this.index = index;
    }

    public Row(Row row){
        this.row = row.row;
        this.isDefault = row.isDefault;
        this.index = row.index;
    }

    public boolean isDefault()
    {
        return isDefault;
    }

    @Override
    public String toString(){
        if(isDefault)
            return "\u001B[32m" + row + "\u001B[0m";
        else
            return row;
    }

    public String value() {
        return row;
    }

    public String getElement(int index){
        if(index < 0 || index > row.length())
            throw new ArrayIndexOutOfBoundsException("Row: get element out of boundary");
        return String.valueOf(row.toCharArray()[index]);
    }

    public int getIndex(){
        return index;
    }
}

