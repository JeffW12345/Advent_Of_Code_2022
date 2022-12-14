package Day4Part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Part1Tests {

    @Test
    public void numberOfPairsWhereOnePairContainsTheOther_method_works(){
        // range1 contains range2
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 2);
        Pair pair1 = new Pair(range1, range2);
        // No overlap
        Range range3 = new Range(1, 3);
        Range range4 = new Range(4, 23);
        Pair pair2 = new Pair(range3, range4);
        // Range6 contains range5
        Range range5 = new Range(10, 30);
        Range range6 = new Range(1, 300);
        Pair pair3 = new Pair(range5, range6);
        Pairs pairs = new Pairs();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        Assertions.assertEquals(2, pairs.numberOfPairsWhereOnePairContainsTheOther());
    }

    @Test

    public void doesOneRangeContainTheOther_returns_false_when_it_should(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(4, 23);
        Pair pair1 = new Pair(range1, range2);
        Assertions.assertFalse(pair1.doesOneRangeContainTheOther());
    }

    @Test
    public void doesOneRangeContainTheOther_returns_true_when_it_should(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 2);
        Pair pair1 = new Pair(range1, range2);
        Assertions.assertTrue(pair1.doesOneRangeContainTheOther());
    }

    @Test
    public void doIContain_method_returns_true_when_it_should(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 2);
        Assertions.assertTrue(range1.doIContainOrAmContainedBy(range2));
    }

    @Test
    public void doIContain_method_returns_false_when_it_should(){
        Range range1 = new Range(1, 3);
        Range range2 = new Range(10, 20);
        Assertions.assertFalse(range1.doIContainOrAmContainedBy(range2));
    }

}
