package examples.patterns.behavior.chainofresponsibility;

import examples.patterns.behavior.chainofresponsibility.Handler.Chain;

public class Usage {
    public static void main(String[] args) {
        Athlete athlete = new Athlete("Иван", 17, 100, "Медведи", "КМС");

        Chain<Athlete> athleteChain = new Chain<>();

        athleteChain.link(new ChangeRatingHandler(100, 2, false));
        athleteChain.link(new ChangeTeamNameHandler("Волки", false));
        athleteChain.link(new ChangeCategoryHandler("МС", false));
        athleteChain.link(new ChangeRatingHandler(100, 3, true));
        athleteChain.link(new ChangeRatingHandler(10000, 4, false));

        athleteChain.run(athlete);

        System.out.println(athlete);
    }
}
