package Day7Part1And2;

public class ProcessData {
    private final ImportData importData;
    public ProcessData(ImportData data) {
        this.importData = data;
    }

    public void process(Directories directories){
        Directory currentDirectory = new Directory(null, "Root");
        Directory root = currentDirectory;
        for(int i = 0; i < importData.numberOfRows(); i++){
            String row = importData.releaseDataRow(i);
            if(row.equals("$ cd /")){
               currentDirectory = root;
               continue;
            }
            if(row.equals("$ cd ..") ){
                currentDirectory = currentDirectory.getParent();
                continue;
            }
            if(row.startsWith("$ cd ")){
                String directoryName = row.split(" ")[2];
                currentDirectory = directories.createAndStore(directoryName, currentDirectory);
                continue;
            }
            if(row.equals("$ ls")){
                continue;
            }
            if(row.startsWith("dir ")){
                directories.createAndStore(row.split(" ")[1], currentDirectory);
            }
            else{
                currentDirectory.addFile(Integer.parseInt(row.split(" ")[0]));
            }
        }
    }
}
