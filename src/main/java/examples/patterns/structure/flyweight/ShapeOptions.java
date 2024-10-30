package examples.patterns.structure.flyweight;

import lombok.Getter;

@Getter
public class ShapeOptions {
    private final String color;
    private final Size size;

    public ShapeOptions(String color, Size size) {
        this.color = color;
        this.size = size;
    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
}
