package examples.patterns.behavior.observer;

public class BlueFan implements Observer {
    private final String name;

    public BlueFan(String name) {
        this.name = name;
    }

    @Override
    public void update(Score score) {
        System.out.printf("%s говорит: ", name);

        if (score.getBlueGoals() > score.getRedGoals()) {
            System.out.println("Ура! Синие побеждают");
        } else if (score.getBlueGoals() < score.getRedGoals()) {
            System.out.println("О нет! Синие проигрывают");
        } else {
            System.out.println("Пока ничья...");
        }
    }
}
