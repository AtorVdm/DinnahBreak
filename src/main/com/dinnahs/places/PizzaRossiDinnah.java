package com.dinnahs.places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class PizzaRossiDinnah extends Dinnah {

	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		String[] itemIds = new String[] {"supy", "garniry", "salads", "pasta", "blinchiki", "goryachee", "snacks", "desserts", "pizza"};
		for (String itemId : itemIds) {
			urls.add("http://pizzarossi.com/catalog/" + itemId);
		}
		
		return processGetDinnahs(urls);
	}
	
	protected DinnahSet parseDishes(String url) throws IOException {
		doc = getInstantConnection(url);
				
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName = doc.select("#main_content .container .info h1").get(0).childNode(0).toString();
		
		Elements blocks = doc.select(".container .product_list .product");
		
		for (Element block : blocks) {
			Elements name = block.select(".ingredients .name a");
			Elements price = block.select(".price span");

			records.add(new DinnahRecord(name.first().childNode(0).toString(), price.first().childNode(0).toString()));
		}
		
		return new DinnahSet(records, categoryName);
	}
}
