package examples.patterns.behavior.interpreter;

/**
 * Паттерн Interpreter
 */
public interface Expression {
    boolean interpret(String context);
}
