package Day6Part1And2;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportData {
    private final File file = new File("src/main/resources/device.txt");
    private ArrayList<String> lines = new ArrayList<>();

    public void importData() {
        try {
            Scanner scanner = new Scanner(this.file);
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

    public String realeaseDataRow(int rowNumber){
        return lines.get(rowNumber);
    }

    public int numberOfRows(){
        return lines.size();
    }

}

