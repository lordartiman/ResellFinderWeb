package restAPI;

import org.springframework.web.bind.annotation.RestController;

import craigslistsearchelements.Area;
import craigslistsearchelements.Category;
import craigslistsearchelements.Item;
import craigslistsearchelements.Options;
import craigslistsearchelements.Search;
import craigslistsearchelements.SearchQuery;
import craigslistsearchelements.State;
import craigslistsearchelements.SubArea;
import craigslistsearchelements.Topic;
import craigslistsearchelements.WebScraper;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API Response controller class, class that is responsible for accepting HTTP requests from a client,
 * processing input parameters from the client and passing the parameters to the search methods in order to return
 * a JSON response containing all the listings that match the search with additional information to be displayed 
 * to the user by the front-end
 * @author Arti Shala
 *
 */
@RestController
public class ResponseController {
	//field used for testing only
	private static final String template = "Hello, %s!";
	
	//used to count and give ID's to individual requests and responses
	private final AtomicLong counter = new AtomicLong();
	
	//Options holder field used to hold values while a new Options object is constructed
	private HashMap<String,Boolean> voptions = new HashMap<String,Boolean>();
	
	//A default searchoptions that can be set by the user and used for subsequent requests
	private Options searchoptions = new Options(null, null, new float[] {0,10000});
	
	/**
	 * Method only used for testing, returns a greeting based on the name input
	 * @param name
	 * @return
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="state", defaultValue="null") String name) {
		return new Greeting(counter.incrementAndGet(),
							String.format(template, name));
	}

	
	/**
	 * Returns a JSON list of Craigslist Item objects to the client, using GET request parameters
	 * to narrow the search results, all the parameters are required, if a parameter is missing, 
	 * the server will respond letting the client know it was an incomplete search
	 * @param state the state that the user wishes to search, within the United States only
	 * @param area the "area" that the user wishes to search (used for craigslist scraping)
	 * @param subarea the "sub-area" that the user wishes to search (used for craigslist scraping)
	 * @param topic the "topic" that the user wishes to search (used for craigslist scraping)
	 * @param category the category of items that the user wants to search 
	 * @param time the oldest acceptable search result
	 * @return a JSON list of Items and their properties
	 */
	@RequestMapping("/search")
	public Item[] blanksearch(@RequestParam(value="state", defaultValue="null") String state,
								@RequestParam(value="area",  defaultValue="null") String area,
								@RequestParam(value="subarea", defaultValue="null") String subarea,
								@RequestParam(value="topic", defaultValue="null") String topic,
								@RequestParam(value="category", defaultValue="null") String category,
								@RequestParam(value="time", defaultValue="null") String time){
		
		Search search = new State(state);
		if (search.hasArea()) {
			search = new Area(search, area);
		}
		if (search.hasSubArea()) {
			search = new SubArea(search, subarea);
		}
		search = new Topic(search, topic);
		search = new Category(search, category);
		WebScraper scraper = new WebScraper(search);
		SearchQuery query = new SearchQuery(this.getOptions(), search);
		
		//Return the items found by the SearchQuery as an array, based on the options provided
		return query.updateSearch().toArray(Item[]::new);
	}
	
	/**
	 * Not implemented yet, supposed to return a list of Craigslist states to assist the user
	 * in building a complete search
	 * @param state
	 * @return
	 */
	@RequestMapping("/search/{state}")
	public Response statesearch(@PathVariable("state") String state) {
		//TODO implement the functionality to allow a user to build a searchrequest with this tool
		return new Response(counter.incrementAndGet(), state);
	}
	
	
	/*
	 * Implement functionality to create a custom search with provided option parameters
	 * that will return a filtered search with advanced search logics that are optional
	 * somehow make this so that it is appended to the /search URI
	 * 
	 */
	@RequestMapping("/options")
	public Options getOptions() {
		this.voptions.put("hasImages", false);
		this.voptions.put("multipleImagesOnly",false);
		this.voptions.put("postedToday",false);
		this.voptions.put("bundleDuplicates",false);
		this.voptions.put("hideAllDuplicates",false);
		this.voptions.put("hasMakeModelOnly",true);
		float[] range = new float[] {0,100000000};
		this.searchoptions = new Options(this.voptions,null,range);
		return this.searchoptions;
	}
	
	
}
