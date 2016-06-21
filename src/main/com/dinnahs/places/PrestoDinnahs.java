package com.dinnahs.places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class PrestoDinnahs extends Dinnah {

	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		int[] itemIds = new int[] {23, 43, 42, 528, 529, 530, 38, 44, 45, 39};
		for (int itemId : itemIds) {
			urls.add("http://presto.kh.ua/#menu-item-" + itemId);
		}
		List<DinnahSet> dinnahs = new ArrayList<DinnahSet>();
		
		try {
			for (String url : urls) {
				DinnahSet ds = parseDishes(url);
				printProcess(url, true);
				dinnahs.add(ds);
			}
		} catch (Exception ex) {
			System.err.println("Jsoup error: " + ex.getMessage());
		}
		return dinnahs;
	}
	
	protected DinnahSet parseDishes(String url) throws IOException {
		doc = getWaitingConnection(url);
		
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		
		String categoryName = doc.select(".sidebar_content .page_header").first().childNode(0).toString();
		
		Elements blocks = doc.select(".inner .sidebar_content > div");
		
		for (Element block : blocks) {
			Elements name  = block.select(".cufon");
			Elements price = block.select(".price span");
			
			String itemPrice = price.first().childNode(0).toString().replace(" ", "");
			records.add(new DinnahRecord(name.first().childNode(0).toString(), itemPrice));
		}
		
		return new DinnahSet(records, categoryName);
	}
}
