/*
 * Class: CS2223 B01
 * Group: Zachary Robbins & Fiona Heaney
 * Project #1
 * Due: 11/13/14
 */

public class SellOrder extends Order{
		
		// Constructor
		public SellOrder(int p, int q){
			super(p,q);
		}
		
		// Prints out object details
		public void print(){
			System.out.println("(sell, " + this.getPrice() + ", " + this.getQuantity() + ")");
		}
}
