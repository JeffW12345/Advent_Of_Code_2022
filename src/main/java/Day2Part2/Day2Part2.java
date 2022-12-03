package Day2Part2;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2Part2 {

    // Code used to solve https://adventofcode.com/2022/day/2#part2
    public static void main(String[] args) throws IOException {
        Moves moves = new Moves();
        new ReadFromFile().readAndStoreActions(moves);
        System.out.println(new Calculations().calculateScore(moves));
    }


}