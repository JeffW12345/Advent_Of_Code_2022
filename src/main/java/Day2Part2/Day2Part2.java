package Day2Part2;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2Part2 {

    // Code used to solve https://adventofcode.com/2022/day/2#part2
    public static void main(String[] args) throws IOException {
        System.out.println(readFileAndCalculateScore());
    }

    static int readFileAndCalculateScore(){
        int score = 0;
        try {
            File myObj = new File("src/main/resources/paper-scissor-stone.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String [] parts = line.split(" ");
                parts[1] = newChoice(parts[1], parts[0]);

                // Rock
                if(parts[1].equals("X")){
                    score += 1;
                }
                // Paper
                if(parts[1].equals("Y")){
                    score += 2;
                }
                // Scissors
                if(parts[1].equals("Z")){
                    score += 3;
                }
                if(didIWin(parts[0], parts[1])){
                    score += 6;
                }
                if(didIDraw(parts[0], parts[1])){
                    score += 3;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return score;
    }

    private static String newChoice(String me, String opponent) {
        // If X, need to lose
        if(me.equals("X")){
            return getLoser(opponent);
        }
        // If Y, need to draw
        if(me.equals("Y")){
            return getDraw(me, opponent);
        }
        // If Z, need to win
        return getWin(opponent);
    }

    private static String getWin(String opponent) {
        if(opponent.equals("A")){
            return "Y";
        }
        if(opponent.equals("B")){
            return "Z";
        }
        return "X";
    }

    private static String getDraw(String me, String opponent) {
        if(opponent.equals("A")){
            return "X";
        }
        if(opponent.equals("B")){
            return "Y";
        }
        return "Z";
    }

    private static String getLoser(String opponent) {
        if(opponent.equals("A")){
            return "Z";
        }
        if(opponent.equals("B")){
            return "X";
        }
        return "Y";
    }

    private static boolean didIDraw(String opponent, String me) {
        if(opponent.equals("A") && me.equals("X")){
            return true;
        }
        if(opponent.equals("B") && me.equals("Y")){
            return true;
        }
        return opponent.equals("C") && me.equals("Z");
    }

    private static boolean didIWin(String opponent, String me) {
        if(me.equals("X") && opponent.equals("C")){
            return true;
        }
        if(me.equals("Y") && opponent.equals("A")){
            return true;
        }
        return me.equals("Z") && opponent.equals("B");
    }
}