package com.dinnahs;

import java.util.ArrayList;
import java.util.List;

public class DinnahSet {
	private List<DinnahRecord> records = new ArrayList<DinnahRecord>();
	private String categoryName;
	
	public DinnahSet(List<DinnahRecord> records, String categoryName) {
		super();
		this.records = records;
		this.categoryName = categoryName;
	}

	public List<DinnahRecord> getRecords() {
		return records;
	}

	public void setRecords(List<DinnahRecord> records) {
		this.records = records;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int size() {
		return records.size();
	}
}
