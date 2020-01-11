package searchelements;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
	
	public String calcPrice() throws IOException {
		this.website = Jsoup.connect(this.searchurlstring).get();
		return "";
	}
	
	public static void main(String[] args) {
		try {
			Item i = new Item("https://washingtondc.craigslist.org/nva/sop/d/alexandria-xfx-nforce-750i-sli-extreme/7047607262.html");
			EbayPrice ebaydefault = new EbayPrice(i,searchprofile.DEFAULT,conditionvalues.USED);
			EbayPrice ebaymakemodel = new EbayPrice(i,searchprofile.MAKEMODEL,conditionvalues.USED);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String plusify(String original) {
		return original.replaceAll("\\s", "+");
	}
}
