package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class TukTukDinnah extends Dinnah {

	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		String[] itemIds = new String[] {"korobochka", "sooups-noodles", "salad-zakus", "cushi1", "deserty-ru"};
		for (String itemId : itemIds) {
			urls.add("http://tuktuk.ua/" + itemId);
		}
		return processGetDinnahs(urls);
	}
	
	protected DinnahSet parseDishes(String url) throws Exception {
		doc = getWaitingConnection(url);
		
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName = doc.select("#content .h1-title .cat-title").get(0).childNode(0).toString().replace("&amp;", "�");
		
		Elements blocks = doc.select(".product-grid .cat .cat_inner");
		
		for (Element block : blocks) {
			Elements name  = block.select(".name a");
			Elements price = block.select(".cbx_popup.price");

			if (name.size() == 0 || price.size() == 0) continue;
			
			Pattern pattern = Pattern.compile("([^\\s].*[^\\s])");
			
			String itemName = name.first().childNode(0).toString();
			Matcher matcher = pattern.matcher(itemName);
			itemName = matcher.find()? matcher.group(1) : "";
			
			if (price.size() == 1) {
				records.add(new DinnahRecord(itemName, parsePrice(price.first().childNode(0))));
			} else if (price.size() == 2) {
				records.add(new DinnahRecord(itemName + "(400�)", parsePrice(price.get(0).childNode(0))));
				records.add(new DinnahRecord(itemName + "(250�)", parsePrice(price.get(1).childNode(0))));
			} else {
				throw new Exception("Price element has > 2 values.");
			}
		}
		return new DinnahSet(records, categoryName);
	}
	
	private String parsePrice(Node childNode) {
		return childNode.toString().replace(".0 грн.", "").replace(" ", "").replace(",", "").replace("грн", "").replace("\n", "");
	}
}
