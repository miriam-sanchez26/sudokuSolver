package sudoku.logic;

/**
 *class to solve sudoku
 */
public class SudokuSolver {

    private final int[][] board;
    private final int size;

    public SudokuSolver(int size){
        //initialize all the board, 0 represent empty space
        board = new int[size][size];
        this.size = size;
    }

    /**
     *validate data from user, if values are valid, we insert that value in our board, if not, return false
     * @param row
     * @param column
     * @param value
     * @return true if all the values are valid
     */
    public boolean insertSpace(int row, int column, int value){
        row--;
        column--;
        if(board[row][column] == 0){
            if(row < size && column < size && value >= 1 && value <= 9){
                if(validRow(row, value) && validColumn(column, value) && validateSquare(row, column, value)){
                    board[row][column] = value;
                    return true;
                }
            }else {
                System.out.println("entry values not valid");
            }
        }else{
            System.out.println("space not empty");
        }

        return false;
    }

    /**
     *validate if our board contains empty spaces
     * @return true if we found an empty space
     */
    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param row
     * @param column
     * @param value
     * @return
     */
    private boolean validateSquare(int row, int column, int value){
        int startRow = row - row % 3;
        int startCol = column - column % 3;
        int sum = 0;
        boolean duplicatedValue = true;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                sum += board[i][j];
                if (board[i][j] == value) {
                    System.out.println("found duplicate in the square");
                    duplicatedValue = false;
                }
            }
        }

        return (sum + value <= 45) && duplicatedValue;
    }

    /**
     *
     * @param row
     * @param value
     * @return
     */
    private boolean validRow(int row, int value) {
        int sum = 0;
        boolean duplicatedValue = true;

        for (int i = 0; i < size; i++) {
            sum += board[row][i];
            if (board[row][i] == value) {
                System.out.println("found duplicate in the row");
                duplicatedValue = false;
            }
        }

        return (sum + value <= 45) && duplicatedValue;
    }

    /**
     *
     * @param column
     * @param value
     * @return
     */
    private boolean validColumn(int column, int value){
        int sum = 0;
        boolean duplicatedValue = true;

        for (int i = 0; i < size; i++) {
            sum += board[i][column];
            if (board[i][column] == value) {
                System.out.println("found duplicate in the column ");
                duplicatedValue = false;
            }
        }

        return (sum + value <= 45) && duplicatedValue;
    }

    /**
     * print in console table with specific format
     */
    public void printTable(){
        for (int row = 0; row < size; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int col = 0; col < size; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}