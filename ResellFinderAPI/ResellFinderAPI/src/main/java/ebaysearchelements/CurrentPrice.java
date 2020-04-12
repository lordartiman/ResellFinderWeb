
package ebaysearchelements;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@currencyId",
    "__value__"
})
public class CurrentPrice {

    @JsonProperty("@currencyId")
    private String currencyId;
    @JsonProperty("__value__")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrentPrice() {
    }

    /**
     * 
     * @param currencyId
     * @param value
     */
    public CurrentPrice(String currencyId, String value) {
        super();
        this.currencyId = currencyId;
        this.value = value;
    }

    @JsonProperty("@currencyId")
    public String getCurrencyId() {
        return currencyId;
    }

    @JsonProperty("@currencyId")
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    @JsonProperty("__value__")
    public String getValue() {
        return value;
    }

    @JsonProperty("__value__")
    public void setValue(String value) {
        this.value = value;
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
