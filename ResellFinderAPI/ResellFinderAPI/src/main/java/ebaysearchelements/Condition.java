
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
    "conditionId",
    "conditionDisplayName"
})
public class Condition {

    @JsonProperty("conditionId")
    private List<String> conditionId = null;
    @JsonProperty("conditionDisplayName")
    private List<String> conditionDisplayName = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    /**
     * 
     * @param conditionDisplayName
     * @param conditionId
     */
    public Condition(List<String> conditionId, List<String> conditionDisplayName) {
        super();
        this.conditionId = conditionId;
        this.conditionDisplayName = conditionDisplayName;
    }

    @JsonProperty("conditionId")
    public List<String> getConditionId() {
        return conditionId;
    }

    @JsonProperty("conditionId")
    public void setConditionId(List<String> conditionId) {
        this.conditionId = conditionId;
    }

    @JsonProperty("conditionDisplayName")
    public List<String> getConditionDisplayName() {
        return conditionDisplayName;
    }

    @JsonProperty("conditionDisplayName")
    public void setConditionDisplayName(List<String> conditionDisplayName) {
        this.conditionDisplayName = conditionDisplayName;
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
