package examples.patterns.behavior.visitor;

public class Trainer implements HockeyElement {
    @Override
    public void accept(SportCommission commission) {
        commission.inspect(this);
    }
}
