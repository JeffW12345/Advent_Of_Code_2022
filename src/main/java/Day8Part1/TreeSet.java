package Day8Part1;

import java.util.HashSet;

public class TreeSet {
    private final HashSet<Tree> treeSet = new HashSet<>();

    public void add(Tree tree){
        treeSet.add(tree);
    }
    public int count(){
        return treeSet.size();
    }
}
