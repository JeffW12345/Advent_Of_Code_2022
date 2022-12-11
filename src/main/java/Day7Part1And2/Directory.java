package Day7Part1And2;

import java.util.ArrayList;

public class Directory {
    private Directories directories;
    private Directory parent;
    private boolean hasParent;
    private final ArrayList<Directory> children = new ArrayList<>();
    private int fileSizeThisDirectory = 0;

    public Directory(Directory parent, String directoryName) {
        this.parent = parent;
        hasParent = !directoryName.equals("Root");
        updateAllAncestors();
    }

    public Directory(Directories directories) {
        this.directories = directories;
    }

    public void createObjects(ArrayList<String> data) {
        Directory currentDirectory = new Directory(null, "Root");
        Directory root = currentDirectory;
        for (String row : data) {
            if (row.equals("$ cd /")) {
                currentDirectory = root;
                continue;
            }
            if (row.equals("$ cd ..")) {
                currentDirectory = currentDirectory.parent;
                continue;
            }
            if (row.startsWith("$ cd ")) {
                String directoryName = row.split(" ")[2];
                currentDirectory = directories.createAndStore(directoryName, currentDirectory);
                continue;
            }
            if (row.equals("$ ls")) {
                continue;
            }
            if (row.startsWith("dir ")) {
                directories.createAndStore(row.split(" ")[1], currentDirectory);
            } else {
                currentDirectory.addFile(Integer.parseInt(row.split(" ")[0]));
            }
        }
    }

    private void updateAllAncestors(){
        Directory current = this;
        Directory currentFinal = current;
        while(current.hasParent){
            current.parent.addChild(currentFinal);
            current = current.parent;
            }
        current.addChild(currentFinal); // Adding child to root
        }

    public void addFile(int fileSize){
            fileSizeThisDirectory += fileSize;
    }
    public void addChild(Directory directory){
        if(!children.contains(directory)) children.add(directory);
    }

    public int getFileUsageImmediateDirectory() {
        return fileSizeThisDirectory;
    }

    public boolean containsChild(Directory directory) {
        return children.contains(directory);
    }

    public long numberPlusImmediateDirectory(long total) {
        return fileSizeThisDirectory + total;
    }
}
