package examples.patterns.behavior.chainofresponsibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Athlete {
    private String name;
    private int age;
    private int rating;
    private String teamName;
    private String category;

    public Athlete(String name, int age, int rating, String teamName, String category) {
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.teamName = teamName;
        this.category = category;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.rating + " " + this.teamName + " " + this.category;
    }
}
