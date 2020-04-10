
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
    "pageNumber",
    "entriesPerPage",
    "totalPages",
    "totalEntries"
})
public class PaginationOutput {

    @JsonProperty("pageNumber")
    private List<String> pageNumber = null;
    @JsonProperty("entriesPerPage")
    private List<String> entriesPerPage = null;
    @JsonProperty("totalPages")
    private List<String> totalPages = null;
    @JsonProperty("totalEntries")
    private List<String> totalEntries = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaginationOutput() {
    }

    /**
     * 
     * @param pageNumber
     * @param totalPages
     * @param totalEntries
     * @param entriesPerPage
     */
    public PaginationOutput(List<String> pageNumber, List<String> entriesPerPage, List<String> totalPages, List<String> totalEntries) {
        super();
        this.pageNumber = pageNumber;
        this.entriesPerPage = entriesPerPage;
        this.totalPages = totalPages;
        this.totalEntries = totalEntries;
    }

    @JsonProperty("pageNumber")
    public List<String> getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(List<String> pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("entriesPerPage")
    public List<String> getEntriesPerPage() {
        return entriesPerPage;
    }

    @JsonProperty("entriesPerPage")
    public void setEntriesPerPage(List<String> entriesPerPage) {
        this.entriesPerPage = entriesPerPage;
    }

    @JsonProperty("totalPages")
    public List<String> getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(List<String> totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("totalEntries")
    public List<String> getTotalEntries() {
        return totalEntries;
    }

    @JsonProperty("totalEntries")
    public void setTotalEntries(List<String> totalEntries) {
        this.totalEntries = totalEntries;
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
