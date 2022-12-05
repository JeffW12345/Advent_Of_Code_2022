package Day5Part2;

public class Day5Part2 {
    public static void main(String[] args){
        Crates crates = new Crates(9);
        new ImportData().importData(crates);
        System.out.println(crates.returnTopRow());
    }
}
