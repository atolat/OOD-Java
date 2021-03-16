package com.ood.widgetfactory;
/*
 This class demonstrates the use of the decorator pattern
 Requirements:
- A widget factory that draws shapes - circle, triangle, square, etc.
- We want to support a canvas app that uses the widget factory to draw shapes with attributes like
    - color
    - shade
    - etc.
*/
interface Shape {
    String draw();
}

class Circle implements Shape{
    @Override
    public String draw() {
        return "Circle";
    }
}

class Triangle implements Shape{
    @Override
    public String draw() {
        return "Triangle";
    }
}


abstract class ShapeDecorator implements Shape {
    // The decorator holds a reference to the instance of the class it is decorating
    Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String draw() {
        return null;
    }
}

class ColorDecorator extends ShapeDecorator {

    String color;

    public ColorDecorator(String color, Shape shape) {
        super(shape);
        this.color = color;
    }

    @Override
    public String draw() {
        return this.color + " " + this.shape.draw();
    }
}

class ShadeDecorator extends ShapeDecorator {

    String shade;

    public ShadeDecorator(String shade, Shape shape) {
        super(shape);
        this.shade = shade;
    }

    @Override
    public String draw() {
        return this.shade + " " + this.shape.draw();
    }
}

public class WidgetApp {
    public static void main(String[] args) {
        Shape circle = new Circle();
        System.out.println(circle.draw());
        Shape coloredCircle = new ShadeDecorator("Red", circle);
        System.out.println(coloredCircle.draw());
        Shape shadedColoredCircle = new ShadeDecorator("Dotted", coloredCircle);
        System.out.println(shadedColoredCircle.draw());
    }
}
