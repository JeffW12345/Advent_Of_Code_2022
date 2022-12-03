package Day3Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportData {
    private final File file = new File("src/main/resources/rucksacks.txt");

    public void importData(ElfGroups elfGroups) {
        try {
            Scanner scanner = new Scanner(this.file);
            ArrayList<Rucksack> groupOfThree = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                groupOfThree.add(new Rucksack(line));
                if(groupOfThree.size() == 3){
                    GroupOfThreeElves groupOfThreeElves = new GroupOfThreeElves(groupOfThree);
                    elfGroups.add(groupOfThreeElves);
                    groupOfThree = new ArrayList<>();
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
