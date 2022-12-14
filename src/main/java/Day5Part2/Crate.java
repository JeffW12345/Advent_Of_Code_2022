package Day5Part2;

public class Crate {
    private String listOfLetters = "";

    public String returnTopRow(){
        return listOfLetters.length() == 0 ? "" : listOfLetters.charAt(0) + "";
    }

    public void addCharacterToBottomRow(String toAdd){
        listOfLetters = listOfLetters + toAdd;
    }

    public void addCharacterToTopRow(String toAdd) {
        listOfLetters = toAdd + listOfLetters;
    }

    public String returnTopNRows(int numberToReturn) {
        return listOfLetters.substring(0, numberToReturn);
    }

    public void removeTopNRows(int numberToRemove) {
        listOfLetters = listOfLetters.substring(numberToRemove);
    }
}
