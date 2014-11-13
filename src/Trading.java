
public class Trading {
	
		private String[] inputLines;
		private int numLines;
		private MaxPQ<Order> buyOrders = new MaxPQ<Order>();
		private MinPQ<Order> sellOrders = new MinPQ<Order>();
		
		
		// Gets all lines of input from standard in (command line or file)
		public void getInput()
		{
			// Get the input lines into an array
	        inputLines = StdIn.readAllLines();
	        numLines = inputLines.length;
	        
	        this.parseInput();
		}
		
		// Takes lines of input gathered from getInput(), tokenizes them, and organized them into buy and sell orders.
		// Then adds them to their respective priority queue.
		public void parseInput()
		{
			System.out.println("Input: ");
			for (int i = 0; i < numLines; i++)
			{
				// Tokenize input line
				String[] splitStrings = inputLines[i].split(" ");
				if (splitStrings.length == 3)
				{
					// Create new buy order and insert into buyOrder maxPQ
					if (splitStrings[0].compareTo("buy") == 0) {
						BuyOrder newBOrder = new BuyOrder(Integer.parseInt(splitStrings[1]), Integer.parseInt(splitStrings[2]));
						buyOrders.insert(newBOrder);
						newBOrder.print();
						}
					// Create new sell order and insert into sellOrder minPQ
					else if (splitStrings[0].compareTo("sell") == 0) {
						SellOrder newSOrder = new SellOrder(Integer.parseInt(splitStrings[1]), Integer.parseInt(splitStrings[2]));
						sellOrders.insert(newSOrder); 
						newSOrder.print();
						}
					// Order type is invalid
					else {
						System.out.println("ERROR: Order type not recognized!");
					}
				}
				else
				{
					System.out.println("ERROR: Invalid input format, incorrect number of arguments!");
					System.exit(-1);
				}
			}
			System.out.print("\n");
		}
		
		// Makes all trades based on what is available in buy and sell order queues
		public void make_trades() //(MaxPQ<Order> buys, MinPQ<Order> sells)
		{
			// If one of the queues is empty, market is already at equilibrium, exit
			if (this.buyOrders.isEmpty() || this.sellOrders.isEmpty()) {
				System.out.println("No trades made!");
				return;
			}
			
			System.out.print("The sequence of trades is: ");
			
			// Make all possible trades until market reaches equilibrium
			while(!this.buyOrders.isEmpty() && !this.sellOrders.isEmpty() 
					&& this.buyOrders.max().getPrice() >= this.sellOrders.min().getPrice())
			{
				trade(this.buyOrders.max(), this.sellOrders.min());
			}
			System.out.print("\n\n");
			
			// Prints out all outstanding orders
			printOutstanding();
		}
		
		// Makes a single trade
		public void trade(Order bOrder, Order sOrder) {
			int bQuant = bOrder.getQuantity();
			int sQuant = sOrder.getQuantity();
			
			// If buy order quantity is greater
			if (bQuant > sQuant) {
				bQuant = bQuant - sQuant;
				System.out.print("(" + sOrder.getPrice() + ", " + sQuant + "), ");
				// Delete sell order and buy order, and insert edited buy order
				this.sellOrders.delMin();
				this.buyOrders.delMax();
				this.buyOrders.insert(new BuyOrder(bOrder.getPrice(), bQuant));
			}
			// If sell order quantity is greater
			else if (bQuant < sQuant) {
				sQuant = sQuant - bQuant;
				System.out.print("(" + sOrder.getPrice() + ", " + bQuant + "), ");
				// Delete buy order and sell order, and insert edited sell order
				this.sellOrders.delMin();
				this.buyOrders.delMax();
				this.sellOrders.insert(new SellOrder(sOrder.getPrice(), sQuant));
			}
			// If both quantities are equal for the buy and sell order
			else {
				System.out.print("(" + sOrder.getPrice() + ", " + bQuant + "), ");
				// Delete both buy and sell order
				this.sellOrders.delMin();
				this.buyOrders.delMax();
			}
		}
		
		// This function prints any outstanding buy or sell orders
		public void printOutstanding(){
			// Print out outstanding sell orders
			System.out.print("Outstanding sell orders: ");
			for (int i = this.sellOrders.size(); i > 0; i--){
				System.out.print("(" + sellOrders.min().getPrice() + ", " + sellOrders.min().getQuantity() + "), ");
				sellOrders.delMin();
			}
			System.out.print("\n");
			// Print out outstanding buy orders
			System.out.print("Outstanding buy orders: ");
			for (int i = this.buyOrders.size(); i > 0; i--){
				System.out.print("(" + buyOrders.max().getPrice() + ", " + buyOrders.max().getQuantity() + "), ");
				buyOrders.delMax();
			}
			System.out.print("\n\n");
		}
}
