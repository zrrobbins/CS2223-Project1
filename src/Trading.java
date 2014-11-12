
public class Trading {

		MaxPQ<Order> buyOrders = new MaxPQ<Order>();
		MinPQ<Order> sellOrders = new MinPQ<Order>();

		
		public void getInput()
		{
			// get the input lines into an array
	        String[] inputLines = StdIn.readAllLines();
	        int numLines = inputLines.length;
	        
	        System.out.println("First input: " + inputLines[0]);
	        System.out.println("Number of input lines: " + numLines);
		}
		
		private void make_trades(MaxPQ<Order> buys, MinPQ<Order> sells)
		{
			
		}
}
