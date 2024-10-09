package examples.patterns.creation.abstractfactory;

public class Usage {
    public static void main(String[] args) {
        HockeyGameFactory factory = new CityHockeyGameFactory();
        Rules rules = factory.newRules();
        Prize prize = factory.newPrize();
        System.out.println(rules.getInfo());
        System.out.println(prize.getInfo());

        factory = new RegionHockeyGameFactory();
        rules = factory.newRules();
        prize = factory.newPrize();
        System.out.println(rules.getInfo());
        System.out.println(prize.getInfo());
    }
}
