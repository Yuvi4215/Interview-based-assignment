package com.core_java.assignment2;

/*Write a Java program to invoke parent class constructor from a child class. Create
Child class object and parent class constructor must be invoked. Demonstrate by
writing a program. Also explain key points about Constructor.*/

// ***********CONSTRUCTOR KEY POINTS*********************
/*
1. Definition: A constructor is a special type of method that is automatically called when an 
object is created.It is used to initialize the object's state and allocate memory for the object.

2. Name and Signature: The constructor has the same name as the class, and it doesn't have
 any return type, not even void. It may or may not have parameters. 
 If no constructor is defined explicitly in the class, a default constructor 
 (with no parameters) is provided by the compiler.

3. Default Constructor: If no constructor is explicitly defined in the class, 
Java provides a default constructor with no arguments. It initializes member variables with 
default values (e.g., 0, null, false) and calls the constructor of the superclass using super().

4. Parameterized Constructors: Constructors can be overloaded, allowing a class to have multiple
 constructors with different parameter lists. This allows objects to be created with different 
 initial states.

5. Constructor Chaining: Constructors can call other constructors within the same class using 
this(...). This is known as constructor chaining. It is useful when one constructor needs to 
perform common tasks that are also required by other constructors in the class.

6. Implicit and Explicit Constructor Invocation: Within a class, a constructor can explicitly 
call another constructor in the same class using this(...), or it can call a constructor of 
its superclass using super(...). The constructor call must be the first statement in the 
constructor body.

7. No Return Value: Constructors do not have a return type. They implicitly return a new 
instance of the class they belong to.

8. Access Modifiers: Constructors can have access modifiers like public, private, protected, 
or package-private (no modifier). The access level of a constructor determines from where the 
constructor can be called.

9. Initialization: Constructors are primarily used to initialize the object's instance variables
 to meaningful values or to perform any necessary setup before an object is ready for use.

10. Inheritance and Constructors: Constructors are not inherited by the subclass. 
However, the first line of every constructor in a subclass implicitly calls the constructor 
of the superclass using super() to ensure proper initialization of the superclass part of the 
object.

11. Exception Handling: Constructors can throw exceptions. 
If a constructor throws a checked exception, the calling code must handle or 
declare the exception using the throws clause.

12. Static Constructors: Java does not support static constructors. 
The concept of a static initializer block or a static block serves the purpose 
of initializing static members.
*/
class Parent {

	// Parent constructor.
	Parent() {
		System.out.println("Parent class constructor invoked.");
	}
}

class Child extends Parent {
	// Child constructor.
	Child() {
		super(); // This calls the constructor of the Parent class
		System.out.println("Child class constructor invoked.");
	}
}

public class Question {
	public static void main(String[] args) {
		Child child = new Child();
	}
}