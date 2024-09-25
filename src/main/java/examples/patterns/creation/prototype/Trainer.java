package examples.patterns.creation.prototype;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private final String name;
    private final int age;
    private final List<HockeyPlayer> team;

    public Trainer(String name, int age, List<HockeyPlayer> team) {
        this.name = name;
        this.age = age;
        this.team = new ArrayList<>(team);
    }

    public void printTeam() {
        System.out.println("А вот и моя команда: ");
        for (HockeyPlayer player : team) {
            System.out.println(player.getName());
        }
    }
}
