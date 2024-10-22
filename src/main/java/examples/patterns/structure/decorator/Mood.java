package examples.patterns.structure.decorator;

/**
 * Паттерн Decorator
 */
public abstract class Mood implements Judge {
    private final Judge judge;

    protected Mood(Judge judge) {
        this.judge = judge;
    }

    @Override
    public void sayVerdict() {
        judge.sayVerdict();
    }
}
