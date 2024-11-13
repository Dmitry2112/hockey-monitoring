package examples.patterns.behavior.interpreter;

public class TerminalExpression implements Expression {
    private final String value;

    public TerminalExpression(String value) {
        this.value = value;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(value);
    }
}
