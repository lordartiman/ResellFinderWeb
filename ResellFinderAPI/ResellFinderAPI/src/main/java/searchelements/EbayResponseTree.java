package searchelements;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


/**
 * Object to process a JSON response from the Ebay API so that it can be easily traversed
 * @author Arti Shala
 *
 */
public class EbayResponseTree {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	JsonNode rootNode;
	ObjectMapper objectMapper;
	
	public JsonNodeTest() throws IOException {
		objectMapper = new ObjectMapper();
		rootNode = objectMapper.readTree(new File("Ebayresponse.json"));
	}
}
