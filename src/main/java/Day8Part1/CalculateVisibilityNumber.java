package Day8Part1;

import java.util.ArrayList;

public class CalculateVisibilityNumber {

    TreeDictionaries treeDictionaries;
    TreeSet treeSet = new TreeSet();

    public CalculateVisibilityNumber(TreeDictionaries dictionaries) {
        this.treeDictionaries = dictionaries;
    }

    public int numberOfVisibleTrees() {
        visibilityForRowsRightToLeft();
        visibilityForRowsLeftToRight();
        visibilityForColumnsTopToBottom();
        visibilityForColumnsBottomToTop();
        return treeSet.count();
    }

    private void visibilityForColumnsBottomToTop() {
        for(int i = 0; i < treeDictionaries.numberOfColumns(); i++){
            ArrayList<Tree> column = treeDictionaries.getColumn(i);
            int numberOfRows = treeDictionaries.numberOfRows();
            treeSet.add(column.get(numberOfRows-1));
            int highest = column.get(numberOfRows-1).getHeight();
            for(int j = numberOfRows - 1; j > -1; j--){
                if(column.get(j).isTallerThan(highest)){
                    treeSet.add(column.get(j));
                    highest += column.get(j).heightIncrement(highest);
                }
            }
        }
    }

    private void visibilityForColumnsTopToBottom() {
        for(int i = 0; i < treeDictionaries.numberOfColumns(); i++){
            ArrayList<Tree> column = treeDictionaries.getColumn(i);
            int numberOfRows = treeDictionaries.numberOfRows();
            treeSet.add(column.get(0));
            int highest = column.get(0).getHeight();
            for(int j = 0; j < numberOfRows - 1; j++){
                if(column.get(j).isTallerThan(highest)){
                    treeSet.add(column.get(j));
                    highest += column.get(j).heightIncrement(highest);
                }
            }
        }
    }

    private void visibilityForRowsLeftToRight() {
        for(int i = 0; i < treeDictionaries.numberOfRows(); i++){
            ArrayList<Tree> row = treeDictionaries.getRow(i);
            int numberOfColumns = treeDictionaries.numberOfColumns();
            treeSet.add(row.get(0));
            int highest = row.get(0).getHeight();
            for(int j = 0; j < numberOfColumns - 1; j++){
                if(row.get(j).isTallerThan(highest)){
                    treeSet.add(row.get(j));
                    highest += row.get(j).heightIncrement(highest);
                }
            }
        }
    }


    private void visibilityForRowsRightToLeft() {
        for(int i = 0; i < treeDictionaries.numberOfRows(); i++){
            ArrayList<Tree> row = treeDictionaries.getRow(i);
            int numberOfColumns = treeDictionaries.numberOfColumns();
            treeSet.add(row.get(numberOfColumns - 1));
            int highest = row.get(numberOfColumns- 1).getHeight();
            for(int j = numberOfColumns - 1; j > -1; j--){
                if(row.get(j).isTallerThan(highest)){
                    treeSet.add(row.get(j));
                    highest += row.get(j).heightIncrement(highest);
                }
            }
        }
    }

}
