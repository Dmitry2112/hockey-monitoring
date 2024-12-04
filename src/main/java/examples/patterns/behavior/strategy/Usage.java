package examples.patterns.behavior.strategy;

public class Usage {
    public static void main(String[] args) {
        HockeyPlayer attacker = new HockeyPlayer("Дмитрий", TeamRole.ATTACKER);
        HockeyPlayer goalkeeper = new HockeyPlayer("Иван", TeamRole.GOALKEEPER);

        attacker.play();
        System.out.println();

        goalkeeper.play();
    }
}
