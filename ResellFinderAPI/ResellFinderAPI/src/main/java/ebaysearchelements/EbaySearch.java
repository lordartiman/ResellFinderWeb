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
		 * make the request and parse the 5 prices from the request
		 * return the average of those 5 prices
		 */
		
		float[] returnval = {0,0};
		return returnval;
	}
	
	/**
	 * Returns a default map of parameters that can be modified 
	 * @param key the eBay API key used to authenticate
	 * @return a Map<Key,Value> containing all the basic parameters and empty parameters to be customized
	 */
	private static Map<String,String> defaultParam(String key){
		Map<String,String> defaultParamMap = new HashMap<>();
		defaultParamMap.put("OPERATION-NAME", "");
		defaultParamMap.put("SERVICE-VERSION", "1.0.0");
		defaultParamMap.put("SECURITY-APPNAME", key);
		defaultParamMap.put("XML", "");
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
	private static String uriBuilder(String endpoint, Map<String,String> params) {
		String base = endpoint + "?";
		for (Entry<String,String> entry : params.entrySet()) 
			base = base + entry.getKey() + "=" + entry.getValue() + "&";
		base = base.substring(0,base.length()-1);
		return base;
	}
	
	
	/**
	 * testing purposes
	 */
	public static void main(String[] args) {
		
		/*
		HttpClient client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findCompletedItems&SERVICE-VERSION=1.0.0&SECURITY-APPNAME=ArtiShal-ResellFi-PRD-4196b8010-e158c03b&RESPONSE-DATA-FORMAT=XML&REST-PAYLOAD&keywords=Lenovo&sortOrder=EndTimeSoonest&itemFilter.name=SoldItemsOnly&itemFilter.value=True&paginationInput.entriesPerPage=5"))
				.build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//JSON file to java object
			EbayResponse response = mapper.readValue(new File("/Users/arti/Documents/dev/Resell Finder/ResellFinderGit/ResellFinderWeb/ResellFinderAPI/ResellFinderAPI/bin/main/ebaysearchelements/Ebayresponse.json"), EbayResponse.class);
			
			String prettyprint = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			
			System.out.println(response.getFindCompletedItemsResponse().get(0).getSearchResult().get(0).getItem().get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
