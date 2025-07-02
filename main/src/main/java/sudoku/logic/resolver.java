package sudoku.logic;

import java.util.ArrayList;
import java.util.List;

public class resolver {

    private List<List<Integer>> table;
    private int size;

    public resolver(int size){
        table = new ArrayList<>();
        this.size = size;
        printTable();
    }

    public boolean insertSpace(int x, int y, int value){
        boolean resultValidation = false;

        if(validColumn(y,value) && validRow(x,value)){

        }

        return resultValidation;
    }

    public boolean isEmpty(){
        return table.size() <= (size*size);
    }

    private boolean validateNewValue(){
        return false;
    }

    private boolean validateSquare(int x, int y, int value){

        return false;
    }

    private boolean validRow(int x, int value){
        return !table.get(x).contains(value);
    }

    private boolean validColumn(int y, int value){
        boolean valid = false;


        return valid;
    }

    private void printTable(){
        System.out.println(table.toString());
    }
}