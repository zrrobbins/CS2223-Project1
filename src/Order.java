
public abstract class Order implements Comparable<Order> {

		private int price;
		private int quantity;
		
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
		
		public int getPrice() {
			return this.price;
		}
		
		public void setPrice(int p) {
			this.price = p;
		}
		
		public int getQuantity() {
			return this.quantity;
		}
		
		public void setQuantity(int q) {
			this.quantity = q;
		} 
}
