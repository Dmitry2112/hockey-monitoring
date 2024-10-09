package examples.patterns.creation.abstractfactory;

public class RegionHockeyGameFactory implements HockeyGameFactory {
    @Override
    public Rules newRules() {
        return new RegionRules();
    }

    @Override
    public Prize newPrize() {
        return new RegionPrize();
    }
}
