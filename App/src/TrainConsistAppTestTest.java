import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    private int calculateTotal(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        assertEquals(152, calculateTotal(list));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 50)
        );

        assertEquals(100, calculateTotal(list));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Collections.singletonList(
                new Bogie("Sleeper", 72)
        );

        assertEquals(72, calculateTotal(list));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        assertEquals(0, calculateTotal(list));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 30),
                new Bogie("AC Chair", 20)
        );

        assertEquals(50, calculateTotal(list));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC Chair", 20),
                new Bogie("First Class", 30)
        );

        assertEquals(60, calculateTotal(list));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));

        int originalSize = list.size();

        calculateTotal(list);

        assertEquals(originalSize, list.size());
    }
}