package Day3Part2;

import java.io.IOException;

public class Day3Part2 {
    private static final ElfGroups elfGroups = new ElfGroups();
    public static void main(String[] args) throws Exception {
        new ImportData().importData(elfGroups);
        System.out.println(elfGroups.totalPriorityValue());
    }
}
