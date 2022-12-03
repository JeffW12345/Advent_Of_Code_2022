import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import Day3Part1.Compartment;
import Day3Part1.Rucksack;
import java.util.ArrayList;

public class Day3Part1Tests {

    @Test
    public void does_calculate_priority_score_work() throws Exception {
        Compartment compartment1 = new Compartment("abc");
        Compartment compartment2 = new Compartment("cde");
        ArrayList<Compartment> compartments = new ArrayList<Compartment>();
        compartments.add(compartment1);
        compartments.add(compartment2);
        Rucksack rucksack = new Rucksack(compartments);
        int score = rucksack.calculatePriorityScore();
        Assertions.assertEquals(3, rucksack.calculatePriorityScore());
    }

}
