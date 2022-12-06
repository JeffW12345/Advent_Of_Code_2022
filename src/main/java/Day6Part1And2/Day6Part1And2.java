package Day6Part1And2;
public class Day6Part1And2 {
    public static void main(String[] args){
        ImportData importData = new ImportData();
        importData.importData();
        ProcessData processData = new ProcessData(importData);
        processData.process();
    }
}
