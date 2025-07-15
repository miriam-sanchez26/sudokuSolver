package sudoku.main;

import sudoku.logic.Resolver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value, row, column;
        Scanner scanner = new Scanner(System.in);
        Resolver resolverSudoku = new Resolver(9);

        while(!resolverSudoku.isComplete()){
            System.out.println("write row: ");
            row = scanner.nextInt();
            System.out.println("write column: ");
            column = scanner.nextInt();
            System.out.println("write value: ");
            value = scanner.nextInt();
            if(!resolverSudoku.insertSpace(row, column, value)){
                System.out.println("Something fails to insert value");
            }
        }
    }
}