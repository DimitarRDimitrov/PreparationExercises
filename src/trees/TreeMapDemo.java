package trees;

import java.util.TreeMap;

public class TreeMapDemo {
	
	public static void main(String[] args) {
		TreeMap<String,Integer> tm = new TreeMap<>();
		tm.put("Mason", new Integer(55));
		tm.put("Jacob", new Integer(77));
		tm.put("Michael", new Integer(90));
		tm.put("Isabella", new Integer(100));
		
		System.out.println("Course atendants: " + tm.size());
		for(String name: tm.keySet()) {
			System.out.println(name + " scored " +  tm.get(name));
		}
		for(Integer score: tm.values()) {
			System.out.println(score);
		}
		
	}
	
	

}
