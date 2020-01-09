package hello;

import java.util.ArrayList;

public class Greeting {

	private final long id;
	private final String content;
	private final String testing;
	private Item[] i;

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
}
