package Day4Part1;

import java.util.ArrayList;

public class Pairs {
    private final ArrayList<Pair> pairs = new ArrayList<>();

    public void add(Pair pair){
        pairs.add(pair);
    }
    public int numberOfPairsWhereOnePairContainsTheOther() {
        int count = 0;
        for(Pair pair : pairs){
            if(pair.doesOneRangeContainTheOther()){
                count++;
            }
        }
        return count;
    }
}
