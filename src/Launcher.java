
public class Launcher {

	public static void main(String[] args) {
		//HelloWorld helloObj = new HelloWorld();
		
		Trading market = new Trading();
		market.getInput();
		market.make_trades();
		
		//helloObj.sayHello();
		
	
	}
}
