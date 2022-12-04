package Day4Part1;

public class Pair {
    private final Range range1;
    private final Range range2;

    public Pair(Range range1, Range range2) {
        this.range1 = range1;
        this.range2 = range2;
    }

    boolean doesOneRangeFullyContainTheOther(){
        return range1.doIOverLapWith(range2);
    }
}
