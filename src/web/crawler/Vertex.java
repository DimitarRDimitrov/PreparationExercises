package web.crawler;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private boolean visited;
	private Vertex previousVertex;
	private List<Vertex> adjecencyList;
	
	public Vertex(String name) {
		this.name = name;
		adjecencyList = new ArrayList<>();
	}
	
	public void addNeighbour(Vertex vertex) {
		this.adjecencyList.add(vertex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Vertex> getAdjecencyList() {
		return adjecencyList;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
	
}
