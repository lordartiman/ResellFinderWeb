
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
    "bestOfferEnabled",
    "buyItNowAvailable",
    "startTime",
    "endTime",
    "listingType",
    "gift",
    "watchCount"
})
public class ListingInfo {

    @JsonProperty("bestOfferEnabled")
    private List<String> bestOfferEnabled = null;
    @JsonProperty("buyItNowAvailable")
    private List<String> buyItNowAvailable = null;
    @JsonProperty("startTime")
    private List<String> startTime = null;
    @JsonProperty("endTime")
    private List<String> endTime = null;
    @JsonProperty("listingType")
    private List<String> listingType = null;
    @JsonProperty("gift")
    private List<String> gift = null;
    @JsonProperty("watchCount")
    private List<String> watchCount = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListingInfo() {
    }

    /**
     * 
     * @param gift
     * @param buyItNowAvailable
     * @param bestOfferEnabled
     * @param listingType
     * @param startTime
     * @param endTime
     * @param watchCount
     */
    public ListingInfo(List<String> bestOfferEnabled, List<String> buyItNowAvailable, List<String> startTime, List<String> endTime, List<String> listingType, List<String> gift, List<String> watchCount) {
        super();
        this.bestOfferEnabled = bestOfferEnabled;
        this.buyItNowAvailable = buyItNowAvailable;
        this.startTime = startTime;
        this.endTime = endTime;
        this.listingType = listingType;
        this.gift = gift;
        this.watchCount = watchCount;
    }

    @JsonProperty("bestOfferEnabled")
    public List<String> getBestOfferEnabled() {
        return bestOfferEnabled;
    }

    @JsonProperty("bestOfferEnabled")
    public void setBestOfferEnabled(List<String> bestOfferEnabled) {
        this.bestOfferEnabled = bestOfferEnabled;
    }

    @JsonProperty("buyItNowAvailable")
    public List<String> getBuyItNowAvailable() {
        return buyItNowAvailable;
    }

    @JsonProperty("buyItNowAvailable")
    public void setBuyItNowAvailable(List<String> buyItNowAvailable) {
        this.buyItNowAvailable = buyItNowAvailable;
    }

    @JsonProperty("startTime")
    public List<String> getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(List<String> startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("endTime")
    public List<String> getEndTime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEndTime(List<String> endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("listingType")
    public List<String> getListingType() {
        return listingType;
    }

    @JsonProperty("listingType")
    public void setListingType(List<String> listingType) {
        this.listingType = listingType;
    }

    @JsonProperty("gift")
    public List<String> getGift() {
        return gift;
    }

    @JsonProperty("gift")
    public void setGift(List<String> gift) {
        this.gift = gift;
    }

    @JsonProperty("watchCount")
    public List<String> getWatchCount() {
        return watchCount;
    }

    @JsonProperty("watchCount")
    public void setWatchCount(List<String> watchCount) {
        this.watchCount = watchCount;
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
