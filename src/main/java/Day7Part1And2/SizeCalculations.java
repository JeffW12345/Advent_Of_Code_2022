package Day7Part1And2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SizeCalculations {

    private static HashSet<Directory> directories;
    private static ArrayList<Long> directorySizes;

    public static void controller(HashSet<Directory> aDirectory){
        directories = aDirectory;
        printOutput();
    }

    public static long totalFileSizeFor(Directory toCheck){
        long total = 0;
        for(Directory directory : directories){
            if(directory == toCheck || toCheck.containsChild(directory)){
                total += directory.getFileUsageImmediateDirectory();
            }
        }
        return total;
    }
    public static long fileSizeAllDirectories(long belowOrEqual){
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

    public static long fileSizeAllDirectories(){
        long total = 0;
        for(Directory directory : directories){
            total += directory.getFileUsageImmediateDirectory();
        }
        return total;
    }

    public static long smallestFileOver(long toCheck){
        Collections.sort(directorySizes);
        for(long amount: directorySizes){
            if(amount >= toCheck){
                return amount;
            }
        }
        return 0;
    }

    public static long sizeOfFileToDelete(int totalSpaceOnHardDrive, int spaceRemainingNeeded) {
        long currentSpaceOccupied = fileSizeAllDirectories();
        long free = totalSpaceOnHardDrive - currentSpaceOccupied;
        long deficit = spaceRemainingNeeded - free;
        return smallestFileOver(deficit);
    }

    public static void printOutput(){
        System.out.println("Part 1: " + fileSizeAllDirectories(100000));
        System.out.println("Part 2: " + sizeOfFileToDelete(70000000, 30000000));
    }
}
