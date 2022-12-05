package Day4Part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Part2Tests {
    @Test
    public void does_numberOfPairsWhereOnePairOverlaps_method_work(){
        // overlap
        Range range1 = new Range(1, 3);
        Range range2 = new Range(2, 2);
        Pair pair1 = new Pair(range1, range2);
        // No overlap
        Range range3 = new Range(1, 3);
        Range range4 = new Range(4, 23);
        Pair pair2 = new Pair(range3, range4);
        // Overlap
        Range range5 = new Range(10, 30);
        Range range6 = new Range(30, 300);
        Pair pair3 = new Pair(range5, range6);
        Pairs pairs = new Pairs();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        Assertions.assertEquals(2, pairs.numberOfPairsWithOverlap());
    }

    @Test

    public void does_doesOneRangeOverlapWithTheOther_return_false_when_it_should(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(4, 23);
        Pair pair1 = new Pair(range1, range2);
        Assertions.assertFalse(pair1.doesOneRangeOverlapWithTheOther());
    }

    @Test
    public void does_doesOneRangeFullyContainTheOther_return_true_when_it_should(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 2);
        Pair pair1 = new Pair(range1, range2);
        Assertions.assertTrue(pair1.doesOneRangeOverlapWithTheOther());
    }

    @Test
    public void does_doIOverLaptWith_method_return_true_when_overlap_present(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 2);
        Assertions.assertTrue(range1.doIOverLapWith(range2));
    }

    @Test
    public void does_doIOverLaptWith_method_return_false_when_overlap_absent(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(10, 20);
        Assertions.assertFalse(range1.doIOverLapWith(range2));
    }

}
