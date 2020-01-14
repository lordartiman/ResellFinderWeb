package restAPI;

import org.springframework.web.bind.annotation.RestController;

import searchelements.Area;
import searchelements.Category;
import searchelements.Item;
import searchelements.Options;
import searchelements.Search;
import searchelements.SearchQuery;
import searchelements.State;
import searchelements.SubArea;
import searchelements.Topic;
import searchelements.WebScraper;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the rest controller class, responsible for binding methods to URI in the Rest API
 * @author Arti Shala
 *
 */
@RestController
public class ResponseController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private HashMap<String,Boolean> voptions = new HashMap<String,Boolean>();
	private Options searchoptions = new Options(null, null, new float[] {0,10000});
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="state", defaultValue="null") String name) {
		return new Greeting(counter.incrementAndGet(),
							String.format(template, name));
	}
	
	@RequestMapping("/search")
	public Item[] blanksearch(@RequestParam(value="state", defaultValue="null") String state,
								@RequestParam(value="area",  defaultValue="null") String area,
								@RequestParam(value="subarea", defaultValue="null") String subarea,
								@RequestParam(value="topic", defaultValue="null") String topic,
								@RequestParam(value="category", defaultValue="null") String category){
		//TODO handle incomplete searches
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
		//Options options = new Options(null, null, new float[] {0,10000});
		SearchQuery query = new SearchQuery(this.getOptions(), search);
		return query.updateSearch().toArray(Item[]::new);
	}
	
	@RequestMapping("/search/{state}")
	public Response statesearch(@PathVariable("state") String state) {
		return new Response(counter.incrementAndGet(), state);
	}
	
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
