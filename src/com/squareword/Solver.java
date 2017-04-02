package com.squareword;

import com.squareword.cell.Cell;
import com.squareword.cell.CellController;
import com.squareword.dictionary.Dictionary;
import com.squareword.dictionary.DictionaryController;

public class Solver {
    private SquareWord word;
    private CellController controller;
    private Dictionary dictionary;

    public Solver(SquareWord word, Dictionary dictionary){
        this.word = word;
        this.dictionary = dictionary;
        controller = new CellController(word);
    }

    private boolean findSolution(DictionaryController dictController, Cell cell){
        String cellSolution = dictController.nextValue();
        boolean foundSolution = false;
        do{
            foundSolution = checkCellSolution(cell, cellSolution);
        }
        while(!foundSolution && (cellSolution = dictController.nextValue()) != null);
        if(cellSolution != null)
            cell.setWord(cellSolution);
        return foundSolution;
    }

    public boolean findCellSolution(Cell toFind){
        DictionaryController dictController = new DictionaryController(dictionary);
        return findSolution(dictController, toFind);
    }

    public boolean rollBack(Cell toRollBack){
        DictionaryController dictController = new DictionaryController(dictionary);
        dictController.removeValues(toRollBack.getPreviousValues());
        toRollBack.savePreviousValue();
        if(!findSolution(dictController, toRollBack)){
            toRollBack.clear();
            return false;
        }
        else
            return true;
    }

    public boolean checkCellSolution(Cell toCheck, String cellValue){
        boolean incorrectCell = false;
        boolean incorrectRow = false;
        CellController tempCellController = new CellController(word, toCheck);
        tempCellController.nullCol();
        while(tempCellController.hasNextColCell())
        {
            if(tempCellController.currentCell().getWord().equals(cellValue))
                incorrectCell = true;
            tempCellController.nextColCell();
        }
        tempCellController.reset();
        tempCellController.nullRow();
        while(tempCellController.hasNextRowCell())
        {
            if(tempCellController.currentCell().getWord().equals(cellValue))
                incorrectRow = true;
            tempCellController.nextRowCell();
        }
        return !incorrectCell && !incorrectRow;

    }


    public void solve(){
        while(controller.hasNextCell())
        {
            Cell currentCell = controller.currentCell();
            System.out.println(currentCell);
            if(currentCell.isDefault() || currentCell.isInstalled()){
                controller.nextCell();
                continue;
            }
            if(!findCellSolution(currentCell)){
                do{
                    if(controller.hasPrevCell())
                        controller.prevCell();
                    else
                        break;
                    // to skip installed
                    while(controller.currentCell().isDefault() && controller.hasPrevCell()){
                        controller.prevCell();
                    }

                }while(!rollBack(controller.currentCell()));
            }
            else
                controller.nextCell();
            word.print();
        }
    }
}
