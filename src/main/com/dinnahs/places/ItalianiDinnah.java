package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class ItalianiDinnah extends Dinnah {
	
	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		int[] itemIds = new int[] {19, 10, 12, 13, 14};
		for (int itemId : itemIds) {
			urls.add("http://www.italiani.kh.ua/?cat=" + itemId);
		}
		
		return processGetDinnahs(urls);
	}
	
	protected DinnahSet parseDishes(String url) throws Exception {
		doc = getInstantConnection(url);
		
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName = doc.select(".content .product-content .page-title .page-title-text h2").get(0).childNode(0).toString();
		
		Elements blocks = doc.select(".content .product-content .product-item");
		
		for (Element block : blocks) {
			Elements name = block.select(".description h3");
			Elements price = block.select(".pizza-size");
			
			Elements highPrice = price.select("strong .product-price-big");
			Elements lowPrice = price.select("strong .product-price-small");
			Elements normalPrice = price.select(".product-price");
			
			if (!highPrice.isEmpty() && !lowPrice.isEmpty()) {
				records.add(new DinnahRecord(name.first().childNode(0).toString() + " (32)", lowPrice.first().childNode(0).toString()));
				records.add(new DinnahRecord(name.first().childNode(0).toString() + " (42)", highPrice.first().childNode(0).toString()));
			} else if (!normalPrice.isEmpty()) {
				records.add(new DinnahRecord(name.first().childNode(0).toString(), normalPrice.first().childNode(0).toString()));
			} else {
				System.out.println("No price tag found.");
			}
		}
		
		return new DinnahSet(records, categoryName);
	}
}
