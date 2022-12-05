package Day5Part1;

import java.io.File;
import java.util.Scanner;

public class ImportData {
    private final File file = new File("src/main/resources/crates.txt");

    public void importData(Crates crates) {
        try {
            Scanner scanner = new Scanner(this.file);
            boolean cratePhase = true;
            boolean movePhase = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.contains("[")) {cratePhase = false;}
                if(line.contains("move")) {movePhase = true;}
                if(cratePhase) {
                    extractCratesThisRow(crates, line);}
                if(movePhase){
                    String [] lineSplitBySpace = line.split(" ");
                    int numberToMove = Integer.parseInt(lineSplitBySpace[3]);
                    int from = Integer.parseInt(lineSplitBySpace[5]);
                    int to = Integer.parseInt(lineSplitBySpace[7]);
                    new Move(numberToMove, from, to, crates);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void extractCratesThisRow(Crates crates, String line) {
        char[] lineAsArray = line.toCharArray();
        int crateNumber = 1;
        for(int i = 3; i < line.length(); i+= 4){
            if(lineAsArray[i] != ' '){
                crates.addToCrate(crateNumber, lineAsArray[i] + "");;
            }
            crateNumber++;
        }
    }
}

