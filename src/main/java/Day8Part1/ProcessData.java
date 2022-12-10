package Day8Part1;

public class ProcessData {
    private final ImportData importData;

    private final TreeDictionaries treeDictionaries = new TreeDictionaries();


    public ProcessData(ImportData data) {
        this.importData = data;
        process();
        printResults();
    }

    private void printResults() {
        System.out.println("Number of trees: " + new CalculateVisibilityNumber(treeDictionaries).numberOfVisibleTrees());
    }

    public void process(){
        for(int rowNumber = 0; rowNumber < importData.numberOfRows(); rowNumber++){
            String row = importData.releaseDataRow(rowNumber);
            int column = 0;
            for(Character digit: row.toCharArray()){
                Tree tree = new Tree(rowNumber, column, Character.getNumericValue(digit));
                treeDictionaries.addToColumnDict(tree, column);
                treeDictionaries.addToRowDict(tree, rowNumber);
                column++;
            }
        }
    }
}
