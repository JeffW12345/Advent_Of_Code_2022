package Day7Part1;
public class Day7Part1 {
    public static void main(String[] args){
        ImportData importData = new ImportData();
        importData.importData();
        ProcessData processData = new ProcessData(importData);
        processData.process();
        System.out.println();
    }
}
