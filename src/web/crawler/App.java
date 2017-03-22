package web.crawler;

import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		String root = "http://offnews.bg/";
		
		BFS bfs = new BFS(50);
		
		try {
			bfs.discoverWeb(root);
		} catch (Exception e) {
			System.out.println(e.getCause() + " - " + e.getMessage());
		}
		
		List<String> sites = bfs.getDiscoveredWebsiteList();
		for(String s: sites) {
			System.out.println("Webiste URL found: " + s);
		}
		
		
		
	}

}
