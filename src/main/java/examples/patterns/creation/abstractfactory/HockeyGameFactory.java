package examples.patterns.creation.abstractfactory;

/**
 * Паттерн Abstract factory
 */
public interface HockeyGameFactory {
    Rules newRules();
    Prize newPrize();
}
