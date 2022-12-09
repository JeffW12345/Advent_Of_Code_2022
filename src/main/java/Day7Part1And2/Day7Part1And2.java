package Day7Part1And2;

import java.net.MalformedURLException;
import java.net.URL;

public class Day7Part1And2 {
    public static void main(String[] args) throws MalformedURLException {
        ImportData importData = new ImportData();
        importData.importData();
        ProcessData processData = new ProcessData(importData);
        Directories directories = new Directories();
        processData.process(directories);
        System.out.println(new URL("https://adventofcode.com/2022/day/7/answer"));
        directories.printResults();
    }
}