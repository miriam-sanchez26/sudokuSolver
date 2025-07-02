package sudoku.main;

import sudoku.logic.resolver;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int value, x, y;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        resolver resolverSudoku = new resolver(3);

        while(!resolverSudoku.isEmpty()){
            System.out.println("write pos x: ");
            x = scanner.nextInt();
            System.out.println("write pos y: ");
            y = scanner.nextInt();
            System.out.println("write value: ");
            value = scanner.nextInt();
            resolverSudoku.insertSpace(x, y, value);
        }
        System.out.println("size: " + resolverSudoku.isEmpty());
    }
}