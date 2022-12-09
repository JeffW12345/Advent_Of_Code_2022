package Day7Part1And2;

import java.util.ArrayList;
import java.util.Collections;

public class Directories {
    private final ArrayList<Directory> directories = new ArrayList<>();

    private ArrayList<Long> directorySizes;

    public long totalFileSizeFor(Directory toCheck){
        long total = 0;
        for(Directory directory : directories){
            if(directory == toCheck || toCheck.containsChild(directory)){
                total += directory.getFileUsageImmediateDirectory();
            }
        }
        return total;
    }
    public void addRoot(Directory root){
        directories.add(root);
    }

    public long fileSizeAllDirectories(long belowOrEqual){
        long total = 0;
        directorySizes =  new ArrayList<>();
        for(Directory directory : directories){
            long increment = totalFileSizeFor(directory);
            directorySizes.add(increment);
            if(increment <= belowOrEqual){
                total += increment;
            }
        }
        return total;
    }

    public long fileSizeAllDirectories(){
        long total = 0;
        for(Directory directory : directories){
            total += directory.getFileUsageImmediateDirectory();
        }
        return total;
    }

    public long smallestFileOver(long toCheck){
        Collections.sort(directorySizes);
        for(long amount: directorySizes){
            if(amount >= toCheck){
                return amount;
            }
        }
        return 0;
    }
    public Directory createAndStore(String name, Directory parentDirectory) {
        Directory directory = new Directory(parentDirectory, name);
        directories.add(directory);
        return directory;
    }

    public long sizeOfFileToDelete(int totalSpaceOnHardDrive, int spaceRemainingNeeded) {
        long currentSpaceOccupied = fileSizeAllDirectories();
        long free = totalSpaceOnHardDrive - currentSpaceOccupied;
        long deficit = spaceRemainingNeeded - free;
        return smallestFileOver(deficit);
    }
}
