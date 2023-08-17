package com.core_java.assignment5;

/*Demonstrate the difference between abstract class and interface by writing programs
as well as in key points.*/

//***************KEY POINTS**************
/*
1.Definition:
 	Abstract Class:
	 An abstract class is a class that cannot be instantiated on 
	its own and may have abstract (unimplemented) methods. It can have a combination of 
	abstract and concrete methods.
 	
 	Interface:
	 An interface is a reference type in Java that is like a class but contains only 
	 abstract methods and constant fields. All methods in an interface are implicitly public 
	 and abstract.

2. Instantiation:
	Abstract Class: 
	Cannot be instantiated directly with the new keyword. It is meant to be subclassed, 
	and objects can be created from its concrete subclasses.
	
	Interface: 
	Cannot be instantiated directly with the new keyword. It is implemented by classes, 
	and objects are created from the implementing classes.

3.Inheritance:
	Abstract Class: 
	Can have both abstract and concrete methods and can use the extends keyword to extend 
	another class (abstract or concrete) to create a single inheritance relationship.
	
	Interface: 
	Can only have abstract methods and constant fields and can use the implements 
	keyword to implement multiple interfaces, allowing for multiple inheritance through 
	interfaces.

4. Fields:
	Abstract Class: 
	Can have instance variables (fields) that can be inherited and used by subclasses.
	
	Interface: 
	Can have only constant fields (static final variables) which are 
	implicitly public, static, and final.

5. Method Definition:
	Abstract Class: 
	Abstract methods do not have a method body (implementation) in the abstract class. 
	Subclasses must provide implementations for all abstract methods.
	
	Interface: 
	All methods are implicitly abstract and do not have method bodies. 
	Implementing classes must provide implementations for all methods defined in the interface.

6. Access Modifiers:
	Abstract Class: 
	Methods and fields can have any access modifier (public, protected, package-private, 
	or private).
	
	Interface: 
	Methods and fields are implicitly public and cannot have any other access modifier.

7. Design Purpose:
	Abstract Class: 
	Used for sharing code and providing a common base for related classes.
	
	Interface: 
	Used for defining contracts that classes must adhere to, allowing classes of different 
	types to be treated interchangeably through polymorphism.
 * */
class AbstrCircle extends  AbstractClassExample {
    private double radius;

    public AbstrCircle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

}

class IntfcCircle implements InterfaceClassExample {
    private String color;
    private double radius;

    public IntfcCircle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}




public class Question {
	public static void main(String[] args) {
		AbstrCircle fromAbstract = new AbstrCircle("Red", 2.4);
		IntfcCircle fromInterface = new IntfcCircle("Blue", 9.7);
	
		fromAbstract.displayColor();
        System.out.println("Area: " + fromAbstract.area());
        System.out.println();
        
        fromInterface.displayColor();
        System.out.println("Area: " + fromInterface.area());
	
	
	
	}
	

}
