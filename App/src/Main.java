import java.util.HashSet;
import java.util.Set;

import java.util.LinkedList;
import java.util.List;

public class TrainConsistManagement {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        trainConsist.add(2, "Pantry Car");

        System.out.println("Train consist after adding bogies:");
        System.out.println(trainConsist);

        trainConsist.removeFirst(); // Engine
        trainConsist.removeLast();  // Guard

        System.out.println("Final train consist after removing first and last bogie:");
        System.out.println(trainConsist);
    }
}