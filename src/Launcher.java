/*
 * Class: CS2223 B01
 * Group: Zachary Robbins & Fiona Heaney
 * Project #1
 * Due: 11/13/14
 */

public class Launcher {

	// Main method
	public static void main(String[] args) {		
		Trading market = new Trading();
		market.getInput();
		market.make_trades();	
	}
}
