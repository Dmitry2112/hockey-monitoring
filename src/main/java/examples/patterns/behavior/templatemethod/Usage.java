package examples.patterns.behavior.templatemethod;

public class Usage {
    public static void main(String[] args) {
        HockeyPlayer male = new MaleHockeyPlayer();
        HockeyPlayer female = new FemaleHockeyPlayer();

        TournamentRegistrar maleRegistrar = new MaleTournamentRegistrar();
        TournamentRegistrar femaleRegistrar = new FemaleTournamentRegistrar();

        maleRegistrar.register(male);

        System.out.println();

        femaleRegistrar.register(female);
    }
}
