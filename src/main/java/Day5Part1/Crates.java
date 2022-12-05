package Day5Part1;

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

    public void transferBetweenCrates(int crateNumberToGetCharacterFrom, int crateNumberToAddCharacterTo){
        // Retrieve character to be transferred.
        String toAdd = crateNumberToCrate.get(crateNumberToGetCharacterFrom).returnTopRow();
        // Transfer character
        crateNumberToCrate.get(crateNumberToAddCharacterTo).addCharacterToTopRow(toAdd);
        // Remove character from first crate number.
        crateNumberToCrate.get(crateNumberToGetCharacterFrom).removeTopRow();
    }

    public void addToCrate(int crateNumber, String toAdd) {
        crateNumberToCrate.get(crateNumber).addCharacterToBottomRow(toAdd);
    }
}
