package Day8Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TreeDictionaries {

    private final HashMap<Integer, ArrayList<Tree>> columnToTree = new HashMap<>();
    private final HashMap<Integer, ArrayList<Tree>> rowToTree = new HashMap<>();
    public void addToColumnDict(Tree tree, int column) {
        if(columnToTree.containsKey(column)){
            columnToTree.get(column).add(tree);
        }
        else{
            ArrayList<Tree> temp = new ArrayList<>();
            temp.add(tree);
            columnToTree.put(column, temp);
        }
    }
    public void addToRowDict(Tree tree, int row) {
        if(rowToTree.containsKey(row)){
            rowToTree.get(row).add(tree);
        }
        else{
            ArrayList<Tree> temp = new ArrayList<>();
            temp.add(tree);
            rowToTree.put(row, temp);
        }
    }
    public ArrayList<Tree> getRow(int rowNumber){

        return rowToTree.get(rowNumber);
    }


    public ArrayList<Tree> getColumn (int columnNumber){

        return columnToTree.get(columnNumber);
    }

    public int numberOfRows(){
        return rowToTree.keySet().size();
    }

    public int numberOfColumns(){
        return columnToTree.keySet().size();
    }
}
