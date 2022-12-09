package Day7Part1And2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SizeCalculations {

    private HashSet<Directory> directories;
    private static ArrayList<Long> directorySizes;

    public void controller(HashSet<Directory> directories){
        this.directories = directories;
        printOutput();
    }

    public long totalFileSizeFor(Directory toCheck){
        long total = 0;
        for(Directory directory : directories){
            if(directory == toCheck || toCheck.containsChild(directory)){
                total += directory.getFileUsageImmediateDirectory();
            }
        }
        return total;
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

    public long sizeOfFileToDelete(int totalSpaceOnHardDrive, int spaceRemainingNeeded) {
        long currentSpaceOccupied = fileSizeAllDirectories();
        long free = totalSpaceOnHardDrive - currentSpaceOccupied;
        long deficit = spaceRemainingNeeded - free;
        return smallestFileOver(deficit);
    }

    public void printOutput(){
        System.out.println("Part 1: " + fileSizeAllDirectories(100000));
        System.out.println("Part 2: " + sizeOfFileToDelete(70000000, 30000000));
    }
}
