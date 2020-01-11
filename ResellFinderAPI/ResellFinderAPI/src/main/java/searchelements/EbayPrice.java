package searchelements;

public class EbayPrice {
	public static enum soldonly {
		TRUE(1),FALSE(0);
		
		private int value;
		private soldonly(final int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.value);
		}
		};
		
		public static void main(String[] args) {
			System.out.println(soldonly.FALSE);
		}
}
