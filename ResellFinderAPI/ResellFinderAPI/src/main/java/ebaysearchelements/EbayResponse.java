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
"findCompletedItemsResponse"
})

public class EbayResponse {
	@JsonProperty("findCompletedItemsResponse")
	private List<FindCompletedItemsResponse> findCompletedItemsResponse = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public EbayResponse() {
		
	}
	
	public EbayResponse(List<FindCompletedItemsResponse> findCompletedItemsResponse) {
		super();
		this.findCompletedItemsResponse = findCompletedItemsResponse;
		}
	
	@JsonProperty("findCompletedItemsResponse")
	public List<FindCompletedItemsResponse> getFindCompletedItemsResponse() {
	return findCompletedItemsResponse;
	}

	@JsonProperty("findCompletedItemsResponse")
	public void setFindCompletedItemsResponse(List<FindCompletedItemsResponse> findCompletedItemsResponse) {
	this.findCompletedItemsResponse = findCompletedItemsResponse;
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
