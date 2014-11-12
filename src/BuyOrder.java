
public class BuyOrder extends Order{
		
		public BuyOrder(int p, int q){
			super(p,q);
		}
		
		public void print(){
			System.out.println("(buy, " + this.getPrice() + ", " + this.getQuantity() + ")");
		}
}
