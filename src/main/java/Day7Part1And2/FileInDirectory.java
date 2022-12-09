package Day7Part1And2;

public class FileInDirectory {
    private String name;
    private int thisFileSize;


    public FileInDirectory(String name, int size) {
        this.name = name;
        this.thisFileSize = size;
    }
    public int getSize() {
        return thisFileSize;
    }
    public String getName() {
        return name;
    }
}
