package sudoku.main;

import sudoku.logic.SudokuSolver;
import sudoku.test.SudokuSolverTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value, row, column;
        Scanner scanner = new Scanner(System.in);
        SudokuSolver sudokuSolverSudoku = new SudokuSolver(9);
        SudokuSolverTest test = new SudokuSolverTest();

        //testing valid an invalid board
        test.testInvalidBoard();
        test.testValidBoard();

        //getting values from user to fill board
        while(!sudokuSolverSudoku.isComplete()){
            System.out.println("write row: ");
            row = scanner.nextInt();
            System.out.println("write column: ");
            column = scanner.nextInt();
            System.out.println("write value: ");
            value = scanner.nextInt();
            if(!sudokuSolverSudoku.insertSpace(row, column, value)){
                System.out.println("Something fails to insert value");
            }
        }
        sudokuSolverSudoku.printTable();
    }
}