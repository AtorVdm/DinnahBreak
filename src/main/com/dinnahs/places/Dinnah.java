package com.dinnahs.places;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import com.dinnahs.DinnahSet;

public abstract class Dinnah {
	protected Document doc = null;
	
	public abstract List<DinnahSet> getDinnahs();
	protected abstract DinnahSet parseDishes(String url) throws Exception;
	
	protected void printProcess(String url, boolean success) {
		if (success) {
			System.out.println("URL: [" + url + "] parsed successfully!");
		} else {
			System.err.println("URL: [" + url + "] parsed with errors!");
		}
	}
	
	protected List<DinnahSet> processGetDinnahs(List<String> urls) {
		List<DinnahSet> dinnahs = new ArrayList<DinnahSet>();
		
		try {
			for (String url : urls) {
				DinnahSet ds = parseDishes(url);
				if (ds == null) throw new Exception("Null DinnahSet returned.");
				printProcess(url, true);
				dinnahs.add(ds);
			}
		} catch (Exception ex) {
			System.err.println("Parsing error: " + ex.getMessage());
		}
		
		return dinnahs;
	}
	
	protected Document getInstantConnection(String url) throws IOException {
		Connection connection = Jsoup.connect(url);
		Response response = connection.timeout(5000).ignoreHttpErrors(true).followRedirects(true).execute();
		if (response.statusCode() != 200) return null;
		return connection.get();
	}
	
	protected Document getWaitingConnection(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage(url);
		webClient.waitForBackgroundJavaScript(2 * 1000);
		return Jsoup.parse(page.asXml());
	}
}
