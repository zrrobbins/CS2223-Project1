
public class Launcher {

	// Main method
	public static void main(String[] args) {		
		Trading market = new Trading();
		market.getInput();
		market.make_trades();	
	}
}
