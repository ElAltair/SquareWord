package com.squareword;

import com.squareword.dictionary.Dictionary;
import com.squareword.dictionary.DictionaryController;
import com.squareword.row.RowGenerator;

public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        dictionary.add("С,Л,Е,З,А");

        SquareWordRow word = new SquareWordRow(dictionary);
        word.parseField("СЛЕЗА\n.....\n..ЛЕС\n.....\n.....");
        Reshuffler reshuffler = new Reshuffler(new DictionaryController(dictionary));
        word.print();
        Solver solver = new Solver(word, dictionary);
        solver.GreedySolve();
        /*
        SquareWord word = new SquareWord(dictionary);
        word.parseField("СЛЕЗА\n.....\n..ЛЕС\n.....\n.....");
        word.print();

        Solver solver = new Solver(word, dictionary);
        solver.solve();

        Dictionary sudoku = new Dictionary();
        sudoku.add("1,2,3,4,5,6,7,8,9");

        SquareWord sudokuWord = new SquareWord(sudoku);
        sudokuWord.parseField("48.57..3.\n61..34...\n.35.61.47\n8..45.3.2\n72319....\n..1...796\n..86.345.\n1..9.82.3\n394.25.6.");
        sudokuWord.print();

        Solver sudokuSolver = new Solver(sudokuWord, sudoku);
        sudokuSolver.solve();
        */
    }
}
