import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagement {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Initialize a HashSet for bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Add bogie IDs, including duplicates
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG103");
        bogieIDs.add("BG102"); // duplicate

        // Display final set of bogie IDs
        System.out.println("Unique bogie IDs in the train:");
        System.out.println(bogieIDs);
    }
}