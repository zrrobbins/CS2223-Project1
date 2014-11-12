
public class Trading {
	
		private String[] inputLines;
		private int numLines;
		private MaxPQ<Order> buyOrders = new MaxPQ<Order>();
		private MinPQ<Order> sellOrders = new MinPQ<Order>();
		
		// Gets all lines of input from standard in (command line or file)
		public void getInput()
		{
			// get the input lines into an array
	        inputLines = StdIn.readAllLines();
	        numLines = inputLines.length;
	        
	        this.parseInput();
	        // Testing functionality
	        System.out.println("First input: " + inputLines[0]);
	        System.out.println("Number of input lines: " + numLines);
		}
		
		// Takes lines of input gathered from getInput(), tokenizes them, and organized them into buy and sell orders.
		// Then adds them to their respective priority queue.
		public void parseInput()
		{
			for (int i = 0; i < numLines; i++)
			{
				String[] splitStrings = inputLines[i].split(" ");
				if (splitStrings.length == 3)
				{
					if (splitStrings[0].compareTo("buy") == 0) {
						BuyOrder newBOrder = new BuyOrder(Integer.parseInt(splitStrings[1]), Integer.parseInt(splitStrings[2]));
						buyOrders.insert(newBOrder);
						}
					else if (splitStrings[0].compareTo("sell") == 0) {
						SellOrder newSOrder = new SellOrder(Integer.parseInt(splitStrings[1]), Integer.parseInt(splitStrings[2]));
						sellOrders.insert(newSOrder);  
						}
					else {
						System.out.println("ERROR: Order type not recognized!");
					}
				}
				else
				{
					System.out.println("ERROR: Invalid input format, incorrect number of arguments!");
					System.exit(-1);
				}
				
				System.out.println("splitStrings[] = " + splitStrings[0] + " " + splitStrings[1] + " " + splitStrings[2]);
			}
			
			System.out.println("Size of buys queue: " + buyOrders.size());
			System.out.println("Size of sells queue: " + sellOrders.size());
		}
		
		// Makes all trades based on what is available in buy and sell order queues
		private void make_trades(MaxPQ<Order> buys, MinPQ<Order> sells)
		{
			return;
		}
}
