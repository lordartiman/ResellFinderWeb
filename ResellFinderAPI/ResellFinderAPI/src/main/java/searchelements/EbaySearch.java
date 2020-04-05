package searchelements;

/**
 * Class containing ebay search methods for price comparison and deal finding
 * Class methods interact directly with the ebay API
 * @author Arti Shala
 *
 */
public class EbaySearch {
	private String endpoint = "https://svcs.ebay.com/services/search/FindingService/v1";
	
	
	
	/**
	 * Accepts an Item and returns a double array containing two doubles
	 * the first double in the array is the estimated profit margin, based on
	 * the average selling price of the top 10 latest items to be sold that fit
	 * the keywords in the search, minus eBay selling fees, shipping, and Paypal fees
	 * and the second double is a popularity score that is determined by how recent the
	 * 10 latest sales are
	 * @param item the Item object of the item beings searched for on Ebay
	 * @return a double array containing the profit margin and popularity score
	 */
	public double[] getAverageSellingPrice(Item item) {
		//TODO Implement eBay API call as described in comments below
		/*
		 * Take standard parameters and build the request URL
		 * take the keyword and add it to the request URL
		 * make the request and parse the 5 prices from the request
		 * return the average of those 5 prices
		 */
		double[] returnval = {0,0};
		return returnval;
	}
	
	
	
}
