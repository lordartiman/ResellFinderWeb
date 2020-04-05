package searchelements;

import java.util.HashMap;
import java.util.Map;

/**
 * Class containing ebay search methods for price comparison and deal finding
 * Class methods interact directly with the ebay API
 * @author Arti Shala
 *
 */
public class EbaySearch {
	private String endpoint = "https://svcs.ebay.com/services/search/FindingService/v1";
	private String ebaykey = "ArtiShal-ResellFi-PRD-4196b8010-e158c03b";
	
	
	
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
	
	private Map<String,String> defaultParam(String key){
		Map<String,String> defaultParamMap = new HashMap<>();
		defaultParamMap.put("OPERATION-NAME", "");
		defaultParamMap.put("SERVICE-VERSION", "1.0.0");
		defaultParamMap.put("SECURITY-APPNAME", "ArtiShal-ResellFi-PRD-4196b8010-e158c03b");
		defaultParamMap.put("XML", "");
		defaultParamMap.put("REST-PAYLOAD", "");
		defaultParamMap.put("keywords", "");
		return defaultParamMap;
		
	}
	
	
	
}
