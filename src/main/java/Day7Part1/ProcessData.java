package Day7Part1;

public class ProcessData {

    ImportData importData;
    public ProcessData(ImportData data) {
        this.importData = data;
    }

    public void process(){
        for(int i = 0; i < importData.numberOfRows(); i++){
            String row = importData.realeaseDataRow(i);
        }
    }
}
