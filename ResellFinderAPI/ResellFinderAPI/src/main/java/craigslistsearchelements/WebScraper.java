package craigslistsearchelements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import craigslistsearchelements.Search;

import org.jsoup.nodes.Attributes;

import java.util.ArrayList;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The object used to generate a base URL to scrape for items, based on a search object
 * @author Ryan Lee
 *
 */
public class WebScraper {
	private Document website;
	private Search search;


	/**
	 * Initializes the webscraper 
	 * @param search the search object used to generate the base URL
	 * @param scan used for testing
	 */
	public WebScraper(Search search) {
		this.search = search;


		try {
			String subArea = "";
			if (search.hasSubArea()) {
				subArea += search.getSubAreaMap().get(search.getSubArea()) + "/";
			}
			if (!search.getCategory().equals("")) {
				setWebsite(Jsoup.connect(search.website.location() + "/search/" + subArea + search.getCategoryMap().get(search.getCategory())  + "?").get());
			}
			else if (!search.getTopic().equals(""))
				setWebsite(Jsoup.connect(search.website.location() + "/search/" + subArea + search.getTopicMap().get(search.getTopic()) + "?").get());
			else
				throw new Exception("Not a topic or category");
		}
		catch(IOException e) {
			setWebsite(null);
			System.out.println("Website not found.");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Used for testing
	 * @param scan
	 */
	public void initialize(Scanner scan) {
		String[] arr = search.getStateMap().keySet().toArray(new String[0]);
		sortArray(arr, 0, arr.length - 1);
		System.out.println("Choose from a list of states:");
		for (String state: arr) {
			System.out.print(state + "     ");
		}
		search.setState(scan.nextLine());

		if (search.setAreaMap()) {
			arr = search.getAreaMap().keySet().toArray(new String[0]);
			sortArray(arr, 0, arr.length - 1);
			System.out.println("Choose from a list of areas:");
			for (String area: arr) {
				System.out.print(area + "     ");
			}
			search.setArea(scan.nextLine());
		}

		if (search.setSubAreaMap()) {
			arr = search.getSubAreaMap().keySet().toArray(new String[0]);
			sortArray(arr, 0, arr.length - 1);
			System.out.println("Choose from a list of sub areas:");
			for (String subArea: arr) {
				System.out.print(subArea + "     ");
			}
			search.setSubArea(scan.nextLine());
		}

		search.setTopicMap();
		arr = search.getTopicMap().keySet().toArray(new String[0]);
		sortArray(arr, 0, arr.length - 1);
		System.out.println("Choose from a list of topics:");
		for (String topic: arr) {
			System.out.print(topic + "     ");
		}
		search.setTopic(scan.nextLine());

		if (search.setCategoryMap()) {
			arr = search.getCategoryMap().keySet().toArray(new String[0]);
			sortArray(arr, 0, arr.length - 1);
			System.out.println("Choose from a list of categories:");
			for (String category: arr) {
				System.out.print(category + "     ");
			}
			search.setCategory(scan.nextLine());
		}

	}

	
	private void sortArray(String[] arr, int low, int high) {
		if (low < high) {
			int index = low;
			String pivot = arr[high];
			for (int i = low; i < high; ++i) {
				if (arr[i].compareTo(pivot) < 0) {
					String temp = arr[index];
					arr[index] = arr[i];
					arr[i] = temp;
					++index;
				}
			}
			String temp = arr[index];
			arr[index] = arr[high];
			arr[high] = temp;
			sortArray(arr, low, index - 1);
			sortArray(arr, index + 1, high);
		}
	}
	
	/**
	 * @return string representation of the webscraper object
	 */
	@Override
	public String toString() {
		if (getWebsite() == null)
			return "No such website";

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);

		printWriter.printf("Website URL: %s\nWebsite Name: %s\nState: %s\nArea: %s\nSub Area: %s\nTopic: %s\nCategory: %s\n", getWebsite().location(), getWebsite().title(), search.getState(), search.getArea(), search.getSubArea(), search.getTopic(), search.getCategory());

		return stringWriter.toString();
	}

	/**
	 * @return the website
	 */
	public Document getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(Document website) {
		this.website = website;
	}
}