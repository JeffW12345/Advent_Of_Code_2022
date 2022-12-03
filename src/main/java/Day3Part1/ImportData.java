package Day3Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportData {
    private final File file = new File("src/main/resources/rucksacks.txt");

    public void importData(Rucksacks rucksacks) {
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Compartment firstCompartment = new Compartment(line.substring(0, (line.length() / 2)));
                Compartment secondCompartment = new Compartment(line.substring(line.length() / 2));
                ArrayList<Compartment> compartments = new ArrayList<>();
                compartments.add(firstCompartment);
                compartments.add(secondCompartment);
                Rucksack rucksack = new Rucksack(compartments);
                rucksacks.add(rucksack);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
