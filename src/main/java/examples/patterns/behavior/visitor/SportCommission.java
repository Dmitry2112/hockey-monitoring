package examples.patterns.behavior.visitor;

/**
 * паттерн Visitor
 */
public interface SportCommission {
    void inspect(HockeyPlayer player);

    void inspect(Judge judge);

    void inspect(Trainer trainer);
}
