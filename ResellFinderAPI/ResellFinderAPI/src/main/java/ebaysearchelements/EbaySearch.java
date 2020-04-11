package ebaysearchelements;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import craigslistsearchelements.Item;

/**
 * Class containing ebay search methods for price comparison and deal finding
 * Class methods interact directly with the ebay API
 * @author Arti Shala
 *
 */
public class EbaySearch {
	private static String endpoint = "https://svcs.ebay.com/services/search/FindingService/v1";
	private static String ebaykey = "ArtiShal-ResellFi-PRD-4196b8010-e158c03b";
	
	private static String getEndpoint() {
		return endpoint;
	}
	
	private static String getKey() {
		return ebaykey;
	}
	
	public EbaySearch(String endpoint, String ebaykey) {
		this.endpoint = endpoint;
		this.ebaykey = ebaykey;
	}
	
	
	
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
	public float[] getAverageSellingPrice(Item item) {
		//TODO Implement eBay API call as described in comments below
		/*
		 * Take standard parameters and build the request URL
		 * take the keyword and add it to the request URL
		 * make the request and parse the 10 prices from the request
		 * return the average of those 10 prices
		 */
		
		//build the parameters of the search request
		Map<String,String> parameters = defaultParam();
		parameters.put("OPERATION-NAME", "findCompletedItems");
		parameters.put("keywords", "iPhone");
		parameters.put("sortOrder", "EndTimeSoonest");
		parameters.put("itemFilter.name","SoldItemsOnly");
		parameters.put("itemFilter.value", "True");
		parameters.put("paginationInput.entriesPerPage","10");
		
		//create the http request and parse the json response into the ebayresponse object
		EbayResponse ebayresponse = ebayrequest(uriBuilder(parameters));
		
		
		
		float[] returnval = {0,0};
		return returnval;
	}
	
	/**
	 * Returns a default map of parameters that can be modified 
	 * @param key the eBay API key used to authenticate
	 * @return a Map<Key,Value> containing all the basic parameters and empty parameters to be customized
	 */
	private static Map<String,String> defaultParam(){
		Map<String,String> defaultParamMap = new HashMap<>();
		defaultParamMap.put("OPERATION-NAME", "");
		defaultParamMap.put("SERVICE-VERSION", "1.0.0");
		defaultParamMap.put("SECURITY-APPNAME", getKey());
		defaultParamMap.put("RESPONSE-DATA-FORMAT", "JSON");
		defaultParamMap.put("REST-PAYLOAD", "");
		defaultParamMap.put("keywords", "");
		return defaultParamMap;
		
	}
	
	/**
	 * A method to build a GET request URI in String format from a map of the parameters and their values
	 * @param endpoint the base of the URI, without '?' 
	 * @param params a Map<Key,Value> of parameters for the URI request
	 * @return
	 */
	private static String uriBuilder(Map<String,String> params) {
		String base = getEndpoint() + "?";
		for (Entry<String,String> entry : params.entrySet()) 
			base = base + entry.getKey() + "=" + entry.getValue() + "&";
		base = base.substring(0,base.length()-1);
		return base;
	}
	
	/**
	 * Create a new EbayResponse navigable object from a built URI using the uriBuilder method
	 * @param uri a URI constructed using the uriBuilder method
	 * @return an EbayResponse object, which is essentially a parsed object based on the returned JSON
	 */
	private static EbayResponse ebayrequest(String uri) {
		
		HttpClient client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(uri))
				.build();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			EbayResponse ebayresponse = mapper.readValue(response.body(), EbayResponse.class);
			
			//System.out.println(ebayresponse.getFindCompletedItemsResponse().get(0).getSearchResult().get(0).getItem().get(0).getSellingStatus().get(0).getCurrentPrice().get(0).getValue());
			return ebayresponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * testing purposes
	 */
	public static void main(String[] args) {
		
		Map<String,String> parameters = defaultParam();
		parameters.put("OPERATION-NAME", "findCompletedItems");
		parameters.put("keywords", "iPhone");
		parameters.put("sortOrder", "EndTimeSoonest");
		parameters.put("itemFilter.name","SoldItemsOnly");
		parameters.put("itemFilter.value", "True");
		parameters.put("paginationInput.entriesPerPage","5");
		
		EbayResponse responseobject = ebayrequest(uriBuilder(parameters));
		
		
		
	}
}
