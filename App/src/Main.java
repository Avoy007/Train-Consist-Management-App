import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagement {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 40);

        System.out.println("Bogie capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " seats");
        }
    }
}