package Day3Part1;

import java.util.HashMap;

public class PriorityLookup {
    HashMap<Character, Integer> characterToPriority = new HashMap<>();

    public PriorityLookup() {
        populateDictionary();
    }

    private void populateDictionary() {
        int count = 1;
        for(char alphabet = 'a'; alphabet <='z'; alphabet++ ){
            characterToPriority.put(alphabet, count);
            count++;
        }
        for(char alphabet = 'A'; alphabet <='Z'; alphabet++ ) {
            characterToPriority.put(alphabet, count);
            count++;
        }
    }

    public int valueFor(Character toCheck){
        return characterToPriority.get(toCheck);
    }
}
