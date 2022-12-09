package Day7Part1;

import java.util.ArrayList;

public class Directory {
    private final Directory parent;
    boolean hasParent;
    ArrayList<FileInDirectory> files = new ArrayList<>();
    ArrayList<Directory> children = new ArrayList<>();
    private final String directoryName;

    private int fileSizeThisDirectory = 0;

    public Directory(Directory parent, String directoryName) {
        this.parent = parent;
        this.directoryName = directoryName;
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
        current.addChild(currentFinal);
        }
    public void addFile(FileInDirectory file){
        boolean alreadyStored = false;
        for(FileInDirectory aFile : files){
            if (aFile.getName().equals(file.getName())) {
                alreadyStored = true;
                break;
            }
        }
        if(!alreadyStored){
            files.add(file);
            fileSizeThisDirectory += file.getSize();
        }
    }
    public void addChild(Directory directory){
        if(!children.contains(directory)) children.add(directory);
    }
    public int fileSizeImmediateDirectory()
    {
        return fileSizeThisDirectory;
    }

    public Directory getParent(){
        return this.parent;
    }

    public boolean containsChild(Directory directory) {
        return children.contains(directory);
    }
}
