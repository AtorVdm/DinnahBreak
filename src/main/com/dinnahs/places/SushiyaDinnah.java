package com.dinnahs.places;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class SushiyaDinnah extends Dinnah {

	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		String[] itemIds = new String[] {"supy", "gorjachie-blyuda", "salaty", "nabory", "rolly", "sushi", "sashimi", "imbir_-vasabi_-soevyi-sous", "deserty"};
		for (String itemId : itemIds) {
			urls.add(String.format("http://www.sushiya.ua/ru/dostavka/vse-menyu/%s/", itemId));
		}

		List<DinnahSet> dinnahs = processGetDinnahs(urls);
		List<DinnahRecord> records = new ArrayList<DinnahRecord>();
		records.add(new DinnahRecord("Бизнес ланч", "38"));
		dinnahs.add(0, new DinnahSet(records, "Ланч"));
		return dinnahs;
	}

	protected DinnahSet parseDishes(String url) throws Exception {
		doc = getInstantConnection(url);

		List<DinnahRecord> records = new ArrayList<DinnahRecord>();

		String categoryName = doc.select(".delivery_main.catalog_blud h1").get(0).childNode(0).toString();

		Elements blocks = doc.select(".section_block.delivery_section.delivery_catalog");

		for (Element block : blocks) {
			Elements name = block.select(".section_h2");
			Elements price = block.select(".price");

			String itemPrice = price.first().childNode(0).toString().replace("грн", "").replace(" ", "");
			records.add(new DinnahRecord(name.first().childNode(0).toString(), itemPrice));
		}

		return new DinnahSet(records, categoryName);
	}
}
