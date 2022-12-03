package Day3Part2;

import Day3Part1.PriorityLookup;

import java.util.ArrayList;

public class GroupOfThreeElves {
    private final ArrayList<Rucksack> groupOfThree;

    public GroupOfThreeElves(ArrayList<Rucksack> groupOfThree) {
        this.groupOfThree = groupOfThree;
    }

    public char findDuplicate() throws Exception {
        return groupOfThree.get(0).findDuplicate(groupOfThree.get(1), groupOfThree.get(2));
    }
}
