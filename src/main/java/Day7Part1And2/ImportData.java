package Day7Part1And2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportData {
    private final File file = new File("src/main/resources/directories.txt");
    private final ArrayList<String> importedData = new ArrayList<>();

    public void importAndProcess(){
        importData();
        Directories directories = new Directories();
        Directory directory = new Directory(directories);
        directory.createObjects(importedData);
        directories.printResults();
    }
    public void importData() {
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                importedData.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

