package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class MeetMeatDinnah extends Dinnah {
	
	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		int[] itemIds = new int[] {18, 25, 57, 20, 24, 63, 17};
		for (int itemId : itemIds) {
			urls.add("http://meetandmeat.me/index.php?route=product/category&path=" + itemId);
		}
		
		return processGetDinnahs(urls);
	}
	
	protected DinnahSet parseDishes(String url) throws Exception {
		doc = getInstantConnection(url);
		
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName = doc.select(".box-content .box-category li .active.transition").get(0).childNode(0).toString();
		
		Elements blocks = doc.select("#content .product-grid .col-lg-4.col-md-6.col-sm-6.col-xs-12");
		
		for (Element block : blocks) {
			Elements name = block.select(".name");
			Elements price = block.select(".price.col-xs-3 span[id*=\"formated_price\"]");
			
			String itemPrice = price.first().childNode(0).toString().replace("���", "").replace(" ", "");
			
			Pattern pattern = Pattern.compile("([^\\s].*[^\\s])");			
			String itemName = name.first().childNode(0).toString();
			Matcher matcher = pattern.matcher(itemName);
			itemName = matcher.find()? matcher.group(1) : "";

			records.add(new DinnahRecord(itemName, itemPrice));
		}
		
		return new DinnahSet(records, categoryName);
	}
}
