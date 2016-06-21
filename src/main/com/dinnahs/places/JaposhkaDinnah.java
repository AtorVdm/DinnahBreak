package com.dinnahs.places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class JaposhkaDinnah extends Dinnah {
	
	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		int[] itemIds = new int[] {7, 10, 11, 12, 13, 14, 15, 17, 19};
		urls.add("http://www.yaposhka.kh.ua/?page_id=26");
		for (int itemId : itemIds) {
			urls.add("http://www.yaposhka.kh.ua/?cat=" + itemId);
		}
		
		List<DinnahSet> dinnahs = processGetDinnahs(urls);
		
		return dinnahs;
	}

	protected DinnahSet parseDishes(String url) throws IOException {
		doc = getInstantConnection(url);
		
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName;
		
		if (doc.select(".product-head h2").size() != 0) {
			categoryName = doc.select(".product-head h2").get(0).childNode(0).toString();
			
			Elements blocks = doc.select(".content .product-content .product-item");
			
			for (Element block : blocks) {
				Elements name = block.select(".description h3");
				Elements price = block.select(".price .product-price");
				
				records.add(new DinnahRecord(name.first().childNode(0).toString(), price.first().childNode(0).toString()));
			}
		} else {
			categoryName = "ЛАНЧИ";
			
			Elements blocks = doc.select(".content .lunch-content .lunch-course");
			
			int iteration = 0;
			for (Element block : blocks) {
				iteration++;
				Elements nameBlocks = block.select(".lunch-item span");
				for (Element name : nameBlocks) {
					records.add(new DinnahRecord(iteration + ". " + name.childNode(0).toString(), "20"));
				}
			}
		}
		
		return new DinnahSet(records, categoryName);
	}
}
