package searching.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String name;
	private boolean visited;
	private List<Vertex> neighbours;
	private Vertex predecessor;
	
	public Vertex(String name) {
		
		this.name = name;
		neighbours = new ArrayList<>();
		
	}
	
	public void addNeighbour(Vertex vertex) {
		this.neighbours.add(vertex);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public String getName() {
		return name;
	}

	public List<Vertex> getNeighbours() {
		return neighbours;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
