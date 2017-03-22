package trees;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = {1,2,3,4,5,6,7,10,50,9};
		
		for (int i: arr) {
			pq.add(i);
		}
		
		System.out.println("Print priority queue: " + pq);
		System.out.println("consequent removal of pq elements");
		while(!pq.isEmpty()) {
			System.out.println("" + pq.remove());
		}
		
		//reverse priority queue
		
		PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i: arr) {
			rpq.add(i);
		}
		System.out.println("Print reverse pq " + rpq);
		while(!rpq.isEmpty()) {
			System.out.println("" + rpq.remove());
		}
		
	}
}
