package sudoku.logic;

public class Resolver {

    private final int[][] table;
    private final int size;

    public Resolver(int size){
        table = new int[size][size];
        this.size = size;
    }

    public boolean insertSpace(int row, int column, int value){
        row--;
        column--;
        if(table[row][column] == 0){
            if(row >= 0 && row < size && column >= 0 && column < size && value >= 1 && value <= 9){
                if(validRow(row, value) && validColumn(column, value) && validateSquare(row, column, value)){
                    table[row][column] = value;
                    printTable();
                    return true;
                }
            }else {
                System.out.println("entry values not valid");
            }
        }else{
            System.out.println("space not empty");
        }

        printTable();
        return false;
    }

    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (table[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateSquare(int row, int column, int value){
        int startRow = row - row % 3;
        int startCol = column - column % 3;
        int sum = 0;
        boolean duplicatedValue = true;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                sum += table[i][j];
                if (table[i][j] == value) {
                    System.out.println("found square duplicate");
                    duplicatedValue = false;
                }
            }
        }
        System.out.println("Sum of square is " + sum);
        return (sum + value <= 45) && duplicatedValue;
    }

    private boolean validRow(int row, int value) {
        int sum = 0;
        boolean duplicatedValue = true;

        for (int i = 0; i < size; i++) {
            sum += table[row][i];
            if (table[row][i] == value) {
                System.out.println("found row duplicate");
                duplicatedValue = false;
            }
        }
        System.out.println("Sum of row is " + sum);
        return (sum + value <= 45) && duplicatedValue;
    }

    private boolean validColumn(int column, int value){
        int sum = 0;
        boolean duplicatedValue = true;

        for (int i = 0; i < size; i++) {
            sum += table[i][column];
            if (table[i][column] == value) {
                System.out.println("found column duplicate");
                duplicatedValue = false;
            }
        }

        System.out.println("Sum of column is " + sum);
        return (sum + value <= 45) && duplicatedValue;
    }

    private void printTable(){
        for (int row = 0; row < size; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int col = 0; col < size; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(table[row][col]);
            }
            System.out.println();
        }
    }
}