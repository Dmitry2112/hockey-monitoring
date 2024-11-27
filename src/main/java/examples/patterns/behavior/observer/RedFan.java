package examples.patterns.behavior.observer;

public class RedFan implements Observer {
    private final String name;

    public RedFan(String name) {
        this.name = name;
    }

    @Override
    public void update(Score score) {
        System.out.printf("%s говорит: ", name);

        if (score.getRedGoals() > score.getBlueGoals()) {
            System.out.println("Ура! Красные побеждают");
        } else if (score.getRedGoals() < score.getBlueGoals()) {
            System.out.println("О нет! Красные проигрывают");
        } else {
            System.out.println("Пока ничья...");
        }
    }
}
