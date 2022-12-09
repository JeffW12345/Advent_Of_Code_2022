package Day7Part1;

import java.util.HashMap;

public class Directories {
    private final HashMap<String, Directory> nameToDirectory = new HashMap<>();
    public long totalFileSizeFor(Directory toCheck){
        long total = 0;
        for(Directory directory : nameToDirectory.values()){
            if(directory == toCheck || toCheck.containsChild(directory)){
                total += directory.fileSizeImmediateDirectory();
            }
        }
        return total;
    }
    public void addRoot(Directory root){
        nameToDirectory.put("Root", root);
    }

    public long fileSizeAllDirectories(int belowOrEqual){
        long total = 0;
        for(Directory directory : nameToDirectory.values()){
            long increment = totalFileSizeFor(directory);
            if(increment <= belowOrEqual){
                total += increment;
            }
        }
        return total;
    }
    public Directory createAndStore(String name, Directory parentDirectory) {
        if(nameToDirectory.containsKey(name)){
            return nameToDirectory.get(name);
        }
        else{
            Directory directory = new Directory(parentDirectory, name);
            nameToDirectory.put(name, directory);
            return directory;
        }
    }
}
