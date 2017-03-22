package searching.dfs;

import java.util.Stack;

public class DepthFirstSearch {

	private Stack<Vertex> stack;
	
	public DepthFirstSearch() {
		this.stack = new Stack<>();
	}
	
	public void dfs(Vertex root) {
		stack.add(root);
		root.setVisited(true);
		
		while(!stack.isEmpty()) {
			
			Vertex v = stack.pop();
			
			//check if == searched
			
			System.out.println(v.getName() + "-");
			
			for(Vertex w: v.getNeighbours()){
				if(!w.isVisited()){
					w.setPredecessor(v);
					stack.add(w);
					v.setVisited(true);
				}
			}
		}
	}
	
	public void dfsRecursive(Vertex root) {
		if(root.isVisited()) {
			return;
		}
		
		root.setVisited(true);
		System.out.print(root.getName() + "-");
		for(Vertex v: root.getNeighbours()){
			v.setPredecessor(root);
			dfsRecursive(v);
			v.setVisited(true);
		}
	}
	
	
	
}
