package examples.patterns.behavior.visitor;

public class HockeyClub implements HockeyElement {
    private final HockeyElement[] elements;

    public HockeyClub() {
        this.elements = new HockeyElement[] {
                new HockeyPlayer(),
                new Judge(),
                new Trainer()
        };
    }

    @Override
    public void accept(SportCommission commission) {
        for (HockeyElement element : elements) {
            element.accept(commission);
        }
    }
}
