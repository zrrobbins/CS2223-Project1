
public abstract class Order {

		private int price;
		private int quantity;
		
		public Order(int p, int q){
			this.price = p;
			this.quantity = q;
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
