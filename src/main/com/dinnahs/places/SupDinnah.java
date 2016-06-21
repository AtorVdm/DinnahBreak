package com.dinnahs.places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class SupDinnah extends Dinnah {

	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		String[] itemIds = new String[] {"pizza30", "pizza45", "roll", "sushi", "seti", "garniri", "salat", "desert"};
		for (String itemId : itemIds) {
			urls.add(String.format("http://www.sushipizza.cc.ua/%s.html", itemId));
		}

		return processGetDinnahs(urls);
	}

	protected DinnahSet parseDishes(String url) throws IOException {
		doc = getInstantConnection(url);

		List<DinnahRecord> records = new ArrayList<DinnahRecord>();

		String categoryName = doc.select("#imContent #imPgTitle").get(0).childNode(0).toString()
				.replace("Итальянская пицца семейная", "Пицца")
				.replace("Итальянская пицца", "Пицца");

		Elements blocks = doc.select(".imProductListCont");

		for (Element block : blocks) {
			Elements name = block.select("div[itemprop=\"offers\"] h4[itemprop=\"name\"]");
			Elements price = block.select(".imProductListPrice span");

			String itemPrice = price.first().childNode(0).toString().replace(" грн.", "");
			records.add(new DinnahRecord(name.first().childNode(0).toString(), itemPrice));
		}

		return new DinnahSet(records, categoryName);
	}
}
