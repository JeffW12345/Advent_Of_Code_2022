package Day5Part1;

public class Crate {
    private String listOfLetters = "";

    public String returnTopRow(){
        return listOfLetters.length() == 0 ? "" : listOfLetters.charAt(0) + "";
    }

    public void removeTopRow(){
        listOfLetters = listOfLetters.length() == 0 ? "" : listOfLetters.substring(1);
    }

    public void addCharacterToBottomRow(String toAdd){
        listOfLetters = listOfLetters + toAdd;
    }

    public void addCharacterToTopRow(String toAdd) {
        listOfLetters = toAdd + listOfLetters;
    }
}
