package com.squareword.cell;

import com.squareword.SquareWord;

public class CellController {
    private SquareWord squareWord;
    private int minRowIndex = 0;
    private int maxRowIndex;
    private int minColIndex = 0;
    private int maxColIndex;
    private int currentRowIndex;
    private int currentColIndex;
    private Cell currentCell;
    private Cell startCell;

    public CellController(SquareWord word){
        this.squareWord= word;
        int wordSize = word.getSize();
        maxRowIndex = wordSize - 1;
        maxColIndex = wordSize - 1;
        currentCell = word.getCell(0,0);
    }

    public CellController(SquareWord word, Cell startCell){
        this.squareWord= word;
        int wordSize = word.getSize();
        maxRowIndex = wordSize - 1;
        maxColIndex = wordSize - 1;
        this.startCell = startCell;
        this.currentCell = startCell;
        currentRowIndex = this.startCell.getI();
        currentColIndex = this.startCell.getJ();
    }

    public void reset(){
        currentRowIndex = startCell.getI();
        currentColIndex = startCell.getJ();
    }

    public boolean hasNextCell(){
        if(currentRowIndex <= maxRowIndex && currentColIndex <= maxColIndex){
           return true;
        }
        else
            return false;
    }

    public boolean hasPrevCell(){
        return currentRowIndex >= minColIndex && currentColIndex >= minColIndex;
    }

    public boolean hasNextRowCell(){
        return currentRowIndex <= maxRowIndex;
    }

    public boolean hasNextColCell(){
        return currentColIndex <= maxColIndex;
    }

    public void nextCell(){
        if(currentRowIndex < maxRowIndex){
            if(currentColIndex < maxColIndex)
                currentColIndex++;
            else if(currentColIndex == maxColIndex){
                currentColIndex = 0;
                currentRowIndex++;
            }
            currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
        }
        else if(currentRowIndex == maxRowIndex){
            if(currentColIndex < maxColIndex){
                currentColIndex++;
                currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
            }
            else if(currentColIndex == maxColIndex){
                currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
                currentColIndex++;
            }

        }
    }

    public void prevCell(){
        if(currentRowIndex > minRowIndex){
            if(currentColIndex > minColIndex)
                currentColIndex--;
            else if(currentColIndex == minColIndex){
                currentColIndex = maxColIndex;
                currentRowIndex--;
            }
            currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
        }
        else if(currentRowIndex == minRowIndex){
            if(currentColIndex > minColIndex){
                currentColIndex--;
                currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
            }
            else if(currentColIndex == minColIndex){
                currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
                currentColIndex--;
            }

        }
    }

    public void nextRowCell() {
        if (currentRowIndex < maxRowIndex) {
            currentRowIndex++;
            currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
        } else if (currentRowIndex == maxRowIndex){
            currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
        currentRowIndex++;
        }
    }

    public void nextColCell(){
        if(currentColIndex < maxColIndex)
        {
            currentColIndex++;
            currentCell = squareWord.getCell(currentRowIndex,currentColIndex);
        }
        else if(currentColIndex == maxColIndex) {
            currentCell = squareWord.getCell(currentRowIndex, currentColIndex);
            currentColIndex++;
        }

    }

    public void nullRow(){
        currentRowIndex = 0;
        currentCell = squareWord.getCell(currentRowIndex,currentColIndex);
    }

    public void nullCol(){
        currentColIndex = 0;
        currentCell = squareWord.getCell(currentRowIndex,currentColIndex);
    }

    public Cell currentCell(){
        return currentCell;
    }
}
