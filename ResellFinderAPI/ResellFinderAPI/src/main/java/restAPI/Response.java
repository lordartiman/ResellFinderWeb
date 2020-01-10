package restAPI;

import searchelements.Search;

/**
 * Testing class
 * @author arti
 *
 */
public class Response {
	private final long id;
	private Search search;
	private String test;
	
	public Response(long id) {
		this.id = id;
		this.search = new Search();
		search.getStateMap().keySet();
	}
	
	public Response(long id, String t) {
		this.test = t;
		this.id = id;
		this.search = new Search();
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getTest() {
		return this.test;
	}
	
	public Search getSearch() {
		return search;
	}
	
	public void setSearch(Search search) {
		this.search = search;
	}
}
