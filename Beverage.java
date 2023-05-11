package application;
/*
 * Class: CMSC203 CRN31569
 * Instructor: Ahmed Tarek
 * Description: A program that employs interfaces to receive and manage customers' beverage orders and their specifications
 * Due: 
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Seshasai Lakkavajjala
*/
import application.SIZE.*;

public abstract class  Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	/** Constructors */
	public Beverage(String n, TYPE t, SIZE s) {
		name = n;
		type = t;
		size = s;
	}
		
	/** Utility */
	public abstract double calcPrice();

	public String toString() {
		return name +", " +size;
	}
	public boolean equals(Beverage bev) {
		if (name.equals(bev.getBevName()) && type==bev.getType() && size==bev.getSize()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** Accessors */
	public String getBevName() {
		return name;
	}
	public TYPE getType() {
		return type;
	}
	public SIZE getSize() {
		return size;
	}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public double getSizePrice() {
		return SIZE_PRICE;
	}
	
	/** Mutators */
	public void setName(String n) {
		name = n;
	}
	public void setType(TYPE t) {
		type  = t;
	}
	public void setSize(SIZE s) {
		size = s;
	}
}
class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_COST = .5;
	private final double SYRUP_COST = .5;
	
	/** Constructors */
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super(n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
	}
	
	/** Utility */
	public String toString() {
		String s = getBevName() +", " +getSize();
		
		if (extraShot) {
			s += " Extra shot";
		}
		if (extraSyrup) {
			s += " Extra syrup";
		}
		
		s += ", $" +calcPrice();
		
		return s;
	}
	public double calcPrice() {
		double price = super.getBasePrice();
		
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		}
		else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		
		if (extraShot) {
			price += SHOT_COST;
		}
		if (extraSyrup) {
			price += SYRUP_COST;
		}
		
		return price;
	}
	public boolean equals(Coffee c) {
		if (super.equals(c) && extraShot==c.getExtraShot() && extraSyrup==c.getExtraSyrup()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** Accessors */
	public boolean getExtraShot() {
		return extraShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public double getShotCost() {
		return SHOT_COST;
	}
	public double getSyrupCost() {
		return SYRUP_COST;
	}
	
	/** Mutators */
	public void setExtraShot(boolean shot) {
		extraShot = shot;
	}
	public void setExtraSyrup(boolean syrup) {
		extraSyrup = syrup;
	}
}

	 class Smoothie extends Beverage{
		private int numOfFruits;
		private boolean addProtein;
		private final double FRUIT_COST = .5;
		private final double PROTEIN_COST = 1.5;
		
		/** Constructors */
		public Smoothie(String n, SIZE s, int nof, boolean ap) {
			super(n, TYPE.SMOOTHIE, s);
			numOfFruits = nof;
			addProtein = ap;
		}
		
		/** Utility */
		public String toString() {
			String s = getBevName() +", " +getSize() +" " +numOfFruits +" Fruits";
			
			if (addProtein) {
				s += " Protein powder";
			}
			
			s += ", $" +calcPrice();
			
			return s;
		}
		public boolean equals(Smoothie s) {
			if (super.equals(s) && numOfFruits==s.getNumOfFruits() && addProtein==s.getAddProtien()) {
				return true;
			}
			else {
				return false;
			}
		}
		public double calcPrice() {
			double price = super.getBasePrice();
			
			if (super.getSize() == SIZE.MEDIUM) {
				price += super.getSizePrice();
			}
			else if (super.getSize() == SIZE.LARGE) {
				price += 2 * super.getSizePrice();
			}
			
			price += numOfFruits * FRUIT_COST;
			if (addProtein) {
				price += PROTEIN_COST;
			}
			
			return price;
		}
		
		/** Accessors */
		public int getNumOfFruits() {
			return numOfFruits;
		}
		public boolean getAddProtien() {
			return addProtein;
		}
		public double getFruitCost() {
			return FRUIT_COST;
		}
		public double getProteinCost() {
			return PROTEIN_COST;
		}
		
		/** Mutators */
		public void setNumOfFruits(int nof) {
			numOfFruits = nof;
		}
		public void setProteinPowder(boolean ap) {
			addProtein = ap;
		}
	}
	     
	    
	    
	    
	 class Alcohol extends Beverage{
			private boolean isWeekend;
			private final double WEEKEND_FEE = .6;
			
			/** Constructors */
			public Alcohol(String n, SIZE s, boolean iw) {
				super(n, TYPE.ALCOHOL, s);
				isWeekend = iw;
			}
			
			/** Utility */
			public String toString() {
				String s = getBevName() +", " +getSize();
				
				if (isWeekend) {
					s += " Weekend";
				}
				
				s += ", $" +calcPrice();
				
				return s;
			}
			public boolean equals(Alcohol a) {
				if (super.equals(a) && isWeekend == a.getIsWeekend()) {
					return true;
				}
				else {
					return false;
				}
			}
			public double calcPrice() {
				double price = super.getBasePrice();
				
				if (super.getSize() == SIZE.MEDIUM) {
					price += super.getSizePrice();
				}
				else if (super.getSize() == SIZE.LARGE) {
					price += 2 * super.getSizePrice();
				}
				
				if (isWeekend) {
					price += WEEKEND_FEE;
				}
				
				return price; 
			}
			
			/** Accessors */
			public boolean getIsWeekend() {
				return isWeekend;
			}
			public double getWeekendFee() {
				return WEEKEND_FEE;
			}
			
			/** Mutators */ 
			public void setIsWeekend(boolean is) {
				isWeekend = is;
			}
		}
    