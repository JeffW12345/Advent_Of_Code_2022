package Day16Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportData {
    private final ArrayList<String> lines = new ArrayList<>();

    public void importData() {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/volcano.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String releaseDataRow(int rowNumber){
        return lines.get(rowNumber);
    }

    public int numberOfRows(){
        return lines.size();
    }

}

