package com.core_java.assignment5;

abstract class AbstractClassExample {
    protected String color;

    public AbstractClassExample(String color) {
        this.color = color;
    }

    abstract double area();

    void displayColor() {
        System.out.println("Color: " + color);
    }
}
