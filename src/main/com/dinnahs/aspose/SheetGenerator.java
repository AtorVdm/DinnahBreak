package com.dinnahs.aspose;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dinnahs.DinnahSet;

import com.aspose.cells.*;

public class SheetGenerator {
	public static final int LEFT_OFFSET = 3;
	private final int SUMM_ROW_NUMBER = 2; 
	
	private List<String> consumers = getConsumers();
	
	public void processSheet(Worksheet ws, List<DinnahSet> dinnahs) throws Exception {
		Cells cells = ws.getCells();
		
		stretchDateHeader(cells);
		addConsumers(ws);
		addSummRow(cells, dinnahs);
		ws.getCells().setColumnWidthPixel(0, 300);
		addDinnahs(cells, dinnahs);
		ws.autoFitRows();
        System.out.println("SHEET: [" + ws.getName() + "] generated!");
	}

	private void stretchDateHeader(Cells cells) {
		cells.merge(0, 0, 1, LEFT_OFFSET + consumers.size());
	}
	
	private void addConsumers(Worksheet ws) throws Exception {
		Cells cells = ws.getCells();
		for (int i = 0; i < consumers.size(); i++) {
			cells.get(1, LEFT_OFFSET + i).copy(cells.get(1, LEFT_OFFSET));
			cells.get(1, LEFT_OFFSET + i).putValue(consumers.get(i));
			ws.autoFitColumn(LEFT_OFFSET + i);
		}
	}
	
	private void addSummRow(Cells cells, List<DinnahSet> dinnahs) throws Exception {
		int dinnahRowCount = getDinnahRowCount(dinnahs);
		Cell startCell;
		Cell endCell;
		
		startCell = cells.get(SUMM_ROW_NUMBER, LEFT_OFFSET);
		endCell = cells.get(SUMM_ROW_NUMBER, LEFT_OFFSET + consumers.size() - 1);
		cells.get(SUMM_ROW_NUMBER, 1).setFormula(String.format("=Sum(%s:%s)", startCell.getName(), endCell.getName()));
		startCell = cells.get(SUMM_ROW_NUMBER + 1, 2);
		endCell = cells.get(SUMM_ROW_NUMBER + dinnahRowCount + 1 + dinnahs.size() - 1, 2);
		cells.get(SUMM_ROW_NUMBER, 2).setFormula(String.format("=Sum(%s:%s)", startCell.getName(), endCell.getName()));
		
		for (int i = 3; i <= consumers.size() + 2; i++) {
			startCell = cells.get(SUMM_ROW_NUMBER + 1, i);
			endCell = cells.get(SUMM_ROW_NUMBER + dinnahRowCount + 1 + dinnahs.size() - 1, i); 
			cells.get(SUMM_ROW_NUMBER, i).copy(cells.get(SUMM_ROW_NUMBER, LEFT_OFFSET));
			String formula = String.format("=SUMPRODUCT(%s:%s,%s:%s)",
					startCell.getName(), endCell.getName(),
					cells.get(startCell.getRow(), 1).getName(),
					cells.get(endCell.getRow(), 1).getName());
			cells.get(SUMM_ROW_NUMBER, i).setFormula(formula);
		}
	}
	
	private void addDinnahs(Cells cells, List<DinnahSet> dinnahs) throws Exception {
		int shift = getDinnahRowCount(dinnahs);
		// going from bottom to keep cell templates untouched
		for (int j = dinnahs.size() - 1; j >= 0; j--) {
			DinnahSet ds = dinnahs.get(j);
			
			shift -= ds.size();
			
			// placing data rows
			for (int i = 0; i < ds.size(); i++) {
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 0).copy(cells.get(SUMM_ROW_NUMBER + 2, 0));
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 0).putValue(ds.getRecords().get(i).getName());
				
				Style style = cells.get(SUMM_ROW_NUMBER + 2, 0).getStyle();
				style.setTextWrapped(true);
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 0).setStyle(style);
				
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 1).copy(cells.get(SUMM_ROW_NUMBER + 2, 1));
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 1).putValue(Integer.parseInt(ds.getRecords().get(i).getPrice()));
				
				Cell startCell = cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, LEFT_OFFSET);
				Cell endCell = cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, LEFT_OFFSET + consumers.size() - 1);
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 2).copy(cells.get(SUMM_ROW_NUMBER + 2, 2));
				cells.get(SUMM_ROW_NUMBER + shift + i + 2 + j, 2).setFormula(String.format("=Sum(%s:%s)", startCell.getName(), endCell.getName()));
			}
			
			// placing headers
			cells.get(SUMM_ROW_NUMBER + shift + 1 + j, 0).copy(cells.get(SUMM_ROW_NUMBER + 1, 0));
			cells.get(SUMM_ROW_NUMBER + shift + 1 + j, 0).putValue(ds.getCategoryName());
			
			// coloring headers
			Random rand = new Random();
			Color color = Color.fromArgb(rand.nextInt(127) + 128, rand.nextInt(127) + 128, rand.nextInt(127) + 128);
			for (int i = 0; i < LEFT_OFFSET + consumers.size(); i++) {
				Cell cell = cells.get(SUMM_ROW_NUMBER + shift + 1 + j, i);
				if (i > 0) cell.putValue("");
				Style style = cell.getStyle();
				style.setPattern(BackgroundType.SOLID);
				style.setForegroundColor(color);
				cell.setStyle(style);
			}
		}
	}
	
	private int getDinnahRowCount(List<DinnahSet> dinnahs) throws Exception {
		int result = 0;
		for (DinnahSet ds : dinnahs) {
			result += ds.size();
		}
		return result;
	}
	
	public static List<String> getConsumers() {
		List<String> consumers = new ArrayList<String>();
		consumers.add("SP");
		consumers.add("DK");
		consumers.add("KS");
		consumers.add("DM");
		consumers.add("ASh");
		consumers.add("VB");
		consumers.add("ASn");
		consumers.add("YE");
		consumers.add("AN");
		consumers.add("AM");
		consumers.add("OP");
		return consumers;
	}
}
