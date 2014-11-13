
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
