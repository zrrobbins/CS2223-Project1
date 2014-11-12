
public class Launcher {

	public static void main(String[] args) {
		//HelloWorld helloObj = new HelloWorld();
		SellOrder testSellOrder = new SellOrder(5,5);
		BuyOrder testBuyOrder = new BuyOrder(3,4);
		
		Trading market = new Trading();
		market.getInput();
		
		//helloObj.sayHello();
		
	
	}
}
