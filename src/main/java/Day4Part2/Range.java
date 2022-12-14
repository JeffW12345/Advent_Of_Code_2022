package Day4Part2;

public class Range {
    private final int start;
    private final int endInclusive;

    public Range(int start, int endInclusive) {
        this.start = start;
        this.endInclusive = endInclusive;
    }

    public boolean doIOverLapWith(Range range2) {
        if(this.start >= range2.start && this.start <= range2.endInclusive){
            return true;
        }
        return range2.start >= this.start && range2.start <= this.endInclusive;
    }
}
