package examples.patterns.structure.proxy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TournamentResultsTable implements TournamentResults {
    @Override
    public String[] getResults() {
        System.out.println("Вызов метода главного класса");
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("./src/main/java/examples/patterns/structure/proxy/tournament_results.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
        return list.toArray(new String[0]);
    }
}
