package examples.patterns.structure.flyweight;

import examples.patterns.structure.flyweight.Shape.Type;

public class Palette {
    private Shape circle;
    private Shape rectangle;
    private Shape triangle;

    Shape getCircle() {
        if (circle == null) {
            circle = new Shape(Type.CIRCLE);
        }
        return circle;
    }

    Shape getRectangle() {
        if (rectangle == null) {
            rectangle = new Shape(Type.RECTANGLE);
        }
        return rectangle;
    }

    Shape getTriangle() {
        if (triangle == null) {
            triangle = new Shape(Type.TRIANGLE);
        }
        return triangle;
    }
}
