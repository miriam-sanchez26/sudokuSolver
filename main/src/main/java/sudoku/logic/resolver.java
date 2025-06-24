package sudoku.logic;

import java.util.ArrayList;
import java.util.List;

public class resolver {

    private List<List<Integer>> table;
    private int size;

    public resolver(int size){
        table = new ArrayList<>();
        this.size = size;
    }

    public boolean insertSpace(int value){
        boolean resultValidation = false;

        return resultValidation;
    }

    private boolean validateNewValue(){
        return false;
    }

    private boolean validateSquare(int x, int y, int value){

        return false;
    }

    private boolean validateRow(){
        return false;
    }

    private boolean validateColumn(){
        return false;
    }
}