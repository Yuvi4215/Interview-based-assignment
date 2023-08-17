package com.core_java.assignment1;

/*Write a Java program that uses polymorphism by defining an interface called Shape
with methods to calculate the area and perimeter of a shape. Then create classes
that implement the Shape interface for different types of shapes, such as circles and
triangles.*/
public class Question {

	public static void main(String[] args) {
		 Circle circle = new Circle(5);
	     Triangle triangle = new Triangle(3, 4, 5);

	     Shape[] shapes = {circle, triangle};
	     for (Shape shape : shapes) {
	       System.out.println("Area of "+shape.getClass().getSimpleName()+": " + shape.calculateArea());
	       System.out.println("Perimeter of "+shape.getClass().getSimpleName()+": " + shape.calculatePerimeter());
	       System.out.println();
	   }
	}

}
