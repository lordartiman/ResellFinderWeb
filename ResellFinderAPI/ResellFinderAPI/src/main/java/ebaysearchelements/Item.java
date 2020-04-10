
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
    "itemId",
    "title",
    "globalId",
    "primaryCategory",
    "galleryURL",
    "viewItemURL",
    "paymentMethod",
    "autoPay",
    "postalCode",
    "location",
    "country",
    "shippingInfo",
    "sellingStatus",
    "listingInfo",
    "returnsAccepted",
    "condition",
    "isMultiVariationListing",
    "topRatedListing"
})
public class Item {

    @JsonProperty("itemId")
    private List<String> itemId = null;
    @JsonProperty("title")
    private List<String> title = null;
    @JsonProperty("globalId")
    private List<String> globalId = null;
    @JsonProperty("primaryCategory")
    private List<PrimaryCategory> primaryCategory = null;
    @JsonProperty("galleryURL")
    private List<String> galleryURL = null;
    @JsonProperty("viewItemURL")
    private List<String> viewItemURL = null;
    @JsonProperty("paymentMethod")
    private List<String> paymentMethod = null;
    @JsonProperty("autoPay")
    private List<String> autoPay = null;
    @JsonProperty("postalCode")
    private List<String> postalCode = null;
    @JsonProperty("location")
    private List<String> location = null;
    @JsonProperty("country")
    private List<String> country = null;
    @JsonProperty("shippingInfo")
    private List<ShippingInfo> shippingInfo = null;
    @JsonProperty("sellingStatus")
    private List<Sellingstatus> sellingStatus = null;
    @JsonProperty("listingInfo")
    private List<ListingInfo> listingInfo = null;
    @JsonProperty("returnsAccepted")
    private List<String> returnsAccepted = null;
    @JsonProperty("condition")
    private List<Condition> condition = null;
    @JsonProperty("isMultiVariationListing")
    private List<String> isMultiVariationListing = null;
    @JsonProperty("topRatedListing")
    private List<String> topRatedListing = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param autoPay
     * @param listingInfo
     * @param country
     * @param viewItemURL
     * @param postalCode
     * @param shippingInfo
     * @param globalId
     * @param title
     * @param galleryURL
     * @param itemId
     * @param sellingStatus
     * @param condition
     * @param topRatedListing
     * @param primaryCategory
     * @param returnsAccepted
     * @param paymentMethod
     * @param location
     * @param isMultiVariationListing
     */
    public Item(List<String> itemId, List<String> title, List<String> globalId, List<PrimaryCategory> primaryCategory, List<String> galleryURL, List<String> viewItemURL, List<String> paymentMethod, List<String> autoPay, List<String> postalCode, List<String> location, List<String> country, List<ShippingInfo> shippingInfo, List<Sellingstatus> sellingStatus, List<ListingInfo> listingInfo, List<String> returnsAccepted, List<Condition> condition, List<String> isMultiVariationListing, List<String> topRatedListing) {
        super();
        this.itemId = itemId;
        this.title = title;
        this.globalId = globalId;
        this.primaryCategory = primaryCategory;
        this.galleryURL = galleryURL;
        this.viewItemURL = viewItemURL;
        this.paymentMethod = paymentMethod;
        this.autoPay = autoPay;
        this.postalCode = postalCode;
        this.location = location;
        this.country = country;
        this.shippingInfo = shippingInfo;
        this.sellingStatus = sellingStatus;
        this.listingInfo = listingInfo;
        this.returnsAccepted = returnsAccepted;
        this.condition = condition;
        this.isMultiVariationListing = isMultiVariationListing;
        this.topRatedListing = topRatedListing;
    }

    @JsonProperty("itemId")
    public List<String> getItemId() {
        return itemId;
    }

    @JsonProperty("itemId")
    public void setItemId(List<String> itemId) {
        this.itemId = itemId;
    }

    @JsonProperty("title")
    public List<String> getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(List<String> title) {
        this.title = title;
    }

    @JsonProperty("globalId")
    public List<String> getGlobalId() {
        return globalId;
    }

    @JsonProperty("globalId")
    public void setGlobalId(List<String> globalId) {
        this.globalId = globalId;
    }

    @JsonProperty("primaryCategory")
    public List<PrimaryCategory> getPrimaryCategory() {
        return primaryCategory;
    }

    @JsonProperty("primaryCategory")
    public void setPrimaryCategory(List<PrimaryCategory> primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    @JsonProperty("galleryURL")
    public List<String> getGalleryURL() {
        return galleryURL;
    }

    @JsonProperty("galleryURL")
    public void setGalleryURL(List<String> galleryURL) {
        this.galleryURL = galleryURL;
    }

    @JsonProperty("viewItemURL")
    public List<String> getViewItemURL() {
        return viewItemURL;
    }

    @JsonProperty("viewItemURL")
    public void setViewItemURL(List<String> viewItemURL) {
        this.viewItemURL = viewItemURL;
    }

    @JsonProperty("paymentMethod")
    public List<String> getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("paymentMethod")
    public void setPaymentMethod(List<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("autoPay")
    public List<String> getAutoPay() {
        return autoPay;
    }

    @JsonProperty("autoPay")
    public void setAutoPay(List<String> autoPay) {
        this.autoPay = autoPay;
    }

    @JsonProperty("postalCode")
    public List<String> getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(List<String> postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("location")
    public List<String> getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(List<String> location) {
        this.location = location;
    }

    @JsonProperty("country")
    public List<String> getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(List<String> country) {
        this.country = country;
    }

    @JsonProperty("shippingInfo")
    public List<ShippingInfo> getShippingInfo() {
        return shippingInfo;
    }

    @JsonProperty("shippingInfo")
    public void setShippingInfo(List<ShippingInfo> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    @JsonProperty("sellingStatus")
    public List<Sellingstatus> getSellingStatus() {
        return sellingStatus;
    }

    @JsonProperty("sellingStatus")
    public void setSellingStatus(List<Sellingstatus> sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    @JsonProperty("listingInfo")
    public List<ListingInfo> getListingInfo() {
        return listingInfo;
    }

    @JsonProperty("listingInfo")
    public void setListingInfo(List<ListingInfo> listingInfo) {
        this.listingInfo = listingInfo;
    }

    @JsonProperty("returnsAccepted")
    public List<String> getReturnsAccepted() {
        return returnsAccepted;
    }

    @JsonProperty("returnsAccepted")
    public void setReturnsAccepted(List<String> returnsAccepted) {
        this.returnsAccepted = returnsAccepted;
    }

    @JsonProperty("condition")
    public List<Condition> getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }

    @JsonProperty("isMultiVariationListing")
    public List<String> getIsMultiVariationListing() {
        return isMultiVariationListing;
    }

    @JsonProperty("isMultiVariationListing")
    public void setIsMultiVariationListing(List<String> isMultiVariationListing) {
        this.isMultiVariationListing = isMultiVariationListing;
    }

    @JsonProperty("topRatedListing")
    public List<String> getTopRatedListing() {
        return topRatedListing;
    }

    @JsonProperty("topRatedListing")
    public void setTopRatedListing(List<String> topRatedListing) {
        this.topRatedListing = topRatedListing;
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
