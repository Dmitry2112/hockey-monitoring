package examples.patterns.structure.flyweight;

import examples.patterns.structure.flyweight.ShapeOptions.Size;

public class Usage {
    public static void main(String[] args) {
        Palette palette = new Palette();

        //Нарисовать 3 круга разных цветов и размеров
        palette.getCircle().drawShape(new ShapeOptions("red", Size.MEDIUM));
        palette.getCircle().drawShape(new ShapeOptions("white", Size.SMALL));
        palette.getCircle().drawShape(new ShapeOptions("black", Size.LARGE));
        System.out.println();

        //Нарисовать 3 прямоугольника разных цветов и размеров
        palette.getRectangle().drawShape(new ShapeOptions("green", Size.MEDIUM));
        palette.getRectangle().drawShape(new ShapeOptions("blue", Size.SMALL));
        palette.getRectangle().drawShape(new ShapeOptions("pink", Size.LARGE));
        System.out.println();

        //Нарисовать 3 треугольника разных цветов и размеров
        palette.getTriangle().drawShape(new ShapeOptions("yellow", Size.MEDIUM));
        palette.getTriangle().drawShape(new ShapeOptions("brown", Size.SMALL));
        palette.getTriangle().drawShape(new ShapeOptions("orange", Size.LARGE));
        System.out.println();
    }
}
