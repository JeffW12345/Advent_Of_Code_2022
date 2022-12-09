package Day7Part1And2;

import java.util.HashSet;

public class Directories {
    private final HashSet<Directory> directoriesSet = new HashSet<>();

    public void printResults(){
        new SizeCalculations().controller(directoriesSet);
    }
    public Directory createAndStore(String name, Directory parentDirectory) {
        Directory directory = new Directory(parentDirectory, name);
        directoriesSet.add(directory);
        return directory;
    }
}
