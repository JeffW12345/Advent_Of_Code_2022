package Day4Part2;

import java.util.ArrayList;

public class Pairs {
    private ArrayList<Pair> pairs = new ArrayList<>();

    public void add(Pair pair){
        pairs.add(pair);
    }
    public int numberOfPairsWithOverlap() {
        int count = 0;
        for(Pair pair : pairs){
            if(pair.doesOneRangeOverlapWithTheOther()){
                count++;
            }
        }
        return count;
    }

}
