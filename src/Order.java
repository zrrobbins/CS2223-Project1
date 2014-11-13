/*
 * Class: CS2223 B01
 * Group: Zachary Robbins & Fiona Heaney
 * Project #1
 * Due: 11/13/14
 */

public abstract class Order implements Comparable<Order> {

		private int price;
		private int quantity;
		
		// Constructor
		public Order(int p, int q){
			this.price = p;
			this.quantity = q;
		}
		
		@Override
		public int compareTo(Order anotherOrder) {
		    if (this.price > anotherOrder.getPrice())
		    	return 1;
		    else if (this.price < anotherOrder.getPrice())
		    	return -1;
		    else
		    	return 0;  	
		}
		
		// Print method
		public abstract void print();
		
		// Getter method for price
		public int getPrice() {
			return this.price;
		}
		// Getter method for quantity
		public int getQuantity() {
			return this.quantity;
		} 
}
