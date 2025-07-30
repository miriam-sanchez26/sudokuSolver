package sudoku.test;

import sudoku.logic.SudokuSolver;

public class SudokuSolverTest {

    private SudokuSolver sudokuSolver;

    /**
     *
     */
    public void testValidBoard() {
        sudokuSolver = new SudokuSolver(9);
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int x, y;
        x = y = 0;
        boolean isValid = true;

        while (!sudokuSolver.isComplete()) {
            int value = board[x][y];
            if(!sudokuSolver.insertSpace(x+1, y+1, value)){
                isValid=false;
                break;
            }
            if(y == 8){
                y = -1;
                x++;
            }
            y++;
        }

        if (isValid) {
            System.out.println("test valid board pass");
        } else {
            System.out.println("test valid board failure");
        }
    }

    /**
     *
     */
    public void testInvalidBoard() {
        sudokuSolver = new SudokuSolver(9);
        int[][] board = {
                {4, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int x, y;
        x = y = 0;
        boolean isValid = true;

        while (!sudokuSolver.isComplete()) {
            int value = board[x][y];
            if(!sudokuSolver.insertSpace(x+1, y+1, value)){
                isValid=false;
                break;
            }
            if(y == 8){
                y = -1;
                x++;
            }
            y++;
        }

        if (!isValid) {
            System.out.println("test invalid board pass");
        } else {
            System.out.println("test invalid board failure");
        }
    }
}
