
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
    "shippingServiceCost",
    "shippingType",
    "shipToLocations",
    "expeditedShipping",
    "oneDayShippingAvailable",
    "handlingTime"
})
public class ShippingInfo {

    @JsonProperty("shippingServiceCost")
    private List<ShippingServiceCost> shippingServiceCost = null;
    @JsonProperty("shippingType")
    private List<String> shippingType = null;
    @JsonProperty("shipToLocations")
    private List<String> shipToLocations = null;
    @JsonProperty("expeditedShipping")
    private List<String> expeditedShipping = null;
    @JsonProperty("oneDayShippingAvailable")
    private List<String> oneDayShippingAvailable = null;
    @JsonProperty("handlingTime")
    private List<String> handlingTime = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShippingInfo() {
    }

    /**
     * 
     * @param handlingTime
     * @param oneDayShippingAvailable
     * @param shippingType
     * @param shippingServiceCost
     * @param shipToLocations
     * @param expeditedShipping
     */
    public ShippingInfo(List<ShippingServiceCost> shippingServiceCost, List<String> shippingType, List<String> shipToLocations, List<String> expeditedShipping, List<String> oneDayShippingAvailable, List<String> handlingTime) {
        super();
        this.shippingServiceCost = shippingServiceCost;
        this.shippingType = shippingType;
        this.shipToLocations = shipToLocations;
        this.expeditedShipping = expeditedShipping;
        this.oneDayShippingAvailable = oneDayShippingAvailable;
        this.handlingTime = handlingTime;
    }

    @JsonProperty("shippingServiceCost")
    public List<ShippingServiceCost> getShippingServiceCost() {
        return shippingServiceCost;
    }

    @JsonProperty("shippingServiceCost")
    public void setShippingServiceCost(List<ShippingServiceCost> shippingServiceCost) {
        this.shippingServiceCost = shippingServiceCost;
    }

    @JsonProperty("shippingType")
    public List<String> getShippingType() {
        return shippingType;
    }

    @JsonProperty("shippingType")
    public void setShippingType(List<String> shippingType) {
        this.shippingType = shippingType;
    }

    @JsonProperty("shipToLocations")
    public List<String> getShipToLocations() {
        return shipToLocations;
    }

    @JsonProperty("shipToLocations")
    public void setShipToLocations(List<String> shipToLocations) {
        this.shipToLocations = shipToLocations;
    }

    @JsonProperty("expeditedShipping")
    public List<String> getExpeditedShipping() {
        return expeditedShipping;
    }

    @JsonProperty("expeditedShipping")
    public void setExpeditedShipping(List<String> expeditedShipping) {
        this.expeditedShipping = expeditedShipping;
    }

    @JsonProperty("oneDayShippingAvailable")
    public List<String> getOneDayShippingAvailable() {
        return oneDayShippingAvailable;
    }

    @JsonProperty("oneDayShippingAvailable")
    public void setOneDayShippingAvailable(List<String> oneDayShippingAvailable) {
        this.oneDayShippingAvailable = oneDayShippingAvailable;
    }

    @JsonProperty("handlingTime")
    public List<String> getHandlingTime() {
        return handlingTime;
    }

    @JsonProperty("handlingTime")
    public void setHandlingTime(List<String> handlingTime) {
        this.handlingTime = handlingTime;
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
