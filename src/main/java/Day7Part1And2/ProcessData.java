package Day7Part1And2;

public class ProcessData {
    private final ImportData importData;
    public ProcessData(ImportData data) {
        this.importData = data;
    }

    public void process(Directories directories){
        Directory parentDirectory = new Directory(null, "Root");
        Directory root = parentDirectory;
        directories.addRoot(root);
        for(int i = 0; i < importData.numberOfRows(); i++){
            String row = importData.realeaseDataRow(i);
            if(row.equals("$ cd /")){
               parentDirectory = root;
               continue;
            }
            if(row.equals("$ cd ..") ){
                parentDirectory = parentDirectory.getParent();
                continue;
            }
            if(row.startsWith("$ cd ")){
                String directoryName = row.split(" ")[2];
                parentDirectory = directories.createAndStore(directoryName, parentDirectory);
                continue;
            }
            if(row.equals("$ ls")){
                continue;
            }
            if(row.startsWith("dir ")){
                directories.createAndStore(row.split(" ")[1], parentDirectory);
            }
            else{
                int storage = Integer.parseInt(row.split(" ")[0]);
                String fileName = row.split(" ")[1];
                FileInDirectory file = new FileInDirectory(fileName, storage);
                parentDirectory.addFile(file);
            }
        }
    }
}
