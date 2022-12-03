package Day3Part1;

import java.io.IOException;

public class Day3Part1 {
    private static final Rucksacks rucksacks = new Rucksacks();
    public static void main(String[] args) throws IOException {
        new ImportData().importData(rucksacks);
        System.out.println(rucksacks.totalPriorityValue());
    }
}
