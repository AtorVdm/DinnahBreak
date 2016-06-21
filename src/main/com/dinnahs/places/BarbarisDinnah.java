package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class BarbarisDinnah extends Dinnah {
	
	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		String[] itemIds = new String[] {"supy", "goryachie-blyuda", "salaty", "pizza", "sushi-i-roly", "sety", "deserty"};
		for (String itemId : itemIds) {
			urls.add(String.format("http://www.barbarisbar.com.ua/catalog/%s/", itemId));
		}
		
		return processGetDinnahs(urls);
	}
	
	protected DinnahSet parseDishes(String url) throws Exception {
		doc = getInstantConnection(url);
		
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName = doc.select("#content-inner h1[class=\"h1-cat\"]").get(0).childNode(0).toString();
		
		Elements blocks = doc.select(".category-inner-block .category-product-block");
		
		for (Element block : blocks)
		{
			Elements name = block.select(".hover-block h2 a");
			Elements price = block.select(".variants .variant .price");
			
			if (price.size() == 1) {
				records.add(new DinnahRecord(name.first().childNode(0).toString(), price.get(0).childNode(0).toString().replace(" ", "")));
			} else if (price.size() == 2) {
				records.add(new DinnahRecord(name.first().childNode(0).toString() + " (средняя)", price.get(0).childNode(0).toString().replace(" ", "")));
				records.add(new DinnahRecord(name.first().childNode(0).toString() + " (большая)", price.get(1).childNode(0).toString().replace(" ", "")));
			} else {
				throw new Exception("Price element has 0 or > 2 values.");
			}
		}
		return new DinnahSet(records, categoryName);
	}
}
