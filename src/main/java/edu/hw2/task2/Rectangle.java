package edu.hw2.task2;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle withWidth(int width) {
        return new Rectangle(width, height);
    }

    public Rectangle withHeight(int height) {
        return new Rectangle(width, height);
    }

    public double area() {
        return width * height;
    }
}
