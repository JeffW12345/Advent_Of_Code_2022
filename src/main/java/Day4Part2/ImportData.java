package Day4Part2;

import java.io.File;
import java.util.Scanner;

public class ImportData {
    private final File file = new File("src/main/resources/pairs.txt");

    public void importData(Pairs pairs) {
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] pairArray = line.split(",");
                int pair1Start = Integer.parseInt(pairArray[0].split("-")[0]);
                int pair1End = Integer.parseInt(pairArray[0].split("-")[1]);
                Range range1 = new Range(pair1Start, pair1End);
                int pair2Start = Integer.parseInt(pairArray[1].split("-")[0]);
                int pair2End = Integer.parseInt(pairArray[1].split("-")[1]);
                Range range2 = new Range(pair2Start, pair2End);
                Pair pair = new Pair(range1, range2);
                pairs.add(pair);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
