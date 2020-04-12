package craigslistsearchelements;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import craigslistsearchelements.WebScraper;

import org.jsoup.nodes.Attributes;

/**
 * An object that represents a user requested search based on parameters entered from the GUI, uses a 
 * search object to contain the default search conditions provided by CL and additional parameters 
 * based on options object generated by the Main GUI. Uses a webscraper object to get the base URL
 * from search object 
 * @author Arti Shala
 * @version 1.0
 * @see Item, WebScraper, Search, Options
 */
public class SearchQuery {
	private Search search;
	private String sellerType, makeSearch, modelSearch, conditionSearch; //Define sellerType and conditionSearch enum for dropdown list;
	private Boolean hasImage , multipleImagesOnly , originalImagesOnly, postedToday , searchTitlesOnly, bundleDuplicates ,
	hideAllDuplicates, hasMakeModelOnly, hasPhoneOnly, cryptoAccepted, deliveryAvailable;
	private int milerange, zipcode, descriptionLengthMin, descriptionLengthMax;
	private float minPrice, maxPrice;
	private LocalTime startDate,endDate;
	private WebScraper scraper;
	
	/**
	 * Accepts an array of keywords to search with, negative keywords to exclude, and creates a new webscraper from the default search provided
	 * Also accepts an Options Object
	 * @param keywords are the keywords to be searched for Items
	 * @param negwords are negative keywords to exclude from search
	 * @param options are the advanced search filters given by an instance of the Options object
	 * @param search is the default search that includes required parameters like area, subarea, and topic before keywords
	 * @see Options, Search
	 */
	public SearchQuery(Options options, Search search) {
		this.setSearchObject(search); 

		scraper = new WebScraper(search);

		if (options != null) {
			HashMap<String, Boolean> checkBoxes = options.getCheckBoxes();
			HashMap<String, String> types = options.getTypes();
			minPrice = options.getMinPrice();
			maxPrice = options.getMaxPrice();
			if (checkBoxes != null) {
				hasImage = checkBoxes.get("hasImages");
				multipleImagesOnly = checkBoxes.get("multipleImagesOnly");
				postedToday = checkBoxes.get("postedToday");
				bundleDuplicates = checkBoxes.get("bundleDuplicates");
				hideAllDuplicates = checkBoxes.get("hideAllDuplicates");
				hasMakeModelOnly = checkBoxes.get("hasMakeModelOnly");
			}

			if (types != null) {
				sellerType = types.get("sellerType");
				makeSearch = types.get("makeSearch");
				modelSearch = types.get("modelSearch"); 
				conditionSearch = types.get("conditionSearch");
			}
		}
	}
	
	
	/**
	 * The method that is actually responsible for using the WebScraper to pull all the Items from the first page of each keyword 
	 * and filter them based on Search and Options.
	 * @return ArrayList<Item> containing all the Items from the first page of each keyword search that fit the parameters
	 */
	public ArrayList<Item> updateSearch() {
		String baseURL = scraper.getWebsite().location();
		ArrayList<Item> itemarraylist = new ArrayList<Item>();
		ArrayList<String> itemURL = new ArrayList<String>();
		Document[] documents = new Document[1];
		for (int i = 0; i < documents.length; i++) {
			try {
				if (!baseURL.equals("none")) {
					try {
						documents[i] = Jsoup.connect(baseURL).get();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					Elements rows = documents[i].getElementsByClass("rows");
					Elements resultrows = rows.get(0).children();
					for (Element resultrow : resultrows) {
						itemURL.add(resultrow.children().get(0).attributes().get("href"));
					}
					for (String s : itemURL) {
						System.out.println(s);
						try {
							if (!s.isEmpty()) {
								Item item = new Item(s);
								try {
									if ((this.hasImage == true) && item.isHasImages() == false )
										item.setNull(true);
									if ((this.multipleImagesOnly == true) && item.isHasMultipleImages() == false)
										item.setNull(true);
									if (this.postedToday == true) {
										LocalDateTime postdate = item.getDateTimePosted();
										LocalDateTime oldestAllowed = LocalDateTime.now().minusDays(1);
										if (postdate.isBefore(oldestAllowed))
											item.setNull(true);
											System.out.println("Item invalidated!");
									}
									if (this.hasMakeModelOnly == true) {
										System.out.println("MAKEMODELTRUE");
										if (item.getMake().isBlank() && item.getModel().isBlank())
											item.setNull(true);
									}
									if (this.bundleDuplicates == true) {
										for (Item it : itemarraylist) {
											if (item.getItemName().contentEquals(it.getItemName()) || item.getDescription().contains(it.getDescription())) {
												item.setNull(true);
											}
										}
									}
									if (this.hideAllDuplicates == true) {
										ArrayList<Item> scheduledforremoval = new ArrayList<Item>();
										for (Item it : itemarraylist) {
											if (item.getItemName().contentEquals(it.getItemName()) || item.getDescription().contentEquals(it.getDescription())) {
												item.setNull(true);
												scheduledforremoval.add(it);
											}
										}
										for (Item r : scheduledforremoval) {
											itemarraylist.remove(r);
										}
									}
								} catch (NullPointerException e) {
									
								}
								if (item.isNull() == false && this.maxPrice >= this.minPrice && item.getItemPrice() >= this.minPrice && item.getItemPrice() <= this.maxPrice) {
									
									itemarraylist.add(item);
									System.out.println(item + "\n");
								}
							}
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					
				}
			} catch (NullPointerException e) {
				System.out.println("NullPointerException");
			}
		}
		return itemarraylist;
	}
	
	/**
	 * Used for testing purposes only, allows user to create a basic search using the console
	 * @return a user created Search Object
	 */
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

	/**
	 * @return the search
	 */
	public Search getSearchObject() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearchObject(Search search) {
		this.search = search;
	}
	
}