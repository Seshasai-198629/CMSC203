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
import java.util.ArrayList;
import java.util.Random;

//OrderInterface isWeekend Issue
public class Order implements OrderInterface, Comparable<Order> {
private int orderNo;
private int orderTime;
private DAY orderDay;
private Customer customer;
private ArrayList<Beverage> beverages;

/** Constructors */
public Order(int ot, DAY od, Customer c) {
	orderNo = genOrderNum();
	orderTime = ot;
	orderDay = od;
	customer = c;
	beverages = new ArrayList<>();
}

/** Utility */
public int genOrderNum() {
	Random rand = new Random();
	// [10_000, 90_000)
	int randInt = rand.nextInt(90_000-10_000)+10_000;
	return randInt;
}
public String toString() {
	String s = "__________________________________"
			   +orderDay.toString() +", " +orderTime
			   +"\n" +customer.toString() +" Order Num: " +orderNo;
	
	for (Beverage b : beverages) {
		s += "\n" +b.toString();
	}
	s += "\n Order Total: " +calcOrderTotal();
	
	return s;
}
public boolean isWeekend() {
	if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
		return true;
	}
	return false;
}
public Beverage getBeverage(int itemNum) {
	return beverages.get(itemNum);
}
public int compareTo(Order o) {
	if (orderNo == o.getOrderNo()) {
		return 0;
	}
	else if (orderNo > o.getOrderNo()) {
		return 1;
	}
	else {
		return -1;
	}
}
public double calcOrderTotal() {
	double orderTotal = 0;
	
	for (Beverage b : beverages) {
		orderTotal += b.calcPrice();
	}
	
	return orderTotal;
}
public int findNumOfBeveType(TYPE type) {
	int count = 0;
	
	for (Beverage b : beverages) {
		if (b.getType() == type) {
			count++;
		}
	}
	
	return count;
}
public int getTotalItems() {
	return beverages.size();
}

/** Add Beverages */
public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
	Coffee c = new Coffee(name, size, extraShot, extraSyrup);
	beverages.add(c);
}
public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) {
	Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
	beverages.add(s);
}
public void addNewBeverage(String name, SIZE size) {
	boolean isWeekend = false;
	if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
		isWeekend = true;
	}
	Alcohol a = new Alcohol(name, size, isWeekend);
	beverages.add(a);
}

/** Accessors */
public int getOrderNo() {
	return orderNo;
}
public int getOrderTime() {
	return orderTime;
}
public DAY getOrderDay() {
	return orderDay;
}
public Customer getCustomer() {
	return new Customer(customer);
}
public ArrayList<Beverage> getBeverages() {
	return beverages;
}

/** Mutators */
public void setOrderNum(int on) {
	orderNo = on;
}
public void setOrderTime(int ot) {
	orderTime = ot;
}
public void setOrderDay(DAY od) {
	orderDay = od;
}
public void setCustomer(Customer c) {
	customer = c;
}
}

