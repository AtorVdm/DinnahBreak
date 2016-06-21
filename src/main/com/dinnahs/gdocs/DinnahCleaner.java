/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinnahs.gdocs;
/*
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;
*/
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

public class DinnahCleaner {/*
	public void connectToSpreadSheet(GoogleDocsInputInfo inputData) {
		try {
			connectToSpreadSheetUnsafe(inputData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private void connectToSpreadSheetUnsafe(GoogleDocsInputInfo inputData) throws IOException, ServiceException, GeneralSecurityException {
        String username = inputData.getUsername();
        String password = inputData.getPassword();
        
        SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration");
        service.setUserCredentials(username, password);
        service.useSsl();
        
        // Define the URL to request.  This should never change.
        URL SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");

        // Make a request to the API and get all spreadsheets.
        List<SpreadsheetEntry> spreadsheets = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class).getEntries();

        if (spreadsheets.size() == 0) {
        	return;
        }
        
        SpreadsheetEntry spreadsheet = spreadsheets.stream()
        		.filter(ss -> ss.getKey().equals(inputData.getExcelFileId()))
        		.collect(Collectors.toList()).get(0);
        
        WorksheetFeed worksheetFeed = service.getFeed(spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
        List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
        /*
        WorksheetEntry worksheet = worksheets.stream()
        		.filter(ss -> ss.getTitle().getPlainText().equals(summarySheetName))
        		.collect(Collectors.toList()).get(0);
        *//*
        for (WorksheetEntry worksheet : worksheets) {
	        CellFeed cellFeed = service.getFeed(worksheet.getCellFeedUrl(), CellFeed.class);
	        
	        CellEntry cellEntry;
	        for (int i = 4; i < cellFeed.getRowCount(); i++) {
	        	for (int j = 3; j < cellFeed.getColCount(); j++) {
	        		cellEntry = new CellEntry(i, j, "");
	        		cellFeed.insert(cellEntry);
	        	}
	        }
        }
        
        System.out.println("Done!");
    }
    
    @SuppressWarnings("unused")
	private void oldCode() {
    	/*
        WorksheetFeed worksheetFeed = service.getFeed(
            spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
        List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
        WorksheetEntry worksheet = worksheets.stream()
        		.filter(ss -> ss.getTitle().getPlainText().equals(summarySheetName))
        		.collect(Collectors.toList()).get(0);

        CellFeed cellFeed = service.getFeed(worksheet.getCellFeedUrl(), CellFeed.class);
        
        CellEntry cellEntry;
        
        String[] processingSheets = cellFeed.getEntries().get(0).getPlainTextContent().split(",");
        
        int line = 2;
        for (String sheetName : processingSheets) {
        	Map<String, Integer> dataCollected = collectData(worksheets.stream()
            		.filter(ss -> ss.getTitle().getPlainText().equals(sheetName))
            		.collect(Collectors.toList()).get(0));
        	
        	cellEntry = new CellEntry(line++, 1, sheetName);
            cellFeed.insert(cellEntry);
        	for (String dishName : dataCollected.keySet()) {
        		cellEntry = new CellEntry(line, 1, dishName);
                cellFeed.insert(cellEntry);
                cellEntry = new CellEntry(line, 2, dataCollected.get(dishName).toString());
                cellFeed.insert(cellEntry);
                line++;
        	}
        }
        
        @SuppressWarnings("unused")
    	private Map<String, Integer> collectData(WorksheetEntry worksheetEntry) {
        	Map<String, Integer> testMap = new HashMap<String, Integer>();
        	testMap.put("TestDish1", 3);
        	testMap.put("TestDish2", 1);
        	testMap.put("TestDish3", 6);
        	testMap.put("TestDish4", 2);
    		return testMap;
    	}
        
        private List<String> getConsumers() {
        	List<String> consumers = new ArrayList<String>();
        	consumers.add("AA");
        	consumers.add("BB");
        	consumers.add("CC");
        	consumers.add("DD");
        	return consumers;
        }*//*
    }*/
}
