package examples.patterns.behavior.chainofresponsibility;

public class ChangeCategoryHandler extends HandlerBase<Athlete> {
    private final String newCategory;
    private final boolean terminal;

    public ChangeCategoryHandler(final String newCategory, final boolean terminal) {
        this.newCategory = newCategory;
        this.terminal = terminal;
    }

    @Override
    protected boolean doHandle(Athlete context) {
        System.out.printf("Изменение спортивного разряда игрока: %s%n", context.getName());
        System.out.printf("Старый разряд: %s%n", context.getCategory());
        context.setCategory(newCategory);
        System.out.printf("Новый разряд: %s%n", context.getCategory());
        return !terminal;
    }
}
