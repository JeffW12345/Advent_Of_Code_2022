package Day3Part2;

import Day3Part1.PriorityLookup;
import Day3Part1.Rucksack;

import java.util.ArrayList;

public class ElfGroups {

    private final ArrayList<GroupOfThreeElves> groupsOfThree = new ArrayList<>();

    public void add(GroupOfThreeElves groupOfThreeElves){
        groupsOfThree.add(groupOfThreeElves);
    }

    public int totalPriorityValue() throws Exception {
        int total = 0;
        for(GroupOfThreeElves groupOfThree : groupsOfThree){
            total += new PriorityLookup().valueFor(groupOfThree.findDuplicate());
        }
        return total;
    }
}
