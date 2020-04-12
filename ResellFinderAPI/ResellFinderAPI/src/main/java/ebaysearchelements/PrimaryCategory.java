
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
    "categoryId",
    "categoryName"
})
public class PrimaryCategory {

    @JsonProperty("categoryId")
    private List<String> categoryId = null;
    @JsonProperty("categoryName")
    private List<String> categoryName = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrimaryCategory() {
    }

    /**
     * 
     * @param categoryName
     * @param categoryId
     */
    public PrimaryCategory(List<String> categoryId, List<String> categoryName) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @JsonProperty("categoryId")
    public List<String> getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(List<String> categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("categoryName")
    public List<String> getCategoryName() {
        return categoryName;
    }

    @JsonProperty("categoryName")
    public void setCategoryName(List<String> categoryName) {
        this.categoryName = categoryName;
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
