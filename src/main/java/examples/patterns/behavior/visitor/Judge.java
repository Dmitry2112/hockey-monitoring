package examples.patterns.behavior.visitor;

public class Judge implements HockeyElement {
    @Override
    public void accept(SportCommission commission) {
        commission.inspect(this);
    }
}
