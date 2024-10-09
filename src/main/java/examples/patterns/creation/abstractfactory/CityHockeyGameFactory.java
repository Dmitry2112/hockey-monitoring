package examples.patterns.creation.abstractfactory;

public class CityHockeyGameFactory implements HockeyGameFactory {
    @Override
    public Rules newRules() {
        return new CityRules();
    }

    @Override
    public Prize newPrize() {
        return new CityPrize();
    }
}
