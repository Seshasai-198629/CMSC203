package application;
/*
 * Class: CMSC203 CRN31569
 * Instructor: Ahmed Tarek
 * Description: Random number guesser game using a main method and a method conducting the actual code for the game and the main 
 * 		method running the trial aspect.
 * Due: 
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Seshasai Lakkavajjala
*/
public class Customer {
String name = " ";
int age = 0;
Customer(String name, int age){
this.name = name;
this.age = age;
}
//copy constructor
public Customer(Customer other) {
this.name = other.name;
this.age = other.age;
}

//getters and setters
public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public int getAge() {
return age;
}

public void setAge(int age) {
this.age = age;
}

//toString method
@Override
public String toString() {
return "Customer [name=" + name + ", age=" + age + "]";
}
}


