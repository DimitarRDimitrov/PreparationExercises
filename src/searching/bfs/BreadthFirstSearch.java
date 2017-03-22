package searching.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	
	public <T> void bfs(Vertex<T> root) {
		
		Queue<Vertex<T>> queue = new LinkedList<>();
		
		root.setVisited(true);
		queue.add(root);
		
		
		while(!queue.isEmpty()) {
			Vertex<T> actualVertex = queue.remove();
			System.out.print(actualVertex + "-");
			
			for(Vertex<T> v: actualVertex.getNeighbourList()){
				if(!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
		
	}

}
