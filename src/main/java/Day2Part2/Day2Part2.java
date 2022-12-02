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

    private static int readFileAndCalculateScore(){
        int score = 0;
        try {
            File myObj = new File("src/main/resources/paper-scissor-stone.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String [] playerChoice = myReader.nextLine().split(" ");
                playerChoice[1] = newChoice(playerChoice[1], playerChoice[0]);
                score += incrementForChoice(playerChoice[1]);
                if(didIWin(playerChoice[0], playerChoice[1])){
                    score += 6;
                }
                if(didIDraw(playerChoice[0], playerChoice[1])){
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

    private static int incrementForChoice(String playerChoice) {
        // Rock
        if(playerChoice.equals("X")){
            return 1;
        }
        // Paper
        if(playerChoice.equals("Y")){
            return 2;
        }
        // Scissors
        return 3;
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