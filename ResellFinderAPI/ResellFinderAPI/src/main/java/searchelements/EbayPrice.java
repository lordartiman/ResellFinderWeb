package searchelements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class EbayPrice {
	private static String baseurlstring = "https://www.ebay.com/sch/i.html?";
	private static String searchurlstring = "";
	private Item clitem;
	private LinkedHashMap<String,String> params = new LinkedHashMap<String,String>();
	private Document website;
	private static enum searchprofile {
		DEFAULT,
		MAKEMODEL;
	}
	private static enum conditionvalues {
		//TODO research eBay URL parameters and fix condition values 
		NEW(1000),
		USED(1500),
		OPENBOX(3000);
		
		private int value;
		private conditionvalues(int v) {
			this.value = v;
		}
		@Override
		public String toString() {
			return String.valueOf(this.value);
		}
	}
	
	public EbayPrice(Item i, searchprofile sprofile, conditionvalues itemcondition) {
		this.clitem = i;
		if (sprofile.equals(searchprofile.DEFAULT)) {
			this.params.put("_nkw=", plusify(i.getItemName()) + "&"); 
			this.params.put("LH_TitleDesc=", "0" + "&");
			this.params.put("LH_Complete=", "1" + "&");
			this.params.put("LH_Sold=","1");
		} else if (sprofile.equals(searchprofile.MAKEMODEL)) {
			this.params.put("_nkw=", plusify(i.getMake() + "+" + i.getModel()) + "&");
			this.params.put("LH_TitleDesc=", "0" + "&");
			this.params.put("LH_Complete=", "1" + "&");
			this.params.put("LH_Sold=","1");
		}
		String finalurl = baseurlstring;
		for (Map.Entry element : this.params.entrySet()) {
			finalurl += element.getKey().toString() + element.getValue().toString();
		}
		this.searchurlstring = finalurl;
		System.out.println(finalurl);
	}
	
	public Double calcPrice() throws IOException {
		this.website = Jsoup.connect(this.searchurlstring).get();
		System.out.println("Search URL: " + this.searchurlstring);
		Elements prices = website.getElementsByClass("POSITIVE"); //TODO filter out results from "No exact match found" and "matching fewer words"
		ArrayList<BigDecimal> pricevalues = new ArrayList<BigDecimal>();
		System.out.println("Price elements: ");
		for (Element e : prices) {
			//System.out.println(e.html().replace("$", ""));
			try {
				pricevalues.add(new BigDecimal(e.html().replace("$", "")));
			} catch (Exception z) {
				z.printStackTrace();
				System.out.println("Value: " + e.html().replace("$", "")); //TODO fix parsing logic for money
				pricevalues.add(new BigDecimal(0.00));
			}
		}
		Double sum = 0.00;
		for (BigDecimal value : pricevalues) {
			sum += value.doubleValue();
		}
		return sum / pricevalues.size();//.divide(new BigDecimal(pricevalues.size()));
	}
	
	public static void main(String[] args) {
		try {
			Item i = new Item("https://washingtondc.craigslist.org/nva/sop/d/alexandria-amd-firepro-v5800-1gb/7053613969.html");
			EbayPrice ebaydefault = new EbayPrice(i,searchprofile.MAKEMODEL,conditionvalues.USED);
			System.out.println(ebaydefault.calcPrice().doubleValue());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String plusify(String original) {
		//TODO replace characters or html artifacts that could interfere with search
		return original.replaceAll("\\s", "+");
	}
}
