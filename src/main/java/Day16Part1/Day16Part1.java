package Day16Part1;

import java.net.MalformedURLException;
import java.net.URL;

public class Day16Part1 {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(new URL("https://adventofcode.com/2022/day/16"));
        ImportData importData = new ImportData();
        importData.importData();
        new ProcessData(importData);
    }
}
