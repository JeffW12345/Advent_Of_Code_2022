package Day8Part1;

import java.net.MalformedURLException;
import java.net.URL;

public class Day8Part1 {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(new URL("https://adventofcode.com/2022/day/8/answer"));
        ImportData importData = new ImportData();
        importData.importData();
        ProcessData processData = new ProcessData(importData);
    }
}
