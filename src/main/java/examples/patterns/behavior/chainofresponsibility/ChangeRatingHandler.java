package examples.patterns.behavior.chainofresponsibility;

public class ChangeRatingHandler extends HandlerBase<Athlete> {
    private final int scores;
    private final int coefficient;
    private final boolean terminal;

    public ChangeRatingHandler(int scores, int coefficient, boolean terminal) {
        this.scores = scores;
        this.coefficient = coefficient;
        this.terminal = terminal;
    }

    @Override
    protected boolean doHandle(Athlete context) {
        System.out.printf("Изменение рейтинга игрока: %s%n", context.getName());
        System.out.printf("Старый рейтинг: %s%n", context.getRating());
        context.setRating(context.getRating() + scores * coefficient);
        System.out.printf("Новый рейтинг: %s%n", context.getRating());
        return !terminal;
    }
}
