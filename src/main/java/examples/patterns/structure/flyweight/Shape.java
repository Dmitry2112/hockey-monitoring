package examples.patterns.structure.flyweight;

/**
 * Паттерн Flyweight
 */
public class Shape {
    private final Type type;

    public Shape(Type type) {
        this.type = type;
    }

    public void drawShape(ShapeOptions options) {
        System.out.printf("Фигура типа '%s' и размера '%s' отрисована в цвете '%s'", type, options.getSize(), options.getColor());
        System.out.println();
    }

    public enum Type {
        CIRCLE,
        RECTANGLE,
        TRIANGLE,
    }
}
