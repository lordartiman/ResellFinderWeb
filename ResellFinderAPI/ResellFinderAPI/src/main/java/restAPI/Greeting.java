package restAPI;

import java.util.ArrayList;
import java.util.Scanner;

import craigslistsearchelements.Area;
import craigslistsearchelements.Category;
import craigslistsearchelements.Item;
import craigslistsearchelements.Search;
import craigslistsearchelements.State;
import craigslistsearchelements.SubArea;
import craigslistsearchelements.Topic;

/**
 * Just a testing class for responses
 * @author arti
 *
 */
public class Greeting {

	private final long id;
	private final String content;
	private final String testing;
	private Item[] i;
	private Search search;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
		try {
			i = new Item[3];
			i[0] = new Item("https://valdosta.craigslist.org/atq/d/enigma-1981-chevrolet-10/7052366156.html");
			i[1] = new Item("https://valdosta.craigslist.org/atq/d/enigma-1981-chevrolet-10/7052366156.html");
			i[2] = new Item("https://valdosta.craigslist.org/atq/d/enigma-1981-chevrolet-10/7052366156.html");
		} catch (Exception e) {
			i = null;
			e.printStackTrace();
		}
		testing = "hi";
		search = newSearch();
	}
	
	public Greeting(long id) {
		this.id = id;
		this.search = new Search();
		search.getStateMap().keySet();
		this.testing = "";
		this.content = "";
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	public String getTesting() {
		return testing;
	}
	
	public Item[] getI() {
		return i;
	}
	
	public Search getSearch() {
		return search;
	}
	
	public static Search newSearch() {
		Scanner scan = new Scanner(System.in);
    	Search search = new Search();

    	System.out.println("Choose from a list of States:");
        for (String state: search.getStateMap().keySet()) {
        	System.out.print(state + "\t");
        }
        String stateInput = scan.nextLine();
        search = new State(stateInput);

        if (search.hasArea()) {
        	System.out.println("Choose from a list of Areas:");
        	for (String area: search.getAreaMap().keySet()) {
        		System.out.print(area + "\t");
        	}
        	String areaInput = scan.nextLine();
        	search = new Area(search, areaInput);
        }

        if (search.hasSubArea()) {
        	System.out.println("Choose from a list of Sub Areas:");
        	for (String subArea: search.getSubAreaMap().keySet()) {
        		System.out.print(subArea + "\t");
        	}
        	String subAreaInput = scan.nextLine();
        	search = new SubArea(search, subAreaInput);
        }

        System.out.println("Choose from a list of Topics:");
        for (String topic: search.getTopicMap().keySet()) {
        	System.out.print(topic + "\t");
        }
       	String topicInput = scan.nextLine();
       	search = new Topic(search, topicInput);

       	System.out.println("Choose from a list of Categories:");
       	for (String category: search.getCategoryMap().keySet()) {
        	System.out.print(category + "\t");
        }
       	String categoryInput = scan.nextLine();
       	search = new Category(search, categoryInput);
       	return search;
	}
}
