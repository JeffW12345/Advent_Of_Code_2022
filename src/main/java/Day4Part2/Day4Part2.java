package Day4Part2;

public class Day4Part2 {
    public static void main(String[] args){
        Pairs pairs = new Pairs();
        new ImportData().importData(pairs);
        System.out.println(pairs.numberOfPairsWithOverlap());
    }
}
