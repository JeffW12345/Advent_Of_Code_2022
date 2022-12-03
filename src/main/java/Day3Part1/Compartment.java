package Day3Part1;

public class Compartment {
    String items;

    public Compartment(String items) {
        this.items = items;
    }

    public char findDuplicate(Compartment otherCompartment) throws Exception {
        for(char toCheck : this.items.toCharArray()){
           if(otherCompartment.items.contains(toCheck + "")){
               return toCheck;
           }
        }
        throw new Exception("No duplicate present. This: " + this.items +" other: " + otherCompartment.items);
    }
}
