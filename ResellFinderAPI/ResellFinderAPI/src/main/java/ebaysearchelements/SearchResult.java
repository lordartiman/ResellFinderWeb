
package ebaysearchelements;

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
    "@count",
    "item"
})
public class SearchResult {

    @JsonProperty("@count")
    private String count;
    @JsonProperty("item")
    private List<Item> item = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchResult() {
    }

    /**
     * 
     * @param item
     * @param count
     */
    public SearchResult(String count, List<Item> item) {
        super();
        this.count = count;
        this.item = item;
    }

    @JsonProperty("@count")
    public String getCount() {
        return count;
    }

    @JsonProperty("@count")
    public void setCount(String count) {
        this.count = count;
    }

    @JsonProperty("item")
    public List<Item> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<Item> item) {
        this.item = item;
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
