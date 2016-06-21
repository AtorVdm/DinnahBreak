package com.dinnahs;

import java.io.FileInputStream;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import com.dinnahs.places.*;
import com.dinnahs.aspose.SheetGenerator;

public class DinnahMain {

	public static void main(String[] args) {
		/*
		new DinnahCleaner().connectToSpreadSheet(new GoogleDocsInputInfo("", "", "",
				"1ZZcHGVZINQjOU7NVoja2pmzbaCZOgj1YfTJgYVaThLU", AuthorizationData.USERNAME, AuthorizationData.PASSWORD));
		*/
		
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
	    java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
		
		try {
			String path = "/Users/Ator/Projects/Java/DinnahBreak/src/main/dinnahs_template.xlsx";
			FileInputStream fstream = new FileInputStream(path);
			Workbook wb = new Workbook(fstream);
			
			Worksheet rossiWS = wb.getWorksheets().get(0);
			rossiWS.setName("Pizza Rossi");
			Worksheet supWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			supWS.setName("SuP");
			//Worksheet prestoWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			//prestoWS.setName("Presto");
			Worksheet japoshkaWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			japoshkaWS.setName("Yaposhka");
			Worksheet bellaWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			bellaWS.setName("Pizza Bella");
			Worksheet tuktukWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			tuktukWS.setName("Tuk-Tuk");
			Worksheet barbarisWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			barbarisWS.setName("Barbaris");
			Worksheet maranelloWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			maranelloWS.setName("Maranello");
			Worksheet sushiyaWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			sushiyaWS.setName("Sushiya");
			Worksheet italianiWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			italianiWS.setName("Italiani");
			Worksheet meetmeatWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			meetmeatWS.setName("Meet&Meat");
			Worksheet teremokWS = wb.getWorksheets().get(wb.getWorksheets().addCopy(rossiWS.getName()));
			teremokWS.setName("Teremok");
			
			new SheetGenerator().processSheet(italianiWS, new ItalianiDinnah().getDinnahs());
			new SheetGenerator().processSheet(rossiWS, new PizzaRossiDinnah().getDinnahs());
			new SheetGenerator().processSheet(supWS, new SupDinnah().getDinnahs());
			//new SheetGenerator().processSheet(prestoWS, new PrestoDinnahs().getDinnahs());
			new SheetGenerator().processSheet(japoshkaWS, new JaposhkaDinnah().getDinnahs());
			new SheetGenerator().processSheet(bellaWS, new BellaDinnah().getDinnahs());
			new SheetGenerator().processSheet(tuktukWS, new TukTukDinnah().getDinnahs());
			new SheetGenerator().processSheet(barbarisWS, new BarbarisDinnah().getDinnahs());
			new SheetGenerator().processSheet(maranelloWS, new MaranelloDinnah().getDinnahs());
			new SheetGenerator().processSheet(sushiyaWS, new SushiyaDinnah().getDinnahs());
			new SheetGenerator().processSheet(meetmeatWS, new MeetMeatDinnah().getDinnahs());
			new SheetGenerator().processSheet(teremokWS, new TeremokDinnah().getDinnahs());
			
			// hardcoding data on sheets
			//prestoWS.getCells().get(2, 1).setFormula(prestoWS.getCells().get(2, 1).getFormula() + "*" + 1.05);
			supWS.getCells().get(0, SheetGenerator.LEFT_OFFSET + SheetGenerator.getConsumers().size()).setValue("(099) 016-71-19");
			supWS.getCells().get(0, SheetGenerator.LEFT_OFFSET + SheetGenerator.getConsumers().size() + 1).setValue("(097) 627-70-03");
			supWS.getCells().get(0, SheetGenerator.LEFT_OFFSET + SheetGenerator.getConsumers().size() + 2).setValue("(093) 715-14-65");
			supWS.getCells().get(1, SheetGenerator.LEFT_OFFSET + SheetGenerator.getConsumers().size()).setValue("http://www.sushipizza.cc.ua/pizza30.html");
			
			wb.save(path.replace("_template.xls", ".xls"));
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("Aspose exception: " + e.getMessage());
		}
	}
}