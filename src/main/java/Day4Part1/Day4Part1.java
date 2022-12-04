package Day4Part1;

public class Day4Part1 {
    public static void main(String[] args){
        Pairs pairs = new Pairs();
        new ImportData().importData(pairs);
        System.out.println(pairs.numberOfPairsWhereOnePairContainsTheOther());
    }
}
