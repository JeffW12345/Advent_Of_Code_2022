package Day7Part1And2;

import java.util.ArrayList;

public class Directory {
    private final Directory parent;
    private final boolean hasParent;
    private final ArrayList<Directory> children = new ArrayList<>();
    private int fileSizeThisDirectory = 0;

    public Directory(Directory parent, String directoryName) {
        this.parent = parent;
        hasParent = !directoryName.equals("Root");
        updateAllAncestors();
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

    public Directory getParent(){
        return this.parent;
    }

    public boolean containsChild(Directory directory) {
        return children.contains(directory);
    }
}
