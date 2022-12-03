package Day3Part2;

import java.util.ArrayList;

public class Rucksack {

    private char duplicate;
    private String contents;
    public Rucksack(String contents){
        this.contents = contents;
    }

    public char findDuplicate(Rucksack rucksackOther1, Rucksack rucksackOther2) throws Exception {
        for(char toCheck : this.contents.toCharArray()){
            if(rucksackOther1.contents.contains(toCheck + "")  && rucksackOther2.contents.contains(toCheck + "")){
                return toCheck;
            }
        }
        throw new Exception("No duplicate present.");
    }
}
