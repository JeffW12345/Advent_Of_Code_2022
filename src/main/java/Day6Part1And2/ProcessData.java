package Day6Part1And2;

import java.util.HashSet;

public class ProcessData {

    ImportData importData;
    public ProcessData(ImportData data) {
        this.importData = data;
    }

    public void process(){
        String row = importData.realeaseDataRow(0);
        System.out.println(getIndexNumber(row, 4));
        System.out.println(getIndexNumber(row, 14));
    }

    private int getIndexNumber(String row, int howFarBack) {
        for (int j = howFarBack - 1; j < row.toCharArray().length; j++){
            HashSet<Character> characters = getSet(row, howFarBack, j);
            if(characters.size() == howFarBack){
                return j + 1;
            }
        }
        return 0;
    }

    private static HashSet<Character> getSet(String data, int numberOfEntriesToGoBack, int current) {
        HashSet<Character> characters = new HashSet<>();
        for(int i = current; i > current - numberOfEntriesToGoBack; i--){
            characters.add(data.toCharArray()[i]);
        }
        return characters;
    }
}

