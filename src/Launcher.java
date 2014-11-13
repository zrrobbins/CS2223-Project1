
public class Launcher {

	// Main method
	public static void main(String[] args) {
		//create a new instance of trading
		Trading market = new Trading();
		//recieve all user inputs
		market.getInput();
		//execute all possible trades
		market.make_trades();	
	}
}
