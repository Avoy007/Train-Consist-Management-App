import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

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

    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .toList();
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 70);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 75),
                new Bogie("First Class", 24)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 75)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = filterBogies(list, 70);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));

        int originalSize = list.size();

        filterBogies(list, 70);

        assertEquals(originalSize, list.size());
    }
}