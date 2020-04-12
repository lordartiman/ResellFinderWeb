package ebaysearchelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ack",
"version",
"timestamp",
"searchResult",
"paginationOutput"
})

public class FindCompletedItemsResponse {
	@JsonProperty("ack")
	private List<String> ack = null;
	@JsonProperty("version")
	private List<String> version = null;
	@JsonProperty("timestamp")
	private List<String> timestamp = null;
	@JsonProperty("searchResult")
	private List<SearchResult> searchResult = null;
	@JsonProperty("paginationOutput")
	private List<PaginationOutput> paginationOutput = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public FindCompletedItemsResponse() {
		
	}
	
	public FindCompletedItemsResponse(List<String> ack, List<String> version, List<String> timestamp, List<SearchResult> searchResult, List<PaginationOutput> paginationOutput) {
		super();
		this.ack = ack;
		this.version = version;
		this.timestamp = timestamp;
		this.searchResult = searchResult;
		this.paginationOutput = paginationOutput;
		}
	
	@JsonProperty("ack")
	public List<String> getAck() {
	return ack;
	}

	@JsonProperty("ack")
	public void setAck(List<String> ack) {
	this.ack = ack;
	}

	@JsonProperty("version")
	public List<String> getVersion() {
	return version;
	}

	@JsonProperty("version")
	public void setVersion(List<String> version) {
	this.version = version;
	}

	@JsonProperty("timestamp")
	public List<String> getTimestamp() {
	return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(List<String> timestamp) {
	this.timestamp = timestamp;
	}

	@JsonProperty("searchResult")
	public List<SearchResult> getSearchResult() {
	return searchResult;
	}

	@JsonProperty("searchResult")
	public void setSearchResult(List<SearchResult> searchResult) {
	this.searchResult = searchResult;
	}

	@JsonProperty("paginationOutput")
	public List<PaginationOutput> getPaginationOutput() {
	return paginationOutput;
	}

	@JsonProperty("paginationOutput")
	public void setPaginationOutput(List<PaginationOutput> paginationOutput) {
	this.paginationOutput = paginationOutput;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
	
}
