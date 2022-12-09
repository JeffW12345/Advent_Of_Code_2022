package Day7Part1;

public class FileInDirectory {
    private String name;
    private int size;

    public FileInDirectory(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public String getName() {
        return name;
    }
}
