package Day3Part1;

import java.util.ArrayList;

public class Rucksack {
    ArrayList<Compartment> compartments;
    private final char duplicate;

    public Rucksack(ArrayList<Compartment> compartments) throws Exception {
        this.compartments = compartments;
        this.duplicate = findDuplicate();
    }

    private char findDuplicate() throws Exception {
        return compartments.get(0).findDuplicate(compartments.get(1));
    }

    public int calculatePriorityScore(){
        return new PriorityLookup().valueFor(this.duplicate);
    }

}
