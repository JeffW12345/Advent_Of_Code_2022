package Day3Part1;

import java.util.ArrayList;

public class Rucksacks {
    ArrayList<Rucksack> rucksacks = new ArrayList<>();

    public void add(Rucksack rucksack){
        rucksacks.add(rucksack);
    }

    public int totalPriorityValue(){
        int total = 0;
        for(Rucksack rucksack : rucksacks){
            total += rucksack.calculatePriorityScore();
        }
        return total;
    }
}
