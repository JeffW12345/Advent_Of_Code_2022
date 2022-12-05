package Day5Part2;

import java.util.HashMap;

public class Crates {
    private final HashMap<Integer, Crate> crateNumberToCrate = new HashMap<Integer, Crate>();

    public Crates(int numberOfCrates) {
        for(int i = 1; i < numberOfCrates + 1; i++){
            this.crateNumberToCrate.put(i, new Crate());
        }
    }

    public String returnTopRow(){
        StringBuilder toDisplay = new StringBuilder();
        for(int i =1; i < 10; i++){
            toDisplay.append(this.crateNumberToCrate.get(i).returnTopRow());
        }
        return toDisplay.toString();
    }

    public void transferBetweenCrates(int numberOfCrates, int from, int to){
        // Retrieve characters to be transferred.
        String toAdd = crateNumberToCrate.get(from).returnTopNRows(numberOfCrates);
        // Transfer characters
        crateNumberToCrate.get(to).addCharacterToTopRow(toAdd);
        // Remove characters from first crate number.
        crateNumberToCrate.get(from).removeTopNRows(numberOfCrates);
    }

    public void addToCrate(int crateNumber, String toAdd) {
        crateNumberToCrate.get(crateNumber).addCharacterToBottomRow(toAdd);
    }
}
