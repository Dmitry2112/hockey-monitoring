package examples.patterns.creation.prototype;

import lombok.Getter;

/**
 * Паттерн Prototype
 */
public class HockeyPlayer implements User {
    @Getter
    private final String name;
    private final int age;

    public HockeyPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public User copy() {
        return new HockeyPlayer(this.name, this.age);
    }

    @Override
    public String say() {
        return "Здравствуйте, тренер!";
    }
}
