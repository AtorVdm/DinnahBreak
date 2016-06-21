package com.dinnahs.places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dinnahs.DinnahRecord;
import com.dinnahs.DinnahSet;

public class BellaDinnah extends Dinnah {

	public List<DinnahSet> getDinnahs() {
		List<String> urls = new ArrayList<String>();
		String[] itemIds = new String[] {"pizza", "nakaronnye_izdeliya", "lazanya", "salaty", "nirovaya_kuhnya", "nalenkaya_yaponiya", "deserty"};
		String[] itemHeaders = new String[] {"Пицца", "Макаронные изделия", "Лазания", "Салаты", "Мировая кухня", "Маленькая япония", "Десерты"};
		for (String itemId : itemIds) {
			urls.add(String.format("http://pizzabella.com.ua/m_menu/show/%s?popularity=DESC&pp=all", itemId));
		}
		List<DinnahSet> dinnahs = processGetDinnahs(urls);
		for (int i = 0; i < dinnahs.size(); i++) {
			dinnahs.get(i).setCategoryName(itemHeaders[i]);
		}
		return dinnahs;
	}

	protected DinnahSet parseDishes(String url) throws IOException {
		doc = getInstantConnection(url);

		List<DinnahRecord> records = new ArrayList<DinnahRecord>();

		String categoryName = "";

		Elements blocks = doc.select(".main_content .menu article");

		for (Element block : blocks) {
			Elements name = block.select(".content_menu h2");
			Elements price = block.select(".container_order .price_onetovar span[id]");

			double itemPrice = Double.parseDouble(price.first().childNode(0).toString());
			records.add(new DinnahRecord(name.first().childNode(0).toString(), (Math.round(itemPrice)) + ""));
		}

		return new DinnahSet(records, categoryName);
	}
}
